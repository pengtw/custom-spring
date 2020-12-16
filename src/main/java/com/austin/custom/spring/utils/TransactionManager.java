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

    /**
     * 开启事务
     **/
    public void beginTransaction() throws SQLException {
        ConnectionUtils.getInstance().getCurrentConnect().setAutoCommit(false);
    }

    /**
     * 提交事务
     **/
    public void commit() throws SQLException {
        ConnectionUtils.getInstance().getCurrentConnect().commit();
    }

    /**
     * 回滚事务
     **/
    public void rollback() throws SQLException {
        ConnectionUtils.getInstance().getCurrentConnect().rollback();
    }

}
