package com.yanghaijia.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName Prescriptions
 */
@TableName(value ="Prescriptions")
@Data
public class Prescriptions implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Object id;

    /**
     * 
     */
    private String prescriptionId;

    /**
     * 
     */
    private String prescriptionContent;

    /**
     * 
     */
    private String prescriptionDatetime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Prescriptions other = (Prescriptions) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrescriptionId() == null ? other.getPrescriptionId() == null : this.getPrescriptionId().equals(other.getPrescriptionId()))
            && (this.getPrescriptionContent() == null ? other.getPrescriptionContent() == null : this.getPrescriptionContent().equals(other.getPrescriptionContent()))
            && (this.getPrescriptionDatetime() == null ? other.getPrescriptionDatetime() == null : this.getPrescriptionDatetime().equals(other.getPrescriptionDatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrescriptionId() == null) ? 0 : getPrescriptionId().hashCode());
        result = prime * result + ((getPrescriptionContent() == null) ? 0 : getPrescriptionContent().hashCode());
        result = prime * result + ((getPrescriptionDatetime() == null) ? 0 : getPrescriptionDatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", prescriptionId=").append(prescriptionId);
        sb.append(", prescriptionContent=").append(prescriptionContent);
        sb.append(", prescriptionDatetime=").append(prescriptionDatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}