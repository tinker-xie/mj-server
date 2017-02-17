package com.xie.service.core;

import com.xie.annotation.FieldValue;

/**
 * Created by xie on 16/8/23.
 */
public enum PAI {
    @FieldValue("一万")
    B1(0),
    @FieldValue("二万")
    B2(1),
    @FieldValue("三万")
    B3(2),
    @FieldValue("四万")
    B4(3),
    @FieldValue("五万")
    B5(4),
    @FieldValue("六万")
    B6(5),
    @FieldValue("七万")
    B7(6),
    @FieldValue("八万")
    B8(7),
    @FieldValue("九万")
    B9(8),
    @FieldValue("一饼")
    T1(9),
    @FieldValue("二饼")
    T2(10),
    @FieldValue("三饼")
    T3(11),
    @FieldValue("四饼")
    T4(12),
    @FieldValue("五饼")
    T5(13),
    @FieldValue("六饼")
    T6(14),
    @FieldValue("七饼")
    T7(15),
    @FieldValue("八饼")
    T8(16),
    @FieldValue("九饼")
    T9(17),
    @FieldValue("一条")
    W1(18),
    @FieldValue("二条")
    W2(19),
    @FieldValue("三条")
    W3(20),
    @FieldValue("四条")
    W4(21),
    @FieldValue("五条")
    W5(22),
    @FieldValue("六条")
    W6(23),
    @FieldValue("七条")
    W7(24),
    @FieldValue("八饼")
    W8(25),
    @FieldValue("九饼")
    W9(26),
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


    public static PAI valueOf(int code) {
        switch (code) {
            case 0:
                return B1;
            case 1:
                return B2;
            case 2:
                return B3;
            case 3:
                return B4;
            case 4:
                return B5;
            case 5:
                return B6;
            case 6:
                return B7;
            case 7:
                return B8;
            case 8:
                return B9;
            case 9:
                return T1;
            case 10:
                return T2;
            case 11:
                return T3;
            case 12:
                return T4;
            case 13:
                return T5;
            case 14:
                return T6;
            case 15:
                return T7;
            case 16:
                return T8;
            case 17:
                return T9;
            case 18:
                return W1;
            case 19:
                return W2;
            case 20:
                return W3;
            case 21:
                return W4;
            case 22:
                return W5;
            case 23:
                return W6;
            case 24:
                return W7;
            case 25:
                return W8;
            case 26:
                return W9;
            case 27:
                return E;
            case 28:
                return S;
            case 29:
                return W;
            case 30:
                return N;
            case 31:
                return ZH;
            case 32:
                return FA;
            case 33:
                return BA;
        }
        return null;
    }


}
