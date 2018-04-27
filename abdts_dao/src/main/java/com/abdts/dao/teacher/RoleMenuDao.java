package com.abdts.dao.teacher;


import com.abdts.entity.teacher.RoleMenuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 角色与菜单对应关系
 * @author zy
 */
@Mapper
public interface RoleMenuDao {

	RoleMenuDO get(int id);
	
	List<RoleMenuDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RoleMenuDO roleMenu);
	
	int update(RoleMenuDO roleMenu);
	
	int remove(int id);
	
	int batchRemove(int[] ids);
	
	List<Long> listMenuIdByRoleId(int roleId);
	
	int removeByRoleId(int roleId);

	int removeByMenuId(int menuId);
	
	int batchSave(List<RoleMenuDO> list);
}
