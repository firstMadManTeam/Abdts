package com.abdts.service.teacher;

import com.abdts.common.util.Tree;
import com.abdts.entity.teacher.MenuDO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zy
 */
@Service
public interface MenuService {
	Tree<MenuDO> getSysMenuTree(int id);

	List<Tree<MenuDO>> listMenuTree(int id);

	Tree<MenuDO> getTree();

	Tree<MenuDO> getTree(int id);

	List<MenuDO> list(Map<String, Object> params);

	int remove(int id);

	int save(MenuDO menu);

	int update(MenuDO menu);

	MenuDO get(int id);

	Set<String> listPerms(int userId);
}
