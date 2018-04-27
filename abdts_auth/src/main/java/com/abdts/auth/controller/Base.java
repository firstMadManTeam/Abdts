package com.abdts.auth.controller;

import com.abdts.auth.util.ShiroUtils;
import com.abdts.entity.teacher.TeacherList;
import org.springframework.stereotype.Controller;

/**
 * @author zy
 */
@Controller
public class Base {

    public TeacherList getUser() {
        return ShiroUtils.getUser();
    }

    public Integer getUserId() {
        return getUser().getPublicTeacherlistId();
    }

    public String getUsername() {
        return getUser().getPublicTeacherlistName();
    }

}
