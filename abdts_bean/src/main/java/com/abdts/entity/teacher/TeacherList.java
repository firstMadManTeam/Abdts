package com.abdts.entity.teacher;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author pzy
 */
public class TeacherList implements Serializable{

    private Integer publicTeacherlistId;

    private String publicTeacherlistPwd;

    private Integer publicTeacherlistPhone;

    private String publicTeacherlistName;

    private Integer publicTeacherlistSex;

    private Date publicTeacherlistBirthday;

    private Integer publicTeacherlistIdentity;

    private Integer publicTeacherlistSubject;

    private Integer publicTeacherlistSchoolid;

    /** 角色 */
    private List<Integer> roleIds;

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public Integer getPublicTeacherlistId() {
        return publicTeacherlistId;
    }

    public void setPublicTeacherlistId(Integer publicTeacherlistId) {
        this.publicTeacherlistId = publicTeacherlistId;
    }

    public String getPublicTeacherlistPwd() {
        return publicTeacherlistPwd;
    }

    public void setPublicTeacherlistPwd(String publicTeacherlistPwd) {
        this.publicTeacherlistPwd = publicTeacherlistPwd;
    }

    public Integer getPublicTeacherlistPhone() {
        return publicTeacherlistPhone;
    }

    public void setPublicTeacherlistPhone(Integer publicTeacherlistPhone) {
        this.publicTeacherlistPhone = publicTeacherlistPhone;
    }

    public String getPublicTeacherlistName() {
        return publicTeacherlistName;
    }

    public void setPublicTeacherlistName(String publicTeacherlistName) {
        this.publicTeacherlistName = publicTeacherlistName;
    }

    public Integer getPublicTeacherlistSex() {
        return publicTeacherlistSex;
    }

    public void setPublicTeacherlistSex(Integer publicTeacherlistSex) {
        this.publicTeacherlistSex = publicTeacherlistSex;
    }

    public Date getPublicTeacherlistBirthday() {
        return publicTeacherlistBirthday;
    }

    public void setPublicTeacherlistBirthday(Date publicTeacherlistBirthday) {
        this.publicTeacherlistBirthday = publicTeacherlistBirthday;
    }

    public Integer getPublicTeacherlistIdentity() {
        return publicTeacherlistIdentity;
    }

    public void setPublicTeacherlistIdentity(Integer publicTeacherlistIdentity) {
        this.publicTeacherlistIdentity = publicTeacherlistIdentity;
    }

    public Integer getPublicTeacherlistSubject() {
        return publicTeacherlistSubject;
    }

    public void setPublicTeacherlistSubject(Integer publicTeacherlistSubject) {
        this.publicTeacherlistSubject = publicTeacherlistSubject;
    }

    public Integer getPublicTeacherlistSchoolid() {
        return publicTeacherlistSchoolid;
    }

    public void setPublicTeacherlistSchoolid(Integer publicTeacherlistSchoolid) {
        this.publicTeacherlistSchoolid = publicTeacherlistSchoolid;
    }
}
