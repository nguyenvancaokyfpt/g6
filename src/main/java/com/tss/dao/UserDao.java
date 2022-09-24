package com.tss.dao;

import com.tss.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> List(Connection connection, String fullName, String email, int currentPageNo, int PageSize) throws SQLException;

    User findById(Connection connection, int userId) throws SQLException;

    int add(Connection connection, User user) throws SQLException;

    int del(Connection connection, int id) throws SQLException;

    int modify(Connection connection, int id, User user) throws SQLException;

    User findByUsername(Connection connection, String username) throws SQLException;

    User findByEmail(Connection connection, String email) throws SQLException;

    int count(Connection connection) throws SQLException;

    int count(Connection connection, String fullName, String email) throws SQLException;

    java.util.List<User> findAll(Connection connection, int start, int length, String search) throws SQLException;

    int countAll(Connection connection) throws SQLException;

    int countAll(Connection connection, String search) throws SQLException;

}
