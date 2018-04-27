package com.abdts.dao.teacher;


import com.abdts.entity.teacher.UserRoleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户与角色对应关系
 * @author zy
 */
@Mapper
public interface UserRoleDao {

	UserRoleDO get(int id);

	List<UserRoleDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(UserRoleDO userRole);

	int update(UserRoleDO userRole);

	int remove(int id);

	int batchRemove(int[] ids);

	List<Integer> listRoleId(int userId);

	int removeByUserId(int userId);

	int removeByRoleId(int roleId);

	int batchSave(List<UserRoleDO> list);

	int batchRemoveByUserId(int[] ids);
}
