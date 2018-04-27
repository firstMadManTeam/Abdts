package com.abdts.auth.controller;

import com.abdts.auth.util.MD5Utils;
import com.abdts.common.util.BaseController;
import com.abdts.common.util.DataKeyPair;
import com.abdts.common.util.SuccessOrFailure;
import com.abdts.entity.teacher.RoleDO;
import com.abdts.entity.teacher.TeacherList;
import com.abdts.service.teacher.RoleService;
import com.abdts.service.teacher.TeacherListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zy
 */
@RequestMapping("/user")
@RestController
public class UserController extends BaseController {

	@Autowired
    TeacherListService userService;

	@Autowired
    RoleService roleService;

	@GetMapping("/list")
    SuccessOrFailure list(@RequestParam Map<String, Object> params) {
        List<TeacherList> sysUserList;
        try {
            sysUserList = userService.list(params);
        } catch (Exception e) {
            return SuccessOrFailure.FAILURE(e.getMessage());
        }
        return SuccessOrFailure.SUCCESS(sysUserList);
	}

//	@RequiresPermissions("sys:user:add")
	@GetMapping("/add")
    SuccessOrFailure add() {
        List<RoleDO> roles;
        try {
            roles = roleService.list();
        } catch (Exception e) {
            return SuccessOrFailure.FAILURE(e.getMessage());
        }
        return SuccessOrFailure.SUCCESS(roles);
	}

//	@RequiresPermissions("sys:user:edit")
	@GetMapping("/edit/{id}")
    SuccessOrFailure edit(@PathVariable("id") Integer id) {
		TeacherList userDO = userService.get(id);
		List<RoleDO> roles = roleService.list(id);
        DataKeyPair dkp = this.getDataKeyPair();
        dkp.put("user", userDO);
        dkp.put("roles", roles);
		return SuccessOrFailure.SUCCESS(dkp);
	}

//	@RequiresPermissions("sys:user:add")
	@PostMapping("/save")
    SuccessOrFailure save(TeacherList user) {
		user.setPublicTeacherlistPwd(MD5Utils.encrypt(user.getPublicTeacherlistName(), user.getPublicTeacherlistPwd()));
        try {
            userService.save(user);
        } catch (Exception e) {
            return SuccessOrFailure.FAILURE(e.getMessage());
        }
        return SuccessOrFailure.SUCCESS;
    }

//	@RequiresPermissions("sys:user:edit")
	@PostMapping("/update")
	SuccessOrFailure update(TeacherList user) {
        try {
            userService.update(user);
        } catch (Exception e) {
            return SuccessOrFailure.FAILURE(e.getMessage());
        }
        return SuccessOrFailure.SUCCESS;
    }




//	@RequiresPermissions("sys:user:remove")
	@PostMapping("/remove")
	SuccessOrFailure remove(Integer id) {
        try {
            userService.remove(id);
        } catch (Exception e) {
            return SuccessOrFailure.FAILURE(e.getMessage());
        }
        return SuccessOrFailure.SUCCESS;
    }

//	@RequiresPermissions("sys:user:batchRemove")
	@PostMapping("/batchRemove")
	SuccessOrFailure batchRemove(@RequestParam("ids[]") int[] userIds) {
        try {
            userService.batchremove(userIds);
        } catch (Exception e) {
            return SuccessOrFailure.FAILURE(e.getMessage());
        }
        return SuccessOrFailure.SUCCESS;
    }

	@PostMapping("/exit")
	boolean exit(@RequestParam Map<String, Object> params) {
		// 存在，不通过，false
		return !userService.exit(params);
	}

}
