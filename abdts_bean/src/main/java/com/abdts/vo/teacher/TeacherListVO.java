package com.abdts.vo.teacher;

import com.abdts.entity.teacher.TeacherList;

/**
 * @author pzy
 */
public class TeacherListVO extends TeacherList {

    private String teacher_identity_text = null;

    public String getTeacher_identity_text() {
        return teacher_identity_text;
    }

    public void setTeacher_identity_text(String teacher_identity_text) {
        this.teacher_identity_text = teacher_identity_text;
    }
}
