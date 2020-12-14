package com.austin.custom.spring.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private static ConnectionUtils connectionUtils = new ConnectionUtils();

    private ConnectionUtils(){}

    public static ConnectionUtils getInstance(){
        return connectionUtils;
    }
    /**
     * 获取当前线程连接
     * @return
     */
    public Connection getCurrentConnect()  {
        Connection connection = threadLocal.get();
        try {
            if (connection == null){
                connection = DruidUtils.getInstance().getConnection();
                threadLocal.set(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
