package com.xie.enums;

/**
 * @Author xie
 * @Date 17/1/22 下午2:22.
 */
public enum ActionType {
    任务操作(10),
    任务分配(20);

    private Integer _value;

    ActionType(Integer value) {
        this._value = value;
    }

    public Integer value() {
        return _value;
    }
}
