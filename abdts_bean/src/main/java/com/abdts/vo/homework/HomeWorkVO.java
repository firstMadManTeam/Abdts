package com.abdts.vo.homework;

import com.abdts.entity.homework.HomeWrok;

/**
 * @author pzy
 */
public class HomeWorkVO extends HomeWrok {

    private String public_subject_name=null;

    private String public_teacherlist_name = null;

    public String getPublic_subject_name() {
        return public_subject_name;
    }

    public void setPublic_subject_name(String public_subject_name) {
        this.public_subject_name = public_subject_name;
    }

    public String getPublic_teacherlist_name() {
        return public_teacherlist_name;
    }

    public void setPublic_teacherlist_name(String public_teacherlist_name) {
        this.public_teacherlist_name = public_teacherlist_name;
    }
}
