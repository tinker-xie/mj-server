package com.xie.model.bean;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private int id;
    private String NO;
    private int uid;
    private int confirmed;
    private int order_status;
    private int pay_status;
    private int ship_status;
    private int package_status;
    private double order_amount;
    private double order_weight;
    private double order_money;
    private double order_amount_real;
    private double order_money_real;
    private int bonus_id;
    private double bonus;
    private double point;
    private int payment;
    private java.sql.Date send_date;
    private Time time_start;
    private Time time_end;
    private int address_id;
    private String mobile;
    private String receiver;
    private String city;
    private String district;
    private String road;
    private String address;
    private String message;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    private List<Item> items;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNO() {
        return NO;
    }

    public void setNO(String NO) {
        this.NO = NO;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public int getPay_status() {
        return pay_status;
    }

    public void setPay_status(int pay_status) {
        this.pay_status = pay_status;
    }

    public int getShip_status() {
        return ship_status;
    }

    public void setShip_status(int ship_status) {
        this.ship_status = ship_status;
    }

    public int getPackage_status() {
        return package_status;
    }

    public void setPackage_status(int package_status) {
        this.package_status = package_status;
    }

    public double getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(double order_amount) {
        this.order_amount = order_amount;
    }

    public double getOrder_weight() {
        return order_weight;
    }

    public void setOrder_weight(double order_weight) {
        this.order_weight = order_weight;
    }

    public double getOrder_money() {
        return order_money;
    }

    public void setOrder_money(double order_money) {
        this.order_money = order_money;
    }

    public double getOrder_amount_real() {
        return order_amount_real;
    }

    public void setOrder_amount_real(double order_amount_real) {
        this.order_amount_real = order_amount_real;
    }

    public double getOrder_money_real() {
        return order_money_real;
    }

    public void setOrder_money_real(double order_money_real) {
        this.order_money_real = order_money_real;
    }

    public int getBonus_id() {
        return bonus_id;
    }

    public void setBonus_id(int bonus_id) {
        this.bonus_id = bonus_id;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public java.sql.Date getSend_date() {
        return send_date;
    }

    public void setSend_date(java.sql.Date send_date) {
        this.send_date = send_date;
    }

    public Time getTime_start() {
        return time_start;
    }

    public void setTime_start(Time time_start) {
        this.time_start = time_start;
    }

    public Time getTime_end() {
        return time_end;
    }

    public void setTime_end(Time time_end) {
        this.time_end = time_end;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

