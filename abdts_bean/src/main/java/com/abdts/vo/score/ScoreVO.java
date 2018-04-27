package com.abdts.vo.score;

import com.abdts.entity.score.Score;

/**
 * @author pzy
 */
public class ScoreVO extends Score {

    private Integer student_classid = null;

    private String student_name = null;

    public Integer getStudent_classid() {
        return student_classid;
    }

    public void setStudent_classid(Integer student_classid) {
        this.student_classid = student_classid;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
}
