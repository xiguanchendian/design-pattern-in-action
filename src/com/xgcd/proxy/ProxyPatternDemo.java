package com.xgcd.proxy;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("大头贴.jpg");
        // 图像将从磁盘中读取并展示
        image.display();
        System.out.println("再次执行就不需要从磁盘中加载...");
        // 图像不需要从磁盘中加载
        image.display();
        /*从磁盘中读取大头贴:大头贴.jpg
        显示大头贴:大头贴.jpg
        再次执行就不需要从磁盘中加载
        显示大头贴:大头贴.jpg*/
    }
}
