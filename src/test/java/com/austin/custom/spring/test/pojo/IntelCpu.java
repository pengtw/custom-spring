package com.austin.custom.spring.test.pojo;

public class IntelCpu implements Cpu {

    @Override
    public void desc() {
        System.out.println("我是intel的cpu");
    }
}
