package com.abdts.service.teacher;

import com.abdts.entity.teacher.TeacherList;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zy
 */
public interface TeacherListService {

    TeacherList get(int publicTeacherlistId);

    List<TeacherList> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(TeacherList user);

    int update(TeacherList user);

    int remove(int userId);

    int batchremove(int[] userIds);

    boolean exit(Map<String, Object> params);

    Set<String> listRoles(int userId);

    /**
     * 更新个人信息
     * @param userDO
     * @return
     */
    int updatePersonal(TeacherList userDO);

}
