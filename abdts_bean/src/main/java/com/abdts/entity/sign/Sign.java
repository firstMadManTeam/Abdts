package com.abdts.entity.sign;

import java.util.Date;

/**
 * @author pzy
 */
public class Sign {

    private Integer public_sign_id;

    private String public_sign_title;

    private String public_sign_content;

    private Integer public_sign_parentid;

    private Date public_sign_datetime;

    private Integer public_sign_teacherid;

    private String public_sign_teachreply;

    private Integer public_sign_isreply;

    public Integer getPublic_sign_id() {
        return public_sign_id;
    }

    public void setPublic_sign_id(Integer public_sign_id) {
        this.public_sign_id = public_sign_id;
    }

    public String getPublic_sign_title() {
        return public_sign_title;
    }

    public void setPublic_sign_title(String public_sign_title) {
        this.public_sign_title = public_sign_title;
    }

    public String getPublic_sign_content() {
        return public_sign_content;
    }

    public void setPublic_sign_content(String public_sign_content) {
        this.public_sign_content = public_sign_content;
    }

    public Integer getPublic_sign_parentid() {
        return public_sign_parentid;
    }

    public void setPublic_sign_parentid(Integer public_sign_parentid) {
        this.public_sign_parentid = public_sign_parentid;
    }

    public Date getPublic_sign_datetime() {
        return public_sign_datetime;
    }

    public void setPublic_sign_datetime(Date public_sign_datetime) {
        this.public_sign_datetime = public_sign_datetime;
    }

    public Integer getPublic_sign_teacherid() {
        return public_sign_teacherid;
    }

    public void setPublic_sign_teacherid(Integer public_sign_teacherid) {
        this.public_sign_teacherid = public_sign_teacherid;
    }

    public String getPublic_sign_teachreply() {
        return public_sign_teachreply;
    }

    public void setPublic_sign_teachreply(String public_sign_teachreply) {
        this.public_sign_teachreply = public_sign_teachreply;
    }

    public Integer getPublic_sign_isreply() {
        return public_sign_isreply;
    }

    public void setPublic_sign_isreply(Integer public_sign_isreply) {
        this.public_sign_isreply = public_sign_isreply;
    }
}
