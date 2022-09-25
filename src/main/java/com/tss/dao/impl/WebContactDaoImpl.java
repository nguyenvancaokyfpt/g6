/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.dao.impl;

import com.tss.dao.BaseDao;
import com.tss.model.WebContact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tss.dao.WebContactDao;

/**
 *
 * @author Dat Lai
 */
public class WebContactDaoImpl implements WebContactDao {

    @Override
    public List<WebContact> List(Connection connection, String fullName, String email, int currentPageNo, int PageSize)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<WebContact> webList = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT * FROM web_contact WHERE full_name LIKE ? AND email LIKE ? LIMIT ? OFFSET ?";
            // Search and Paging
            Object[] params = { "%" + fullName + "%", "%" + email + "%", PageSize, currentPageNo };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);

                while (resultSet.next()) {
                    WebContact web = new WebContact();
                    web.setCategory_id(resultSet.getInt("category_id"));
                    web.setSupporter_id(resultSet.getInt("supporter_id"));
                    web.setFull_name(resultSet.getString("full_name"));
                    web.setEmail(resultSet.getString("email"));
                    web.setMobile(resultSet.getString("mobile"));
                    web.setMessage(resultSet.getString("message"));
                    web.setResponse(resultSet.getString("response"));
                    webList.add(web);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return webList;

    }

    @Override
    public WebContact findById(Connection connection, int catId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        WebContact web = null;
        if (connection != null) {
            String sql = "SELECT * FROM web_contact WHERE category_id=?";
            Object[] params = { catId };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    web = new WebContact();
                    web.setCategory_id(resultSet.getInt("category_id"));
                    web.setSupporter_id(resultSet.getInt("supporter_id"));
                    web.setFull_name(resultSet.getString("full_name"));
                    web.setEmail(resultSet.getString("email"));
                    web.setMobile(resultSet.getString("mobile"));
                    web.setMessage(resultSet.getString("message"));
                    web.setResponse(resultSet.getString("response"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return web;
    }

    @Override
    public int add(Connection connection, WebContact web) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int del(Connection connection, int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int modify(Connection connection, int id, WebContact web) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public WebContact findByUsername(Connection connection, String username) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public WebContact findByEmail(Connection connection, String email) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int count(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(1) AS count FROM web_contact";
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
            String sql = "SELECT COUNT(1) AS count FROM web_contact WHERE full_name LIKE ? AND email LIKE ?";
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
    public java.util.List<WebContact> findAll(Connection connection, int start, int length, String search)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<WebContact> webList = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT * FROM web_contact WHERE full_name LIKE ? OR email LIKE ? ORDER BY category_id DESC LIMIT ?, ?";
            Object[] params = { "%" + search + "%", "%" + search + "%", start, length };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    WebContact web = new WebContact();
                    web.setCategory_id(resultSet.getInt("category_id"));
                    web.setSupporter_id(resultSet.getInt("supporter_id"));
                    web.setFull_name(resultSet.getString("full_name"));
                    web.setEmail(resultSet.getString("email"));
                    web.setMobile(resultSet.getString("mobile"));
                    web.setMessage(resultSet.getString("message"));
                    web.setResponse(resultSet.getString("response"));
                    webList.add(web);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return webList;
    }

    @Override
    public int countAll(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(1) AS count FROM web_contact";
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
            String sql = "SELECT COUNT(1) AS count FROM web_contact WHERE full_name LIKE ? OR email LIKE ?";
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

}
