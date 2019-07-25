package com.lvshihao.entity;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author: lvshihao
 * @Date: $ $
 * @Description:
 */
public class User {
    private Integer id;
    private String NAME;
    private String PASSWORD;
    private String PERMS;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", PERMS='" + PERMS + '\'' +
                '}';
    }

    public String getPERMS() {
        return PERMS;
    }

    public void setPERMS(String PERMS) {
        this.PERMS = PERMS;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}
