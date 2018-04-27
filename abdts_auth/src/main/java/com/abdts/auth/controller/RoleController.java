package com.abdts.auth.controller;

import com.abdts.common.util.BaseController;
import com.abdts.common.util.SuccessOrFailure;
import com.abdts.entity.teacher.RoleDO;
import com.abdts.service.teacher.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * @author zy
 */
@RequestMapping("/role")
@RestController
public class RoleController extends BaseController {

	@Autowired
    RoleService roleService;

//	@RequiresPermissions("sys:role:role")
	@GetMapping("/list")
	List<RoleDO> list() {
		List<RoleDO> roles = roleService.list();
		return roles;
	}

//	@RequiresPermissions("sys:role:add")

//	@RequiresPermissions("sys:role:edit")
	@GetMapping("/edit/{id}")
    SuccessOrFailure edit(@PathVariable("id") Integer id) {
        RoleDO roleDO;
        try {
            roleDO = roleService.get(id);
        } catch (Exception e) {
            return SuccessOrFailure.FAILURE(e.getMessage());
        }
        return SuccessOrFailure.SUCCESS(roleDO);
	}

//	@RequiresPermissions("sys:role:add")
	@GetMapping("/save")
	SuccessOrFailure save(RoleDO role) {
        try {
            roleService.save(role);
        } catch (Exception e) {
            return SuccessOrFailure.FAILURE(e.getMessage());
        }
        return SuccessOrFailure.SUCCESS;
    }

//	@RequiresPermissions("sys:role:edit")
	@PostMapping("/update")
	SuccessOrFailure update(RoleDO role) {
        try {
            roleService.update(role);
        } catch (Exception e) {
            return SuccessOrFailure.FAILURE(e.getMessage());
        }
        return SuccessOrFailure.SUCCESS;
    }

//	@RequiresPermissions("sys:role:remove")
	@PostMapping("/remove")
	SuccessOrFailure save(Integer id) {
        try {
            roleService.remove(id);
        } catch (Exception e) {
            return SuccessOrFailure.FAILURE(e.getMessage());
        }
        return SuccessOrFailure.SUCCESS;
    }
	
//	@RequiresPermissions("sys:role:batchRemove")
	@PostMapping("/batchRemove")
	SuccessOrFailure batchRemove(@RequestParam("ids[]") int[] ids) {
		int r = roleService.batchremove(ids);
		if (r > 0) {
			return SuccessOrFailure.SUCCESS;
		}
		return SuccessOrFailure.FAILURE("删除失败,请检查 ids : " + Arrays.asList(ids));
	}
}
