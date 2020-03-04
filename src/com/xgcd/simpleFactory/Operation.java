package com.xgcd.simpleFactory;

/**
 * 运算类
 * 提供getResult()方法
 */
public class Operation {
    private double numberA;
    private double numberB;

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    public double getResult(double numberA, double numberB) {
        return 0;
    }
}
