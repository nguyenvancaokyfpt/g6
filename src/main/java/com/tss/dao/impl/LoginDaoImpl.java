package com.tss.dao.impl;
import com.tss.dao.BaseDao;
import com.tss.dao.LoginDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDaoImpl implements LoginDao {

    @Override
    public boolean login(Connection connection, String email, String password) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean flag = false;
        if (connection != null) {
            String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
            Object[] params = {email, password};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return flag;
    }

}
    
