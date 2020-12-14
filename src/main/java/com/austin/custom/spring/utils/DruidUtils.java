package com.austin.custom.spring.utils;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * TODO 需要修改为读取配置文件
 */
public class DruidUtils {

    private DruidUtils(){
    }

    private static DruidDataSource druidDataSource = new DruidDataSource();


    static {
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://192.168.137.10:3306/my_test?useUnicode=true&amp;characterEncoding=utf8");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");

    }

    public static DruidDataSource getInstance() {
        return druidDataSource;
    }
}
