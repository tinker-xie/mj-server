package com.xie.model.bean;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable {
    private int id;
    private String no;
    private String name;
    private int category_id1;
    private int category_id2;
    private int is_remain;
    private int is_online;
    private int is_active;
    private int is_rough;
    private int is_promote;
    private int is_delete;
    private int status;
    private Date promote_end;
    private int order;
    private double weight;
    private double order_quantity;
    private double max_quantity;
    private double market_price;
    private double shop_price;
    private double promote_price;
    private double remain;
    private double sale_num;
    private int quanlity;
    private String unit;
    private String unit_sell;
    private String unitdesc;
    private String src;
    private String thumb;
    private String place;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory_id1() {
        return category_id1;
    }

    public void setCategory_id1(int category_id1) {
        this.category_id1 = category_id1;
    }

    public int getCategory_id2() {
        return category_id2;
    }

    public void setCategory_id2(int category_id2) {
        this.category_id2 = category_id2;
    }

    public int getIs_remain() {
        return is_remain;
    }

    public void setIs_remain(int is_remain) {
        this.is_remain = is_remain;
    }

    public int getIs_online() {
        return is_online;
    }

    public void setIs_online(int is_online) {
        this.is_online = is_online;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public int getIs_rough() {
        return is_rough;
    }

    public void setIs_rough(int is_rough) {
        this.is_rough = is_rough;
    }

    public int getIs_promote() {
        return is_promote;
    }

    public void setIs_promote(int is_promote) {
        this.is_promote = is_promote;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getPromote_end() {
        return promote_end;
    }

    public void setPromote_end(Date promote_end) {
        this.promote_end = promote_end;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(double order_quantity) {
        this.order_quantity = order_quantity;
    }

    public double getMax_quantity() {
        return max_quantity;
    }

    public void setMax_quantity(double max_quantity) {
        this.max_quantity = max_quantity;
    }

    public double getMarket_price() {
        return market_price;
    }

    public void setMarket_price(double market_price) {
        this.market_price = market_price;
    }

    public double getShop_price() {
        return shop_price;
    }

    public void setShop_price(double shop_price) {
        this.shop_price = shop_price;
    }

    public double getPromote_price() {
        return promote_price;
    }

    public void setPromote_price(double promote_price) {
        this.promote_price = promote_price;
    }

    public double getRemain() {
        return remain;
    }

    public void setRemain(double remain) {
        this.remain = remain;
    }

    public double getSale_num() {
        return sale_num;
    }

    public void setSale_num(double sale_num) {
        this.sale_num = sale_num;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit_sell() {
        return unit_sell;
    }

    public void setUnit_sell(String unit_sell) {
        this.unit_sell = unit_sell;
    }

    public String getUnitdesc() {
        return unitdesc;
    }

    public void setUnitdesc(String unitdesc) {
        this.unitdesc = unitdesc;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

