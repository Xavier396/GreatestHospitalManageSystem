package com.yanghaijia.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName Staff
 */
@TableName(value ="Staff")
@Data
public class Staff implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Object id;

    /**
     * 
     */
    private String workerId;

    /**
     * 
     */
    private String workerName;

    /**
     * 
     */
    private String workerBirthday;

    /**
     * 
     */
    private String workerPhone;

    /**
     * 
     */
    private String workerEmail;

    /**
     * 
     */
    private String workerDepartment;

    /**
     * 
     */
    private String workerOtherNote;

    /**
     * 
     */
    private String workerRole;

    /**
     * 
     */
    private String workerPassword;

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
        Staff other = (Staff) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWorkerId() == null ? other.getWorkerId() == null : this.getWorkerId().equals(other.getWorkerId()))
            && (this.getWorkerName() == null ? other.getWorkerName() == null : this.getWorkerName().equals(other.getWorkerName()))
            && (this.getWorkerBirthday() == null ? other.getWorkerBirthday() == null : this.getWorkerBirthday().equals(other.getWorkerBirthday()))
            && (this.getWorkerPhone() == null ? other.getWorkerPhone() == null : this.getWorkerPhone().equals(other.getWorkerPhone()))
            && (this.getWorkerEmail() == null ? other.getWorkerEmail() == null : this.getWorkerEmail().equals(other.getWorkerEmail()))
            && (this.getWorkerDepartment() == null ? other.getWorkerDepartment() == null : this.getWorkerDepartment().equals(other.getWorkerDepartment()))
            && (this.getWorkerOtherNote() == null ? other.getWorkerOtherNote() == null : this.getWorkerOtherNote().equals(other.getWorkerOtherNote()))
            && (this.getWorkerRole() == null ? other.getWorkerRole() == null : this.getWorkerRole().equals(other.getWorkerRole()))
            && (this.getWorkerPassword() == null ? other.getWorkerPassword() == null : this.getWorkerPassword().equals(other.getWorkerPassword()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWorkerId() == null) ? 0 : getWorkerId().hashCode());
        result = prime * result + ((getWorkerName() == null) ? 0 : getWorkerName().hashCode());
        result = prime * result + ((getWorkerBirthday() == null) ? 0 : getWorkerBirthday().hashCode());
        result = prime * result + ((getWorkerPhone() == null) ? 0 : getWorkerPhone().hashCode());
        result = prime * result + ((getWorkerEmail() == null) ? 0 : getWorkerEmail().hashCode());
        result = prime * result + ((getWorkerDepartment() == null) ? 0 : getWorkerDepartment().hashCode());
        result = prime * result + ((getWorkerOtherNote() == null) ? 0 : getWorkerOtherNote().hashCode());
        result = prime * result + ((getWorkerRole() == null) ? 0 : getWorkerRole().hashCode());
        result = prime * result + ((getWorkerPassword() == null) ? 0 : getWorkerPassword().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", workerId=").append(workerId);
        sb.append(", workerName=").append(workerName);
        sb.append(", workerBirthday=").append(workerBirthday);
        sb.append(", workerPhone=").append(workerPhone);
        sb.append(", workerEmail=").append(workerEmail);
        sb.append(", workerDepartment=").append(workerDepartment);
        sb.append(", workerOtherNote=").append(workerOtherNote);
        sb.append(", workerRole=").append(workerRole);
        sb.append(", workerPassword=").append(workerPassword);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}