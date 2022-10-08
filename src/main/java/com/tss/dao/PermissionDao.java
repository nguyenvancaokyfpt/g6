package com.tss.dao;

import com.tss.model.sercurity.Permission;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PermissionDao {

    List<Permission> List(Connection connection) throws SQLException;

    List<Permission> ListByScreenId(Connection connection, int screenId) throws SQLException;

    List<Permission> ListBySettingId(Connection connection, int settingId) throws SQLException;

    Permission findByScreenId(Connection connection, int screenId) throws SQLException;

    Permission findBySettingId(Connection connection, int settingId) throws SQLException;

    Permission findByScreenIdAndSettingId(Connection connection, int screenId, int settingId) throws SQLException;

    int add(Connection connection, Permission permission) throws SQLException;

    int del(Connection connection, int settingId, int screenId) throws SQLException;

    int modify(Connection connection, int settingId, int screenId, Permission permission) throws SQLException;

}
