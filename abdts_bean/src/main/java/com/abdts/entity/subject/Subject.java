package com.abdts.entity.subject;

import java.io.Serializable;

/**
 * @author pzy
 */
public class Subject implements Serializable{

    private Integer public_subject_id = null;
    private String public_subject_name = null;

    public Integer getPublic_subject_id() {
        return public_subject_id;
    }

    public void setPublic_subject_id(Integer public_subject_id) {
        this.public_subject_id = public_subject_id;
    }

    public String getPublic_subject_name() {
        return public_subject_name;
    }

    public void setPublic_subject_name(String public_subject_name) {
        this.public_subject_name = public_subject_name;
    }
}
