package com.tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.UserRoleDao;
import com.tss.model.sercurity.UserRole;

public class UserRoleDaoImpl implements UserRoleDao {

    @Override
    public List<UserRole> List(Connection connection, int currentPageNo, int PageSize) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserRole> findByUserId(Connection connection, int userId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<UserRole> userRoleList = new ArrayList<UserRole>();
        if (connection != null) {
            String sql = "select * from user_role where user_id = ?";
            Object[] params = {userId};
            resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
            while (resultSet.next()) {
                UserRole userRole = new UserRole();
                userRole.setUserId(resultSet.getInt("user_id"));
                userRole.setSettingId(resultSet.getInt("setting_id"));
                userRoleList.add(userRole);
            }
            BaseDao.closeResource(null, preparedStatement, resultSet);
        }
        return userRoleList;
    }

    @Override
    public List<UserRole> findByRoleId(Connection connection, int roleId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int add(Connection connection, UserRole userRole) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int del(Connection connection, int userId, int roleId) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int modify(Connection connection, int userId, int roleId, UserRole userRole) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int count(Connection connection) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int countByUserId(Connection connection, int userId) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int countByRoleId(Connection connection, int roleId) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
