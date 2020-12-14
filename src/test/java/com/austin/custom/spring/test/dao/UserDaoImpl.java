package com.austin.custom.spring.test.dao;

import com.austin.custom.spring.test.pojo.User;
import com.austin.custom.spring.utils.ConnectionUtils;
import com.austin.custom.spring.utils.DruidUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public int updateUser(User user) throws SQLException {
        Connection connection = ConnectionUtils.getInstance().getCurrentConnect();

        String sql = "update user set username = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setInt(2,user.getId());

        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
        return i;
    }
}
