package com.yanghaijia.domain;

/**
 * @author yhjzs
 */
public class Staff {
    private Integer id;
    private String worker_id;
    private String worker_name;
    private String worker_birthday;
    private String worker_phone;
    private String worker_email;
    private String worker_department;
    private String worker_other_note;
    private String worker_role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkerId() {
        return worker_id;
    }

    public void setWorkerId(String workerId) {
        this.worker_id = workerId;
    }

    public String getWorkerName() {
        return worker_name;
    }

    public void setWorkerName(String workerName) {
        this.worker_name = workerName;
    }

    public String getWorkerBirthday() {
        return worker_birthday;
    }

    public void setWorkerBirthday(String workerBirthday) {
        this.worker_birthday = workerBirthday;
    }

    public String getWorkerPhone() {
        return worker_phone;
    }

    public void setWorkerPhone(String workerPhone) {
        this.worker_phone = workerPhone;
    }

    public String getWorkerEmail() {
        return worker_email;
    }

    public void setWorkerEmail(String workerEmail) {
        this.worker_email = workerEmail;
    }

    public String getWorkerDepartment() {
        return worker_department;
    }

    public void setWorkerDepartment(String workerDepartment) {
        this.worker_department = workerDepartment;
    }

    public String getWorkerOtherNote() {
        return worker_other_note;
    }

    public void setWorkerOtherNote(String workerOtherNote) {
        this.worker_other_note = workerOtherNote;
    }

    public String getWorkerRole() {
        return worker_role;
    }

    public void setWorkerRole(String workerRole) {
        this.worker_role = workerRole;
    }
}
