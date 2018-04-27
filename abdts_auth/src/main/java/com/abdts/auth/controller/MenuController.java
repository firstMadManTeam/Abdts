package com.abdts.auth.controller;

import com.abdts.common.util.BaseController;
import com.abdts.common.util.DataKeyPair;
import com.abdts.common.util.SuccessOrFailure;
import com.abdts.common.util.Tree;
import com.abdts.entity.teacher.MenuDO;
import com.abdts.service.teacher.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zy
 */
@RequestMapping("/menu")
@RestController
public class MenuController extends BaseController {

	@Autowired
    MenuService menuService;

//	@RequiresPermissions("sys:menu:menu")
	@RequestMapping("/list")
    SuccessOrFailure list(@RequestParam Map<String, Object> params) {
        List<MenuDO> menus;
        try {
            menus = menuService.list(params);
        } catch (Exception e) {
            return SuccessOrFailure.FAILURE(e.getMessage());
        }
        return SuccessOrFailure.SUCCESS(menus);
	}

    /**
     * 跳转添加页面
     * @param pId
     * @return
     */
//	@RequiresPermissions("menu:add")
	@GetMapping("/add/{pId}")
    SuccessOrFailure add(@PathVariable("pId") Integer pId) {
		DataKeyPair dkp = this.getDataKeyPair();
        dkp.put("pId", pId);
		if (pId == 0) {
			dkp.put("pName", "根目录");
		} else {
            dkp.put("pName", menuService.get(pId).getName());
		}
		return SuccessOrFailure.SUCCESS(dkp);
	}

//	@RequiresPermissions("sys:menu:edit")
	@GetMapping("/edit/{id}")
	SuccessOrFailure edit(@PathVariable("id") Integer id) {
		MenuDO mdo = menuService.get(id);
		Integer pId = mdo.getParentId();
        DataKeyPair dkp = this.getDataKeyPair();
        dkp.put("pId", pId);
        if (pId == 0) {
			dkp.put("pName", "根目录");
		} else {
            dkp.put("pName", menuService.get(pId).getName());
		}
		dkp.put("menu", mdo);
		return SuccessOrFailure.SUCCESS(dkp);
	}

//	@RequiresPermissions("sys:menu:add")
	@PostMapping("/save")
    SuccessOrFailure save(@RequestBody MenuDO menu) {
        try {
            menuService.save(menu);
        } catch (Exception e) {
            return SuccessOrFailure.FAILURE(e.getMessage());
        }
        return SuccessOrFailure.SUCCESS;
    }

//	@RequiresPermissions("sys:menu:edit")
	@PostMapping("/update")
    SuccessOrFailure update(MenuDO menu) {
        try {
            menuService.update(menu);
        } catch (Exception e) {
            return SuccessOrFailure.FAILURE(e.getMessage());
        }
        return SuccessOrFailure.SUCCESS;
    }

//	@RequiresPermissions("sys:menu:remove")
	@PostMapping("/remove")
	SuccessOrFailure remove(Integer id) {
        try {
            menuService.remove(id);
        } catch (Exception e) {
            return SuccessOrFailure.FAILURE(e.getMessage());
        }
        return SuccessOrFailure.SUCCESS;
    }

	@GetMapping("/tree")
    SuccessOrFailure tree() {
        Tree<MenuDO> tree;
        try {
            tree = menuService.getTree();
        } catch (Exception e) {
            return SuccessOrFailure.FAILURE(e.getMessage());
        }
        return SuccessOrFailure.SUCCESS(tree);
	}

	@GetMapping("/tree/{roleId}")
    SuccessOrFailure tree(@PathVariable("roleId") Integer roleId) {
        Tree<MenuDO> tree;
        try {
            tree = menuService.getTree(roleId);
        } catch (Exception e) {
            return SuccessOrFailure.FAILURE(e.getMessage());
        }
        return SuccessOrFailure.SUCCESS(tree);
	}
}
