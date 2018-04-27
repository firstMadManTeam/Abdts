package com.abdts.auth.controller;

import com.abdts.auth.util.MD5Utils;
import com.abdts.auth.util.ShiroUtils;
import com.abdts.common.util.SuccessOrFailure;
import com.abdts.common.util.Tree;
import com.abdts.entity.teacher.MenuDO;
import com.abdts.entity.teacher.TeacherList;
import com.abdts.service.teacher.MenuService;
import com.abdts.service.teacher.TeacherListService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author private
 */
@RestController
public class LoginController extends Base {

    /**
     * 菜单业务
     */
    @Autowired
    MenuService menuService;

    /**
     * 用户业务
     */
    @Autowired
    TeacherListService userService;

    /**
     * 用户登陆
     *
     * @param userName 账号
     * @param password 密码
     * @return { message: {}|"" , success:true|false }
     */
    @GetMapping("/login")
    SuccessOrFailure login(String userName, String password) {
        // Hash 加密
        password = MD5Utils.encrypt(userName, password);
        // 构建 token
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        // 管理
        Subject subject = SecurityUtils.getSubject();
        try {
            // 登陆
            subject.login(token);
        } catch (AuthenticationException e) {
            return SuccessOrFailure.FAILURE("用户名或密码错误");
        }
        return SuccessOrFailure.SUCCESS;
    }

    @GetMapping("/logout")
    SuccessOrFailure logout() {
        ShiroUtils.logout();
        return SuccessOrFailure.SUCCESS;
    }

    /**
     * 请求主页
     */
    @GetMapping("/index")
    SuccessOrFailure index() {
        if (getUser() == null) {
            return SuccessOrFailure.FAILURE("token 失效");
        }
        List<Tree<MenuDO>> menus = menuService.listMenuTree(getUserId());
        Map<String, Object> dkp = new HashMap<>(2);
        dkp.put("menus", menus);
        return SuccessOrFailure.SUCCESS(dkp);
    }

    @GetMapping("/teacher")

    TeacherList getTeacher(){
        return getUser();
    }

    @GetMapping("/get/{id}")
    SuccessOrFailure get(@PathVariable Integer id) {
        TeacherList ss = userService.get(id);
        return SuccessOrFailure.SUCCESS(ss);
    }

}
