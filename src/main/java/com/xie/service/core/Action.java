package com.xie.service.core;

import com.xie.annotation.FieldValue;

public enum Action {
    @FieldValue("分牌")
    分牌(00),

    @FieldValue("出牌")
    出牌(10),

    @FieldValue("摸牌")
    摸牌(20),

    @FieldValue("碰")
    碰(30),
    @FieldValue("判碰")
    判碰(31),

    @FieldValue("杠")
    杠(40),
    @FieldValue("判杠")
    判杠(41),

    @FieldValue("判碰杠")
    判碰杠(42),
    @FieldValue("不碰杠")
    不碰杠(43),

    @FieldValue("胡")
    胡(50),
    @FieldValue("判胡")
    判胡(51),

    @FieldValue("抓鸟")
    抓鸟(60),


    @FieldValue("流局")
    流局(90);

    private int code;

    Action(int code) {
        this.code = code;
    }

    public static Action valueOf(int code) {
        switch (code) {
            case 00:
                return 分牌;
            case 10:
                return 出牌;
            case 20:
                return 摸牌;
            case 30:
                return 碰;
            case 31:
                return 判碰;
            case 40:
                return 杠;
            case 41:
                return 判杠;
            case 42:
                return 判碰杠;
            case 43:
                return 不碰杠;
            case 50:
                return 胡;
            case 51:
                return 判胡;
            case 60:
                return 抓鸟;
            case 90:
                return 流局;
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}