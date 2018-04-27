package com.abdts.entity.student;

import java.io.Serializable;

/**
 * @author pzy
 */
public class StudentClass implements Serializable{

    //班级id
    private Integer class_id = null;

    //班级几班
    private String class_text = null;

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getClass_text() {
        return class_text;
    }

    public void setClass_text(String class_text) {
        this.class_text = class_text;
    }
}
