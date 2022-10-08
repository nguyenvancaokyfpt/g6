package com.tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.dao.PermissionDao;
import com.tss.model.sercurity.Permission;

public class PermissionDaoImpl implements PermissionDao {

    @Override
    public List<Permission> List(Connection connection) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Permission> ListByScreenId(Connection connection, int screenId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Permission> ListBySettingId(Connection connection, int settingId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Permission> permissions = new ArrayList<Permission>();
        try {
            String sql = "select * from permission where setting_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, settingId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Permission permission = new Permission();
                permission.setScreenId(resultSet.getInt("screen_id"));
                permission.setSettingId(resultSet.getInt("setting_id"));
                permission.setCanGet(resultSet.getBoolean("can_get"));
                permission.setCanDelete(resultSet.getBoolean("can_delete"));
                permission.setCanUpdate(resultSet.getBoolean("can_update"));
                permission.setCanCreate(resultSet.getBoolean("can_create"));
                permissions.add(permission);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return permissions;
    }

    @Override
    public Permission findByScreenId(Connection connection, int screenId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Permission findBySettingId(Connection connection, int settingId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Permission findByScreenIdAndSettingId(Connection connection, int screenId, int settingId)
            throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int add(Connection connection, Permission permission) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int del(Connection connection, int settingId, int screenId) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int modify(Connection connection, int settingId, int screenId, Permission permission) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
