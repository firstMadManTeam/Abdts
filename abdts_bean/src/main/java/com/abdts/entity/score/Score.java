package com.abdts.entity.score;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author pzy
 */
public class Score implements Serializable {
    private String tableName = null;
    private BigInteger student_id = null;
    private Double student_totalscores = null;
    private Integer student_classranking = null;
    private Integer student_graderanking = null;
    private Double student_chinese_scores = null;
    private Double student_math_scores = null;
    private Double student_english_scores = null;
    private Double student_physics_scores = null;
    private Double student_chemistry_scores = null;
    private Double student_biology_scores = null;
    private Double student_politics_scores = null;
    private Double student_history_scores = null;
    private Double student_geography_scores = null;
    private Date student_update_datetime = null;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public BigInteger getStudent_id() {
        return student_id;
    }

    public void setStudent_id(BigInteger student_id) {
        this.student_id = student_id;
    }

    public Double getStudent_totalscores() {
        return student_totalscores;
    }

    public void setStudent_totalscores(Double student_totalscores) {
        this.student_totalscores = student_totalscores;
    }

    public Integer getStudent_classranking() {
        return student_classranking;
    }

    public void setStudent_classranking(Integer student_classranking) {
        this.student_classranking = student_classranking;
    }

    public Integer getStudent_graderanking() {
        return student_graderanking;
    }

    public void setStudent_graderanking(Integer student_graderanking) {
        this.student_graderanking = student_graderanking;
    }

    public Double getStudent_chinese_scores() {
        return student_chinese_scores;
    }

    public void setStudent_chinese_scores(Double student_chinese_scores) {
        this.student_chinese_scores = student_chinese_scores;
    }

    public Double getStudent_math_scores() {
        return student_math_scores;
    }

    public void setStudent_math_scores(Double student_math_scores) {
        this.student_math_scores = student_math_scores;
    }

    public Double getStudent_english_scores() {
        return student_english_scores;
    }

    public void setStudent_english_scores(Double student_english_scores) {
        this.student_english_scores = student_english_scores;
    }

    public Double getStudent_physics_scores() {
        return student_physics_scores;
    }

    public void setStudent_physics_scores(Double student_physics_scores) {
        this.student_physics_scores = student_physics_scores;
    }

    public Double getStudent_chemistry_scores() {
        return student_chemistry_scores;
    }

    public void setStudent_chemistry_scores(Double student_chemistry_scores) {
        this.student_chemistry_scores = student_chemistry_scores;
    }

    public Double getStudent_biology_scores() {
        return student_biology_scores;
    }

    public void setStudent_biology_scores(Double student_biology_scores) {
        this.student_biology_scores = student_biology_scores;
    }

    public Double getStudent_politics_scores() {
        return student_politics_scores;
    }

    public void setStudent_politics_scores(Double student_politics_scores) {
        this.student_politics_scores = student_politics_scores;
    }

    public Double getStudent_history_scores() {
        return student_history_scores;
    }

    public void setStudent_history_scores(Double student_history_scores) {
        this.student_history_scores = student_history_scores;
    }

    public Double getStudent_geography_scores() {
        return student_geography_scores;
    }

    public void setStudent_geography_scores(Double student_geography_scores) {
        this.student_geography_scores = student_geography_scores;
    }

    public Date getStudent_update_datetime() {
        return student_update_datetime;
    }

    public void setStudent_update_datetime(Date student_update_datetime) {
        this.student_update_datetime = student_update_datetime;
    }
}
