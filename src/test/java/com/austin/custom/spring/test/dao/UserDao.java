package com.austin.custom.spring.test.dao;

import com.austin.custom.spring.test.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    public int updateUser(User user) throws SQLException;

}
