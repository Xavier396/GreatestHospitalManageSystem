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
private String prescriptionId;
private  String prescriptionContent;
private String prescriptionDateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getPrescriptionContent() {
        return prescriptionContent;
    }

    public void setPrescriptionContent(String prescriptionContent) {
        this.prescriptionContent = prescriptionContent;
    }

    public String getPrescriptionDateTime() {
        return prescriptionDateTime;
    }

    public void setPrescriptionDateTime(String prescriptionDateTime) {
        this.prescriptionDateTime = prescriptionDateTime;
    }
}
