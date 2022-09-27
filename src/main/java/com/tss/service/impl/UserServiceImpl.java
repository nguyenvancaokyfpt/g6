package com.tss.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.constants.SecretStringConstants;
import com.tss.dao.BaseDao;
import com.tss.dao.UserDao;
import com.tss.dao.impl.UserDaoImpl;
import com.tss.helper.EncryptHelper;
import com.tss.helper.PasswordHelper;
import com.tss.model.User;
import com.tss.model.util.DataTablesColumns;
import com.tss.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public boolean updatePwd(String userCode, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> List(String fullName, String email, int currentPageNo, int PageSize) {
        Connection connection = null;
        List<User> userList = null;
        try {
            connection = BaseDao.getConnection();

            userList = userDao.List(connection, fullName, email, currentPageNo, PageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return userList;
    }

    @Override
    public User findById(int id) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.findById(connection, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }

    @Override
    public boolean add(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean del(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modify(User user) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = userDao.modify(connection, user.getUserId(), user);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return (count > 0);
    }

    @Override
    public User findByUsername(String username) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.findByUsername(connection, username);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.findByEmail(connection, email);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }

    @Override
    public int count() {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = userDao.count(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public int count(String fullName, String email) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = userDao.count(connection, fullName, email);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public List<User> findAll(int start, int length, String search) {
        Connection connection = null;
        List<User> userList = null;
        try {
            connection = BaseDao.getConnection();
            userList = userDao.findAll(connection, start, length, search);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return userList;
    }

    @Override
    public int countAll() {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = userDao.countAll(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public int countAll(String search) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = userDao.countAll(connection, search);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public String generateResetPasswordToken(User user) {
        // Generated random md5 token
        // get milliseconds
        long millis = System.currentTimeMillis();
        String token = EncryptHelper.getMd5(user.getEmail() + millis + SecretStringConstants.SECRET_STRING);
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            userDao.updateResetPasswordToken(connection, token, user.getUserId(), millis);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return token;
    }

    @Override
    public Boolean checkResetPasswordToken(String token, String email) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            // currentTimeMillis
            long currentTimeMillis = System.currentTimeMillis();
            long millis = userDao.getResetPasswordSaltByToken(connection, token);
            // if currentTimeMillis - millis > 30 minutes
            if ((millis - currentTimeMillis) > (30 * 60 * 1000)) {
                return false;
            }
            String generatedToken = EncryptHelper.getMd5(email + millis + SecretStringConstants.SECRET_STRING);
            if (generatedToken.equals(token)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return false;
    }

    @Override
    public void updatePwdByEmail(String email, String password) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            userDao.updatePwdByEmail(connection, email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
    }

    @Override
    public void detachResetPasswordToken(String email) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            userDao.detachResetPasswordToken(connection, email);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
    }

    @Override
    public boolean changePassword(User user, String currentpassword, String newpassword) {
        currentpassword = PasswordHelper.generateSecurePassword(currentpassword);
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            String pwd = userDao.getCurrentPassword(connection, user.getUserId());
            if (pwd.equals(currentpassword)) {
                userDao.updatePassword(connection, user.getUserId(),
                        PasswordHelper.generateSecurePassword(newpassword));
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return false;
    }

    @Override
    public boolean update(User user, String fullName, String email, String mobile) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            System.out.println("user id: " + user.getUserId());
            System.out.println("full name: " + fullName);
            System.out.println("email: " + email);
            System.out.println("mobile: " + mobile);
            userDao.update(connection, user.getUserId(), fullName, email, mobile);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return false;
    }

    @Override
    public List<User> findAll(int start, int length, String search,
            List<DataTablesColumns> columns, int orderColumn, String orderDir) {
        Connection connection = null;
        List<User> userList = null;

        // get orderColumn name
        String columnName = columns.get(orderColumn).getData();

        try {
            connection = BaseDao.getConnection();
            userList = userDao.findAll(connection, start, length, search, columnName, orderDir);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return userList;
    }

    @Override
    public List<User> findAll(int start, int length, String search, java.util.List<DataTablesColumns> columns,
            int orderColumn, String orderDir, String roleFilter, String statusFilter) {
        Connection connection = null;
        List<User> userList = null;

        // get orderColumn name
        String columnName = columns.get(orderColumn).getData();

        try {
            connection = BaseDao.getConnection();
            userList = userDao.findAll(connection, start, length, search, columnName, orderDir, roleFilter,
                    statusFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return userList;
    }

    @Override
    public int countAll(String search, String roleFilter, String statusFilter) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = userDao.countAll(connection, search, roleFilter, statusFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

}
