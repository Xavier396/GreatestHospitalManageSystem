package com.yanghaijia.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName Patients
 */
@TableName(value ="Patients")
@Data
public class PatientsN implements Serializable {
    /**
     * 
     */
    @TableId
    private Object id;

    /**
     * 
     */
    @TableId
    private String pId;

    /**
     * 
     */
    @TableId
    private String pPrescriptId;

    /**
     * 
     */
    private String pName;

    /**
     * 
     */
    private String pBirthday;

    /**
     * 
     */
    private String pAllergic;

    /**
     * 
     */
    private String pTel;

    /**
     * 
     */
    private String pEmail;

    /**
     * 
     */
    private String pVisit;

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
        PatientsN other = (PatientsN) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPId() == null ? other.getPId() == null : this.getPId().equals(other.getPId()))
            && (this.getPPrescriptId() == null ? other.getPPrescriptId() == null : this.getPPrescriptId().equals(other.getPPrescriptId()))
            && (this.getPName() == null ? other.getPName() == null : this.getPName().equals(other.getPName()))
            && (this.getPBirthday() == null ? other.getPBirthday() == null : this.getPBirthday().equals(other.getPBirthday()))
            && (this.getPAllergic() == null ? other.getPAllergic() == null : this.getPAllergic().equals(other.getPAllergic()))
            && (this.getPTel() == null ? other.getPTel() == null : this.getPTel().equals(other.getPTel()))
            && (this.getPEmail() == null ? other.getPEmail() == null : this.getPEmail().equals(other.getPEmail()))
            && (this.getPVisit() == null ? other.getPVisit() == null : this.getPVisit().equals(other.getPVisit()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPId() == null) ? 0 : getPId().hashCode());
        result = prime * result + ((getPPrescriptId() == null) ? 0 : getPPrescriptId().hashCode());
        result = prime * result + ((getPName() == null) ? 0 : getPName().hashCode());
        result = prime * result + ((getPBirthday() == null) ? 0 : getPBirthday().hashCode());
        result = prime * result + ((getPAllergic() == null) ? 0 : getPAllergic().hashCode());
        result = prime * result + ((getPTel() == null) ? 0 : getPTel().hashCode());
        result = prime * result + ((getPEmail() == null) ? 0 : getPEmail().hashCode());
        result = prime * result + ((getPVisit() == null) ? 0 : getPVisit().hashCode());
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
        sb.append(", pPrescriptId=").append(pPrescriptId);
        sb.append(", pName=").append(pName);
        sb.append(", pBirthday=").append(pBirthday);
        sb.append(", pAllergic=").append(pAllergic);
        sb.append(", pTel=").append(pTel);
        sb.append(", pEmail=").append(pEmail);
        sb.append(", pVisit=").append(pVisit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}