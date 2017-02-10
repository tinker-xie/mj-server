package com.xie.model.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;
    private String name;
    private String mobile;
    private String email;
    private String wx;
    private String description;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    @JsonIgnore
    private Byte lock;
    @JsonIgnore
    private Byte verified;

    @JsonIgnore
    private String password;
    @JsonIgnore
    private String remember_token;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWx() {
        return this.wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public Byte getLock() {
        return this.lock;
    }

    public void setLock(Byte lock) {
        this.lock = lock;
    }

    public Byte getVerified() {
        return this.verified;
    }

    public void setVerified(Byte verified) {
        this.verified = verified;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemember_token() {
        return this.remember_token;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }
}

