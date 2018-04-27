package com.abdts.entity.exam;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pzy
 */
public class Exam implements Serializable{

    private Integer public_exam_id = null;
    private String public_exam_name = null;
    private Integer public_exam_subject = null;
    private Integer public_exam_gradeid = null;
    private Integer public_exam_schoolid = null;
    private Date public_exam_datetime = null;

    public Date getPublic_exam_datetime() {
        return public_exam_datetime;
    }

    public void setPublic_exam_datetime(Date public_exam_datetime) {
        this.public_exam_datetime = public_exam_datetime;
    }

    public Integer getPublic_exam_id() {
        return public_exam_id;
    }

    public void setPublic_exam_id(Integer public_exam_id) {
        this.public_exam_id = public_exam_id;
    }

    public String getPublic_exam_name() {
        return public_exam_name;
    }

    public void setPublic_exam_name(String public_exam_name) {
        this.public_exam_name = public_exam_name;
    }

    public Integer getPublic_exam_subject() {
        return public_exam_subject;
    }

    public void setPublic_exam_subject(Integer public_exam_subject) {
        this.public_exam_subject = public_exam_subject;
    }

    public Integer getPublic_exam_gradeid() {
        return public_exam_gradeid;
    }

    public void setPublic_exam_gradeid(Integer public_exam_gradeid) {
        this.public_exam_gradeid = public_exam_gradeid;
    }

    public Integer getPublic_exam_schoolid() {
        return public_exam_schoolid;
    }

    public void setPublic_exam_schoolid(Integer public_exam_schoolid) {
        this.public_exam_schoolid = public_exam_schoolid;
    }
}
