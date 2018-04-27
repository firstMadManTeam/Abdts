package com.abdts.vo.exam;

import com.abdts.entity.exam.Exam;

/**
 * @author pzy
 */
public class ExamVO extends Exam{

    private String public_grade_name = null;

    private String public_subject_name = null;

    public String getPublic_grade_name() {
        return public_grade_name;
    }

    public void setPublic_grade_name(String public_grade_name) {
        this.public_grade_name = public_grade_name;
    }

    public String getPublic_subject_name() {
        return public_subject_name;
    }

    public void setPublic_subject_name(String public_subject_name) {
        this.public_subject_name = public_subject_name;
    }
}
