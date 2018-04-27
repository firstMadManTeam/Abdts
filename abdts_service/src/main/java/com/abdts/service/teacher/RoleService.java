package com.abdts.service.teacher;

import com.abdts.entity.teacher.RoleDO;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author zy
 */
@Service
public interface RoleService {

	RoleDO get(int id);

	List<RoleDO> list();

	int save(RoleDO role);

	int update(RoleDO role);

	int remove(int id);

	List<RoleDO> list(int userId);

	int batchremove(int[] ids);
}
