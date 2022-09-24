package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.model.sercurity.UserRole;

public interface UserRoleDao {

    List<UserRole> List(Connection connection, int currentPageNo, int PageSize) throws SQLException;

    List<UserRole> findByUserId(Connection connection, int userId) throws SQLException;

    List<UserRole> findByRoleId(Connection connection, int roleId) throws SQLException;

    int add(Connection connection, UserRole userRole) throws SQLException;

    int del(Connection connection, int userId, int roleId) throws SQLException;

    int modify(Connection connection, int userId, int roleId, UserRole userRole) throws SQLException;

    int count(Connection connection) throws SQLException;

    int countByUserId(Connection connection, int userId) throws SQLException;

    int countByRoleId(Connection connection, int roleId) throws SQLException;

    boolean addRoleForUserByUserEmail(Connection connection, String email, int id) throws SQLException;

}
