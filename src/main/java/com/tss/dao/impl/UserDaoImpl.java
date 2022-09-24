package com.tss.dao.impl;

import com.tss.dao.BaseDao;
import com.tss.dao.UserDao;
import com.tss.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> List(Connection connection, String fullName, String email, int currentPageNo, int PageSize)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT user_id, full_name, email, mobile, avatar_url, status_id, note, created_at, updated_at, last_active FROM user WHERE full_name LIKE ? AND email LIKE ? LIMIT ? OFFSET ?";
            // Search and Paging
            Object[] params = { "%" + fullName + "%", "%" + email + "%", PageSize, currentPageNo };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);

                while (resultSet.next()) {
                    User user = new User();
                    user.setUserId(resultSet.getInt("user_id"));
                    user.setFullname(resultSet.getString("full_name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setMobile(resultSet.getString("mobile"));
                    user.setAvatarUrl(resultSet.getString("avatar_url"));
                    user.setStatusId(resultSet.getInt("status_id"));
                    user.setNote(resultSet.getString("note"));
                    user.setCreatedAt(resultSet.getTimestamp("created_at"));
                    user.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                    user.setLastActive(resultSet.getTimestamp("last_active"));
                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return userList;
    }

    @Override
    public User findByUsername(Connection connection, String username) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        if (connection != null) {
            String sql = "SELECT user_id, full_name, email, mobile, avatar_url, status_id, note, created_at, updated_at, last_active FROM user WHERE username = ?";
            Object[] params = { username };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    user = new User();
                    user.setUserId(resultSet.getInt("user_id"));
                    user.setFullname(resultSet.getString("full_name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setMobile(resultSet.getString("mobile"));
                    user.setAvatarUrl(resultSet.getString("avatar_url"));
                    user.setStatusId(resultSet.getInt("status_id"));
                    user.setNote(resultSet.getString("note"));
                    user.setCreatedAt(resultSet.getTimestamp("created_at"));
                    user.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                    user.setLastActive(resultSet.getTimestamp("last_active"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return user;
    }

    @Override
    public User findByEmail(Connection connection, String email) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        if (connection != null) {
            String sql = "SELECT user_id, full_name, email, mobile, avatar_url, status_id, note, created_at, updated_at, last_active FROM user WHERE email = ?";
            Object[] params = { email };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    user = new User();
                    user.setUserId(resultSet.getInt("user_id"));
                    user.setFullname(resultSet.getString("full_name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setMobile(resultSet.getString("mobile"));
                    user.setAvatarUrl(resultSet.getString("avatar_url"));
                    user.setStatusId(resultSet.getInt("status_id"));
                    user.setNote(resultSet.getString("note"));
                    user.setCreatedAt(resultSet.getTimestamp("created_at"));
                    user.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                    user.setLastActive(resultSet.getTimestamp("last_active"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return user;
    }

    @Override
    public User findById(Connection connection, int userId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        if (connection != null) {
            String sql = "SELECT user_id, full_name, email, mobile, avatar_url, status_id, note, created_at, updated_at, last_active FROM user WHERE user_id = ?";
            Object[] params = { userId };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    user = new User();
                    user.setUserId(resultSet.getInt("user_id"));
                    user.setFullname(resultSet.getString("full_name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setMobile(resultSet.getString("mobile"));
                    user.setAvatarUrl(resultSet.getString("avatar_url"));
                    user.setStatusId(resultSet.getInt("status_id"));
                    user.setNote(resultSet.getString("note"));
                    user.setCreatedAt(resultSet.getTimestamp("created_at"));
                    user.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                    user.setLastActive(resultSet.getTimestamp("last_active"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return user;
    }

    @Override
    public int add(Connection connection, User user) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int del(Connection cnctn, int i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int modify(Connection connection, int id, User user) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int count(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(1) AS count FROM user";
            Object[] params = {};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return count;
    }

    @Override
    public int count(Connection connection, String fullName, String email) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(1) AS count FROM user WHERE full_name LIKE ? AND email LIKE ?";
            Object[] params = { "%" + fullName + "%", "%" + email + "%" };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return count;
    }

    @Override
    public List<User> findAll(Connection connection, int start, int length, String search)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT user_id, full_name, email, mobile, avatar_url, status_id, note, created_at, updated_at, last_active FROM user WHERE full_name LIKE ? OR email LIKE ? ORDER BY user_id DESC LIMIT ?, ?";
            Object[] params = { "%" + search + "%", "%" + search + "%", start, length };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    User user = new User();
                    user.setUserId(resultSet.getInt("user_id"));
                    user.setFullname(resultSet.getString("full_name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setMobile(resultSet.getString("mobile"));
                    user.setAvatarUrl(resultSet.getString("avatar_url"));
                    user.setStatusId(resultSet.getInt("status_id"));
                    user.setNote(resultSet.getString("note"));
                    user.setCreatedAt(resultSet.getTimestamp("created_at"));
                    user.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                    user.setLastActive(resultSet.getTimestamp("last_active"));
                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return userList;
    }

    @Override
    public int countAll(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(1) AS count FROM user";
            Object[] params = {};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return count;
    }

    @Override
    public int countAll(Connection connection, String search) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(1) AS count FROM user WHERE full_name LIKE ? OR email LIKE ?";
            Object[] params = { "%" + search + "%", "%" + search + "%" };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return count;
    }

    @Override
    public boolean register(Connection connection, User user) throws SQLException {
        PreparedStatement preparedStatement = null;
        boolean flag = false;
        if (connection != null) {
            String sql = "INSERT INTO user (full_name, email, username, password) VALUES (?, ?, ?, ?);";
            Object[] params = { user.getFullname(), user.getEmail(), user.getUsername(), user.getPassword() };
            try {
                int updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
                if (updateRows > 0) {
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
        return flag;
    }

    @Override
    public boolean registerWithGoogle(Connection connection, User user) throws SQLException {
        PreparedStatement preparedStatement = null;
        boolean flag = false;
        if (connection != null) {
            String sql = "INSERT INTO user (full_name, email, username, password, avatar_url) VALUES (?, ?, ?, ?, ?);";
            Object[] params = { user.getFullname(), user.getEmail(), user.getUsername(), user.getPassword(),
                    user.getAvatarUrl() };
            try {
                int updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
                if (updateRows > 0) {
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
        return flag;
    }

    @Override
    public void updateResetPasswordToken(Connection connection, String token, int user_id, long millis) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "INSERT INTO reset_password_token (user_id, token, salt) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE token = ?, salt = ?, created_at = NOW();";
            Object[] params = { user_id, token, millis, token, millis };
            
            try {
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }       
    }

    @Override
    public long getResetPasswordSaltByToken(Connection connection, String token) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        long salt = 0;
        if (connection != null) {
            String sql = "SELECT salt FROM reset_password_token WHERE token = ?";
            Object[] params = { token };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    salt = resultSet.getLong("salt");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return salt;
    }

    @Override
    public void updatePwdByEmail(Connection connection, String email, String password) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "UPDATE user SET password = ? WHERE email = ?";
            Object[] params = { password, email };
            try {
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
    }

    @Override
    public void detachResetPasswordToken(Connection connection, String email) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "DELETE FROM reset_password_token WHERE user_id = (SELECT user_id FROM user WHERE email = ?)";
            Object[] params = { email };
            try {
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
    }

}
