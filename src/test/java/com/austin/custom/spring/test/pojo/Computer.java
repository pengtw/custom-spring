package com.austin.custom.spring.test.pojo;

public class Computer {

    private Cpu cpu;

    private Keyboard keyboard;

    /**
     * 获取电脑配置信息
     */
    public void configurationInfo(){
        System.out.println("电脑配置信息：");
        //cpu
        cpu.desc();
        //键盘
        keyboard.desc();
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
}
