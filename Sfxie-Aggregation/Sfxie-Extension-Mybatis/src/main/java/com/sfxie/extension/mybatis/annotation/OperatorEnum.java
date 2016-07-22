package com.sfxie.extension.mybatis.annotation;

public enum OperatorEnum  {
    EQ(" = ", 1), GT(" >= ", 2), LT(" <= ", 3), LIKE(" like ", 4);
    // 成员变量
    private String name;
    private int value;

    // 构造方法
    private OperatorEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 普通方法
    public static String getName(int value) {
        for (OperatorEnum c : OperatorEnum.values()) {
            if (c.getValue() == value) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
