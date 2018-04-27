package com.abdts.dao.teacher;


import com.abdts.entity.teacher.MenuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 * @author zy
 */
@Mapper
public interface MenuDao {

	MenuDO get(int menuId);
	
	List<MenuDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MenuDO menu);
	
	int update(MenuDO menu);
	
	int remove(int menuId);
	
	int batchRemove(int[] menuIds);
	
	List<MenuDO> listMenuByUserId(int id);
	
	List<String> listUserPerms(int id);
}
