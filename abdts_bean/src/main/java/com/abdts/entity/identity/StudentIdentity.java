package com.abdts.entity.identity;

import java.io.Serializable;

/**
 * @author pzy
 */
public class StudentIdentity implements Serializable{

    private Integer student_identity_id;

    private String student_identity_text = null;

    public Integer getStudent_identity_id() {
        return student_identity_id;
    }

    public void setStudent_identity_id(Integer student_identity_id) {
        this.student_identity_id = student_identity_id;
    }

    public String getStudent_identity_text() {
        return student_identity_text;
    }

    public void setStudent_identity_text(String student_identity_text) {
        this.student_identity_text = student_identity_text;
    }
}
