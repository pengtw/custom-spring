package com.austin.custom.spring.utils;

import java.sql.SQLException;

/**
 * jdbc事务管理器
 */
public class TransactionManager {

    private static TransactionManager instance = new TransactionManager();

    private TransactionManager(){
    }

    public static TransactionManager getInstance(){
        return instance;
    }

    public void beginTransaction() throws SQLException {
        ConnectionUtils.getInstance().getCurrentConnect().setAutoCommit(false);
    }

    public void commit() throws SQLException {
        ConnectionUtils.getInstance().getCurrentConnect().commit();
    }

    public void rollback() throws SQLException {
        ConnectionUtils.getInstance().getCurrentConnect().rollback();
    }

}
