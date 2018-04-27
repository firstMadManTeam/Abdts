package com.abdts.dao.teacher;

import com.abdts.entity.teacher.TeacherList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author zy
 */
@Mapper
public interface TeacherListDao {

    TeacherList get(int publicTeacherlistId);

    List<TeacherList> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(TeacherList user);

    int update(TeacherList user);

    int remove(int userId);

    int batchRemove(int[] userIds);

}
