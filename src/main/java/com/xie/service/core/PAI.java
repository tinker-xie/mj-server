package com.xie.service.core;

import com.xie.annotation.FieldValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xie on 16/8/23.
 */
public enum PAI {
    @FieldValue("一万")
    W1(0),
    @FieldValue("二万")
    W2(1),
    @FieldValue("三万")
    W3(2),
    @FieldValue("四万")
    W4(3),
    @FieldValue("五万")
    W5(4),
    @FieldValue("六万")
    W6(5),
    @FieldValue("七万")
    W7(6),
    @FieldValue("八万")
    W8(7),
    @FieldValue("九万")
    W9(8),
    @FieldValue("一饼")
    B1(9),
    @FieldValue("二饼")
    B2(10),
    @FieldValue("三饼")
    B3(11),
    @FieldValue("四饼")
    B4(12),
    @FieldValue("五饼")
    B5(13),
    @FieldValue("六饼")
    B6(14),
    @FieldValue("七饼")
    B7(15),
    @FieldValue("八饼")
    B8(16),
    @FieldValue("九饼")
    B9(17),
    @FieldValue("一条")
    T1(18),
    @FieldValue("二条")
    T2(19),
    @FieldValue("三条")
    T3(20),
    @FieldValue("四条")
    T4(21),
    @FieldValue("五条")
    T5(22),
    @FieldValue("六条")
    T6(23),
    @FieldValue("七条")
    T7(24),
    @FieldValue("八饼")
    T8(25),
    @FieldValue("九饼")
    T9(26),
    @FieldValue("东风")
    E(27),
    @FieldValue("南风")
    S(28),
    @FieldValue("西风")
    W(29),
    @FieldValue("北方")
    N(30),
    @FieldValue("红中")
    ZH(31),
    @FieldValue("发财")
    FA(32),
    @FieldValue("白板")
    BA(33);

    private int code;

    PAI(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }



}
