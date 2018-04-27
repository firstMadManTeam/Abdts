package com.abdts.entity.homework;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pzy
 */
public class HomeWrok implements Serializable {

    private Integer public_homework_id;
    private Date public_homework_datetime;
    private Integer public_homework_teacherid;
    private String public_homework_content;
    private Integer public_homework_subjectid;
    private String public_homework_title;

    public Integer getPublic_homework_id() {
        return public_homework_id;
    }

    public void setPublic_homework_id(Integer public_homework_id) {
        this.public_homework_id = public_homework_id;
    }

    public Date getPublic_homework_datetime() {
        return public_homework_datetime;
    }

    public void setPublic_homework_datetime(Date public_homework_datetime) {
        this.public_homework_datetime = public_homework_datetime;
    }

    public Integer getPublic_homework_teacherid() {
        return public_homework_teacherid;
    }

    public void setPublic_homework_teacherid(Integer public_homework_teacherid) {
        this.public_homework_teacherid = public_homework_teacherid;
    }

    public String getPublic_homework_content() {
        return public_homework_content;
    }

    public void setPublic_homework_content(String public_homework_content) {
        this.public_homework_content = public_homework_content;
    }

    public Integer getPublic_homework_subjectid() {
        return public_homework_subjectid;
    }

    public void setPublic_homework_subjectid(Integer public_homework_subjectid) {
        this.public_homework_subjectid = public_homework_subjectid;
    }

    public String getPublic_homework_title() {
        return public_homework_title;
    }

    public void setPublic_homework_title(String public_homework_title) {
        this.public_homework_title = public_homework_title;
    }
}
