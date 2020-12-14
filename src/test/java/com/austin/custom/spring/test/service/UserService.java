package com.austin.custom.spring.test.service;

import com.austin.custom.spring.test.pojo.User;

import java.sql.SQLException;

public interface UserService {
    public void updateUser(User... users) throws Exception;
}
