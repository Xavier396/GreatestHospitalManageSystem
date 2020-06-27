package com.yanghaijia.domain;

/**
 * @author yanghaijia
 */
public class Password {
    private Integer id;
    private String user_id;
    private String user_phone;
    private String password_hash;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String userId) {
        this.user_id = userId;
    }

    public String getUserPhone() {
        return user_phone;
    }

    public void setUserPhone(String userPhone) {
        this.user_phone = userPhone;
    }

    public String getPasswordHash() {
        return password_hash;
    }

    public void setPasswordHash(String passwordHash) {
        this.password_hash = passwordHash;
    }
}
