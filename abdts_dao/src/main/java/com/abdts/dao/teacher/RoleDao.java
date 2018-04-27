package com.abdts.dao.teacher;

import com.abdts.entity.teacher.RoleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色数据接口
 * @author zy
 */
@Mapper
public interface RoleDao {

    RoleDO get(int roleId);

    List<RoleDO> list(Map<Object, Object> map);

    int count(Map<Object, Object> map);

    int save(RoleDO role);

    int update(RoleDO role);

    int remove(int roleId);

    int batchRemove(int[] roleIds);

}
