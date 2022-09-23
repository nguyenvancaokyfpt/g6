package com.tss.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.tss.constants.RoleConstants;
import com.tss.dao.BaseDao;
import com.tss.dao.UserDao;
import com.tss.dao.impl.UserDaoImpl;
import com.tss.helper.PasswordHelper;
import com.tss.model.User;
import com.tss.service.RegisterService;
import com.tss.service.RoleService;

public class RegisterServiceImpl implements RegisterService {

    private UserDao userDao;
    private RoleService roleService;

    public RegisterServiceImpl() {
        userDao = new UserDaoImpl();
        roleService = new RoleServiceImpl();
    }

    @Override
    public boolean registerUserWithGoogle(User user) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean register(User user) {
        Connection connection = null;
        boolean flag = false;
        // random username for user from email
        user.setUsername(user.getEmail().substring(0, user.getEmail().indexOf("@")) + (int) (Math.random() * 1000000));
        // encrypt password
        user.setPassword(PasswordHelper.generateSecurePassword(user.getPassword()));
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            flag = userDao.register(connection, user);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        if (flag) {
            // set default role for user
            if (roleService.addRoleForUserByUserEmail(user.getEmail(), RoleConstants.STUDENT)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
