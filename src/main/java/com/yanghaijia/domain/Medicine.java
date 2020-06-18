package com.yanghaijia.domain;

/**
 * @author yanghaijia
 */
public class Medicine {
    private Integer id;
    private String medicineName;
    private Integer medicineQuantity;
    private String medicineSupplier;
    private Boolean medicineLegitimacy;
    private Boolean isMedicineForPregnant;
    private String medicineInstructions;
    private Double medicinePrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Integer getMedicineQuantity() {
        return medicineQuantity;
    }

    public void setMedicineQuantity(Integer medicineQuantity) {
        this.medicineQuantity = medicineQuantity;
    }

    public String getMedicineSupplier() {
        return medicineSupplier;
    }

    public void setMedicineSupplier(String medicineSupplier) {
        this.medicineSupplier = medicineSupplier;
    }

    public Boolean getMedicineLegitimacy() {
        return medicineLegitimacy;
    }

    public void setMedicineLegitimacy(Boolean medicineLegitimacy) {
        this.medicineLegitimacy = medicineLegitimacy;
    }

    public Boolean getMedicineForPregnant() {
        return isMedicineForPregnant;
    }

    public void setMedicineForPregnant(Boolean medicineForPregnant) {
        isMedicineForPregnant = medicineForPregnant;
    }

    public String getMedicineInstructions() {
        return medicineInstructions;
    }

    public void setMedicineInstructions(String medicineInstructions) {
        this.medicineInstructions = medicineInstructions;
    }

    public Double getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(Double medicinePrice) {
        this.medicinePrice = medicinePrice;
    }
}
