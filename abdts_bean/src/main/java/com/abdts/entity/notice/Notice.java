package com.abdts.entity.notice;


import java.io.Serializable;
import java.util.Date;

/**
 * @author pzy
 */
public class Notice implements Serializable{

    private Integer public_notice_id;

    private String public_notice_title;

    private String public_notice_content;

    private String public_notice_publisher;

    private Date public_notice_datetime;

    private String public_notice_ip;

    public Integer getPublic_notice_id() {
        return public_notice_id;
    }

    public void setPublic_notice_id(Integer public_notice_id) {
        this.public_notice_id = public_notice_id;
    }

    public String getPublic_notice_title() {
        return public_notice_title;
    }

    public void setPublic_notice_title(String public_notice_title) {
        this.public_notice_title = public_notice_title;
    }

    public String getPublic_notice_content() {
        return public_notice_content;
    }

    public void setPublic_notice_content(String public_notice_content) {
        this.public_notice_content = public_notice_content;
    }

    public String getPublic_notice_publisher() {
        return public_notice_publisher;
    }

    public void setPublic_notice_publisher(String public_notice_publisher) {
        this.public_notice_publisher = public_notice_publisher;
    }

    public Date getPublic_notice_datetime() {
        return public_notice_datetime;
    }

    public void setPublic_notice_datetime(Date public_notice_datetime) {
        this.public_notice_datetime = public_notice_datetime;
    }

    public String getPublic_notice_ip() {
        return public_notice_ip;
    }

    public void setPublic_notice_ip(String public_notice_ip) {
        this.public_notice_ip = public_notice_ip;
    }
}
