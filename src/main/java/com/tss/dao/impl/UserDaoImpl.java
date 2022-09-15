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
            String sql = "SELECT user_id, full_name, email, mobile, avatar_url, status_id, note FROM user WHERE full_name LIKE ? AND email LIKE ? LIMIT ? OFFSET ?";
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
            String sql = "SELECT user_id, full_name, email, mobile, avatar_url, status_id, note FROM user WHERE username = ?";
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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





}
