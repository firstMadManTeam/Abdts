package com.abdts.auth.shiro;


import com.abdts.auth.util.ShiroUtils;
import com.abdts.entity.teacher.TeacherList;
import com.abdts.service.teacher.MenuService;
import com.abdts.service.teacher.TeacherListService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author private
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    TeacherListService userService;

    @Autowired
    MenuService menuService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Integer userId = ShiroUtils.getUserId();
        Set<String> perms = menuService.listPerms(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(perms);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        Map<String, Object> map = new HashMap<>(16);
        map.put("publicTeacherlistPhone", username);
        String password = new String((char[]) token.getCredentials());

        // 查询用户信息
        TeacherList user = userService.list(map).get(0);

        // 账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        // 密码错误
        if (!password.equals(user.getPublicTeacherlistPwd())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
