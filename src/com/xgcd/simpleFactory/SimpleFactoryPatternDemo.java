package com.xgcd.simpleFactory;

import java.util.Scanner;

/**
 * 运算测试
 */
public class SimpleFactoryPatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("请输入数字A:");
                String strA = scanner.next();
                double numberA = Double.parseDouble(strA);

                System.out.println("请输入运算符号(+ - * /)");
                String strOper = scanner.next();

                System.out.println("请输入数字B:");
                String strB = scanner.next();
                double numberB = Double.parseDouble(strB);

                Operation oper = OperationFactory.createOperate(strOper);
                double result = oper.getResult(numberA, numberB);
                System.out.println("运算结果是:" + result);
            }
        } catch (Exception e) {
            System.out.println("输入有误:" + e.getMessage());
        }
        /*请输入数字A:
        0
        请输入运算符号(+ - * /)
        /
        请输入数字B:
        3
        运算结果是:0.0
        请输入数字A:
        0
        请输入运算符号(+ - * /)
        /
        请输入数字B:
        0
        运算结果是:NaN
        请输入数字A:
        1
        请输入运算符号(+ - * /)
        1
        请输入数字B:
        1
        输入有误:null
        */
    }
}
