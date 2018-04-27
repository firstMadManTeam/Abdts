package com.abdts.vo.notice;

import com.abdts.entity.notice.Notice;

/**
 * @author pzy
 */
public class NoticeVO extends Notice {

    private String public_teacherlist_name = null;

    private String teacher_identity_text = null;


    public String getPublic_teacherlist_name() {
        return public_teacherlist_name;
    }

    public void setPublic_teacherlist_name(String public_teacherlist_name) {
        this.public_teacherlist_name = public_teacherlist_name;
    }

    public String getTeacher_identity_text() {
        return teacher_identity_text;
    }

    public void setTeacher_identity_text(String teacher_identity_text) {
        this.teacher_identity_text = teacher_identity_text;
    }
}
