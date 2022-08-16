package com.yanghaijia.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName Medicine
 */
@TableName(value ="Medicine")
@Data
public class MedicineN implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Object id;

    /**
     * 
     */
    private String medicineName;

    /**
     * 
     */
    private Object medicineQuantity;

    /**
     * 
     */
    private String medicineSupplier;

    /**
     * 
     */
    private Object medicineLegitimacy;

    /**
     * 
     */
    private Object isMedicineForPregnant;

    /**
     * 
     */
    private String medicineInstructions;

    /**
     * 
     */
    private Float medicinePrice;

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
        MedicineN other = (MedicineN) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMedicineName() == null ? other.getMedicineName() == null : this.getMedicineName().equals(other.getMedicineName()))
            && (this.getMedicineQuantity() == null ? other.getMedicineQuantity() == null : this.getMedicineQuantity().equals(other.getMedicineQuantity()))
            && (this.getMedicineSupplier() == null ? other.getMedicineSupplier() == null : this.getMedicineSupplier().equals(other.getMedicineSupplier()))
            && (this.getMedicineLegitimacy() == null ? other.getMedicineLegitimacy() == null : this.getMedicineLegitimacy().equals(other.getMedicineLegitimacy()))
            && (this.getIsMedicineForPregnant() == null ? other.getIsMedicineForPregnant() == null : this.getIsMedicineForPregnant().equals(other.getIsMedicineForPregnant()))
            && (this.getMedicineInstructions() == null ? other.getMedicineInstructions() == null : this.getMedicineInstructions().equals(other.getMedicineInstructions()))
            && (this.getMedicinePrice() == null ? other.getMedicinePrice() == null : this.getMedicinePrice().equals(other.getMedicinePrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMedicineName() == null) ? 0 : getMedicineName().hashCode());
        result = prime * result + ((getMedicineQuantity() == null) ? 0 : getMedicineQuantity().hashCode());
        result = prime * result + ((getMedicineSupplier() == null) ? 0 : getMedicineSupplier().hashCode());
        result = prime * result + ((getMedicineLegitimacy() == null) ? 0 : getMedicineLegitimacy().hashCode());
        result = prime * result + ((getIsMedicineForPregnant() == null) ? 0 : getIsMedicineForPregnant().hashCode());
        result = prime * result + ((getMedicineInstructions() == null) ? 0 : getMedicineInstructions().hashCode());
        result = prime * result + ((getMedicinePrice() == null) ? 0 : getMedicinePrice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", medicineName=").append(medicineName);
        sb.append(", medicineQuantity=").append(medicineQuantity);
        sb.append(", medicineSupplier=").append(medicineSupplier);
        sb.append(", medicineLegitimacy=").append(medicineLegitimacy);
        sb.append(", isMedicineForPregnant=").append(isMedicineForPregnant);
        sb.append(", medicineInstructions=").append(medicineInstructions);
        sb.append(", medicinePrice=").append(medicinePrice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}