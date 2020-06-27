package com.yanghaijia.domain;

/**
 * @author yanghaijia
 */
public class Patients {
    /**
     * <p>
     *     pId:病人的病例号
     *     pTel：病人的联系方式
     *     pPrescriptId:病人的处方号
     * </p>
     * */
    private Integer id;
    private String p_id;
    private String p_name;
    private String p_birthday;
    private String p_allergic;
    private String p_tel;
    private String p_email;
    private String p_visit;
    private String p_prescript_id;

    public Patients() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_birthday() {
        return p_birthday;
    }

    public void setP_birthday(String p_birthday) {
        this.p_birthday = p_birthday;
    }

    public String getP_allergic() {
        return p_allergic;
    }

    public void setP_allergic(String p_allergic) {
        this.p_allergic = p_allergic;
    }

    public String getP_tel() {
        return p_tel;
    }

    public void setP_tel(String p_tel) {
        this.p_tel = p_tel;
    }

    public String getP_email() {
        return p_email;
    }

    public void setP_email(String p_email) {
        this.p_email = p_email;
    }

    public String getP_visit() {
        return p_visit;
    }

    public void setP_visit(String p_visit) {
        this.p_visit = p_visit;
    }

    public String getP_prescript_id() {
        return p_prescript_id;
    }

    public void setP_prescript_id(String p_prescript_id) {
        this.p_prescript_id = p_prescript_id;
    }
}
