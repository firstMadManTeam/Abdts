package com.abdts.entity.grade;

import java.io.Serializable;

/**
 * @author pzy
 */
public class Grade implements Serializable{

    private Integer public_grade_id = null;

    private String public_grade_name = null;

    public Integer getPublic_grade_id() {
        return public_grade_id;
    }

    public void setPublic_grade_id(Integer public_grade_id) {
        this.public_grade_id = public_grade_id;
    }

    public String getPublic_grade_name() {
        return public_grade_name;
    }

    public void setPublic_grade_name(String public_grade_name) {
        this.public_grade_name = public_grade_name;
    }
}
