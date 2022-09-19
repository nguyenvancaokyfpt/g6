package com.tss.service.impl;
import com.tss.dao.BaseDao;
import com.tss.dao.impl.LoginDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;

import com.tss.service.LoginService;

public class LoginServiceImpl implements LoginService {

    @Override
    public boolean login(String email, String password) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            flag = new LoginDaoImpl().login(connection, email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }
}
