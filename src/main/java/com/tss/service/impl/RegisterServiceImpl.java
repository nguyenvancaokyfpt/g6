package com.tss.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.tss.constants.RoleConstants;
import com.tss.dao.BaseDao;
import com.tss.dao.UserDao;
import com.tss.dao.impl.UserDaoImpl;
import com.tss.helper.DebugHelper;
import com.tss.helper.EmailHelper;
import com.tss.helper.PasswordHelper;
import com.tss.model.Trainee;
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

    @Override
    public boolean registerUserWithGoogle(User user) {
        Connection connection = null;
        boolean flag = false;
        // random username for user from email
        user.setUsername(user.getEmail().substring(0, user.getEmail().indexOf("@")) + (int) (Math.random() * 1000000));
        // random string
        String randomString = PasswordHelper.generateRandomString(10);
        // encrypt password
        user.setPassword(PasswordHelper.generateSecurePassword(randomString));
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            flag = userDao.registerWithGoogle(connection, user);
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
                // send email to user
                EmailHelper emailHelper = new EmailHelper();
                emailHelper.sendPassword(user.getEmail(), randomString);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean registerTraineeFromFile(Trainee user, String classroom) {
        Connection connection = null;
        boolean flag = false;
        // random username for user from email
        user.setUsername(user.getEmail().substring(0, user.getEmail().indexOf("@")) + (int) (Math.random() * 1000000));
        // random string
        String randomString = PasswordHelper.generateRandomString(10);
        // encrypt password
        user.setPassword(PasswordHelper.generateSecurePassword(randomString));
        try {
            connection = BaseDao.getConnection();
            flag = userDao.registerTraineeFromFile(connection, user);
        } catch (SQLException e) {
            DebugHelper.print(e);
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        if (flag) {
            // set default role for user
            if (roleService.addRoleForUserByUserEmail(user.getEmail(), RoleConstants.STUDENT)) {
                // send email to user
                // EmailHelper emailHelper = new EmailHelper();
                // emailHelper.sendPasswordAutoRegister(user.getEmail(), randomString,
                // classroom);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean registerUser(User user) {
        Connection connection = null;
        boolean flag = false;
        // random username for user from email
        user.setUsername(user.getEmail().substring(0, user.getEmail().indexOf("@")) + (int) (Math.random() * 1000000));
        // random string
        String randomString = PasswordHelper.generateRandomString(10);
        // encrypt password
        user.setPassword(PasswordHelper.generateSecurePassword(randomString));
        user.setAvatarUrl("assets/media/avatars/blank.png");
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            flag = userDao.registerWithGoogle(connection, user);
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
            if (roleService.addRoleForUserByUserEmail(user.getEmail(),
                    RoleConstants.getRoleById(user.getRole().getId()))) {
                // send email to user
                // EmailHelper emailHelper = new EmailHelper();
                // emailHelper.sendPassword(user.getEmail(), randomString);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
