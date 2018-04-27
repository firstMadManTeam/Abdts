package com.abdts.entity.student;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pzy
 */
public class StudentList implements Serializable{

    @Field
    private long student_id;

    @Field
    private String student_name;

    @Field
    private Integer student_sex;

    @Field
    private Integer student_age;

    @Field
    private Integer student_state;

    private Integer student_identity;

    private Integer student_gradeid;

    @Field
    private Integer student_classid;

    @Field
    private Date student_birthday;

    @Field
    private Date student_modifytime;

    @Field
    private String student_modifyteacher;

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Integer getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(Integer student_sex) {
        this.student_sex = student_sex;
    }

    public Integer getStudent_age() {
        return student_age;
    }

    public void setStudent_age(Integer student_age) {
        this.student_age = student_age;
    }

    public Integer getStudent_state() {
        return student_state;
    }

    public void setStudent_state(Integer student_state) {
        this.student_state = student_state;
    }

    public Integer getStudent_identity() {
        return student_identity;
    }

    public void setStudent_identity(Integer student_identity) {
        this.student_identity = student_identity;
    }

    public Integer getStudent_gradeid() {
        return student_gradeid;
    }

    public void setStudent_gradeid(Integer student_gradeid) {
        this.student_gradeid = student_gradeid;
    }

    public Integer getStudent_classid() {
        return student_classid;
    }

    public void setStudent_classid(Integer student_classid) {
        this.student_classid = student_classid;
    }

    public Date getStudent_birthday() {
        return student_birthday;
    }

    public void setStudent_birthday(Date student_birthday) {
        this.student_birthday = student_birthday;
    }

    public Date getStudent_modifytime() {
        return student_modifytime;
    }

    public void setStudent_modifytime(Date student_modifytime) {
        this.student_modifytime = student_modifytime;
    }

    public String getStudent_modifyteacher() {
        return student_modifyteacher;
    }

    public void setStudent_modifyteacher(String student_modifyteacher) {
        this.student_modifyteacher = student_modifyteacher;
    }
}
