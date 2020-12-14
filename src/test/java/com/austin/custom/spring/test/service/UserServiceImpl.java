package com.austin.custom.spring.test.service;

import com.austin.custom.spring.test.dao.UserDao;
import com.austin.custom.spring.test.pojo.User;
import com.austin.custom.spring.utils.TransactionManager;

import java.sql.SQLException;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void updateUser(User... users) throws Exception {

//        try {
//            TransactionManager.getInstance().beginTransaction();
            for (User user : users) {
                userDao.updateUser(user);
            }
//            int x = 1/0;
//            TransactionManager.getInstance().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            TransactionManager.getInstance().rollback();
//        }
    }
}
