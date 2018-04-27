package com.abdts.vo.student;

import com.abdts.entity.student.StudentList;
import org.apache.solr.client.solrj.beans.Field;

/**
 * @author pzy
 */
public class StudentListVO extends StudentList {

    private String stuSex = null;

    private String stuState = null;

    @Field(value = "student_identity_text")
    private String stu_identity_text = null;

    @Field(value = "student_identity_id")
    private Integer student_identity_id = null;

    @Field(value = "public_grade_id")
    private Integer public_grade_id = null;

    @Field(value = "public_grade_name")
    private String pub_grade_name = null;

    public Integer getPublic_grade_id() {
        return public_grade_id;
    }

    public void setPublic_grade_id(Integer public_grade_id) {
        this.public_grade_id = public_grade_id;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuState() {
        return stuState;
    }

    public void setStuState(String stuState) {
        this.stuState = stuState;
    }

    public String getStu_identity_text() {
        return stu_identity_text;
    }

    public void setStu_identity_text(String stu_identity_text) {
        this.stu_identity_text = stu_identity_text;
    }

    public String getPub_grade_name() {
        return pub_grade_name;
    }

    public void setPub_grade_name(String pub_grade_name) {
        this.pub_grade_name = pub_grade_name;
    }

    public Integer getStudent_identity_id() {
        return student_identity_id;
    }

    public void setStudent_identity_id(Integer student_identity_id) {
        this.student_identity_id = student_identity_id;
    }
}
