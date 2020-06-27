package com.yanghaijia.domain;

/**
 * @author yanghaijia
 */
public class Prescriptions {
    /**
     * id:数据库自增
     * prescriptionId:处方id，他应该是唯一的uuid
     * prescriptionContent：处方的具体内容
     * prescriptionDateTime：处方开具的时间日期
     * */
private  Integer id;
private String prescription_id;
private  String prescription_content;
private String prescription_datetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrescriptionId() {
        return prescription_id;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescription_id = prescriptionId;
    }

    public String getPrescriptionContent() {
        return prescription_content;
    }

    public void setPrescriptionContent(String prescriptionContent) {
        this.prescription_content = prescriptionContent;
    }

    public String getPrescriptionDateTime() {
        return prescription_datetime;
    }

    public void setPrescriptionDateTime(String prescriptionDateTime) {
        this.prescription_datetime = prescriptionDateTime;
    }
}
