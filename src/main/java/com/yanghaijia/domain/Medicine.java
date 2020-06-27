package com.yanghaijia.domain;

/**
 * @author yanghaijia
 */
public class Medicine {
    private Integer id;
    private String medicine_name;
    private Integer medicine_quantity;
    private String medicine_supplier;
    private Boolean medicine_legitimacy;
    private Boolean is_medicine_for_pregnant;
    private String medicine_instructions;
    private Double medicine_price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicine_name;
    }

    public void setMedicineName(String medicineName) {
        this.medicine_name = medicineName;
    }

    public Integer getMedicineQuantity() {
        return medicine_quantity;
    }

    public void setMedicineQuantity(Integer medicineQuantity) {
        this.medicine_quantity = medicineQuantity;
    }

    public String getMedicineSupplier() {
        return medicine_supplier;
    }

    public void setMedicineSupplier(String medicineSupplier) {
        this.medicine_supplier = medicineSupplier;
    }

    public Boolean getMedicineLegitimacy() {
        return medicine_legitimacy;
    }

    public void setMedicineLegitimacy(Boolean medicineLegitimacy) {
        this.medicine_legitimacy = medicineLegitimacy;
    }

    public Boolean getMedicineForPregnant() {
        return is_medicine_for_pregnant;
    }

    public void setMedicineForPregnant(Boolean medicineForPregnant) {
        is_medicine_for_pregnant = medicineForPregnant;
    }

    public String getMedicineInstructions() {
        return medicine_instructions;
    }

    public void setMedicineInstructions(String medicineInstructions) {
        this.medicine_instructions = medicineInstructions;
    }

    public Double getMedicinePrice() {
        return medicine_price;
    }

    public void setMedicinePrice(Double medicinePrice) {
        this.medicine_price = medicinePrice;
    }
}
