package com.xgcd.proxy;

public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("从磁盘中读取大头贴:" + fileName);
    }

    @Override
    public void display() {
        System.out.println("显示大头贴:" + fileName);
    }
}
