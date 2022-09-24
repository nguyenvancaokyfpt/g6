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
            Object[] params = {"%" + fullName + "%", "%" + email + "%", PageSize, currentPageNo};
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
            Object[] params = {username};
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
            Object[] params = {email};
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
            Object[] params = {userId};
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
    public int add(Connection connection, User user, String username, String pass) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "INSERT INTO `training_support_system`.`user`\n"
                    + "(`user_id`,\n"
                    + "`full_name`,\n"
                    + "`username`,\n"
                    + "`email`,\n"
                    + "`mobile`,\n"
                    + "`password`,\n"
                    + "`avatar_url`,\n"
                    + "`status_id`,\n"
                    + "`note`,\n"
                    + "`created_at`,\n"
                    + "`updated_at`,\n"
                    + "`last_active`)\n"
                    + "VALUES\n"
                    + "(?,?,?,?,?,?,?,?,?,?,?,?);";
            Object[] params = {user.getUserId(), user.getFullname(), username, user.getEmail(), user.getMobile(),
                pass, user.getAvatarUrl(), user.getStatusId(), user.getNote(), user.getCreatedAt(), user.getUpdatedAt(), user.getLastActive()};
            count = BaseDao.execute(connection, preparedStatement, sql, params);
        }
        return count;
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
            Object[] params = {"%" + fullName + "%", "%" + email + "%"};
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
            Object[] params = {"%" + search + "%", "%" + search + "%", start, length};
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
            Object[] params = {"%" + search + "%", "%" + search + "%"};
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

}
