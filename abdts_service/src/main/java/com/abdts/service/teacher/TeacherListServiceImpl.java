package com.abdts.service.teacher;

import com.abdts.dao.teacher.TeacherListDao;
import com.abdts.dao.teacher.UserRoleDao;
import com.abdts.entity.teacher.TeacherList;
import com.abdts.entity.teacher.UserRoleDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author zy
 */
@Transactional
@Service
public class TeacherListServiceImpl implements TeacherListService {

    @Autowired
    public TeacherListDao teacherListDao;

    @Autowired
    UserRoleDao userRoleDao;


    private static final Logger logger = LoggerFactory.getLogger(TeacherListService.class);

    @Override
    public TeacherList get(int id) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("publicTeacherId", id);
        return list(map).get(0);
    }

    @Override
    public List<TeacherList> list(Map<String, Object> map) {
        List<TeacherList> userList = teacherListDao.list(map);
        for (TeacherList user : userList) {
            List<Integer> roleIds = userRoleDao.listRoleId(user.getPublicTeacherlistId());
            user.setRoleIds(roleIds);
        }
        return userList;
    }

    @Override
    public int count(Map<String, Object> map) {
        return teacherListDao.count(map);
    }

    @Transactional
    @Override
    public int save(TeacherList user) {
        int count = teacherListDao.save(user);
        Integer userId = user.getPublicTeacherlistId();
        List<Integer> roles = user.getRoleIds();
        userRoleDao.removeByUserId(userId);
        List<UserRoleDO> list = new ArrayList<>();
        for (Integer roleId : roles) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        if (list.size() > 0) {
            userRoleDao.batchSave(list);
        }
        return count;
    }

    @Override
    public int update(TeacherList user) {
        int r = teacherListDao.update(user);
        Integer userId = user.getPublicTeacherlistId();
        List<Integer> roles = user.getRoleIds();
        userRoleDao.removeByUserId(userId);
        List<UserRoleDO> list = new ArrayList<>();
        for (Integer roleId : roles) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        if (list.size() > 0) {
            userRoleDao.batchSave(list);
        }
        return r;
    }

    @Override
    public int remove(int userId) {
        userRoleDao.removeByUserId(userId);
        return teacherListDao.remove(userId);
    }

    @Override
    public boolean exit(Map<String, Object> params) {
        boolean exit;
        exit = teacherListDao.list(params).size() > 0;
        return exit;
    }

    @Override
    public Set<String> listRoles(int userId) {
        return null;
    }


    @Transactional
    @Override
    public int batchremove(int[] userIds) {
        int count = teacherListDao.batchRemove(userIds);
        userRoleDao.batchRemoveByUserId(userIds);
        return count;
    }


    @Override
    public int updatePersonal(TeacherList userDO) {
        return teacherListDao.update(userDO);
    }

}
