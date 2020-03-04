package com.xgcd.proxy;

/**
 * 代理类
 */
public class ProxyImage implements Image {
    // 引入真实操作类对象
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        // 调用真实操作类方法
        realImage.display();
    }
}
