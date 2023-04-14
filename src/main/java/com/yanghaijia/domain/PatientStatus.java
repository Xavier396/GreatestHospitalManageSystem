package com.yanghaijia.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName patient_status
 */
@TableName(value ="patient_status")
@Data
public class PatientStatus implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Object id;

    /**
     * 
     */
    private String pId;

    /**
     * 
     */
    private String pStatus;

    /**
     * 
     */
    private String pStay;

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
        PatientStatus other = (PatientStatus) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPId() == null ? other.getPId() == null : this.getPId().equals(other.getPId()))
            && (this.getPStatus() == null ? other.getPStatus() == null : this.getPStatus().equals(other.getPStatus()))
            && (this.getPStay() == null ? other.getPStay() == null : this.getPStay().equals(other.getPStay()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPId() == null) ? 0 : getPId().hashCode());
        result = prime * result + ((getPStatus() == null) ? 0 : getPStatus().hashCode());
        result = prime * result + ((getPStay() == null) ? 0 : getPStay().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pId=").append(pId);
        sb.append(", pStatus=").append(pStatus);
        sb.append(", pStay=").append(pStay);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}