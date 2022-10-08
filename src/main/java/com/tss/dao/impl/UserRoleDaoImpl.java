package com.tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.UserRoleDao;
import com.tss.model.payload.RolePermissionMessage;
import com.tss.model.sercurity.Permission;
import com.tss.model.sercurity.UserRole;
import com.tss.model.system.Screen;

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
            Object[] params = { userId };
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

    @Override
    public boolean addRoleForUserByUserEmail(Connection connection, String email, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        boolean flag = false;
        if (connection != null) {
            String sql = "insert into user_role(user_id,setting_id) values((select user_id from user where email = ?),?)";
            Object[] params = { email, id };
            try {
                int updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
                if (updateRows > 0) {
                    flag = true;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
        return flag;
    }

    @Override
    public int countUserByRole(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "select count(*) as count from user_role where setting_id = ?";
            Object[] params = { id };
            resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }
            BaseDao.closeResource(null, preparedStatement, resultSet);
        }
        return count;
    }

    @Override
    public List<Screen> getPermissionByRole(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Screen> screenList = new ArrayList<Screen>();
        if (connection != null) {
            String sql = "select * from screen where screen_id in (select screen_id from permission where setting_id = ? and (can_get = 1 or can_create = 1 or can_update = 1 or can_delete = 1))";
            Object[] params = { id };
            resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
            while (resultSet.next()) {
                Screen screen = new Screen();
                screen.setId(resultSet.getInt("screen_id"));
                screen.setTitle(resultSet.getString("title"));
                screen.setPath(resultSet.getString("path"));
                screenList.add(screen);
            }
            BaseDao.closeResource(null, preparedStatement, resultSet);
        }
        return screenList;
    }

    @Override
    public Boolean updateRolePermission(Connection connection, int roleId, Permission permission) throws SQLException {
        PreparedStatement preparedStatement = null;
        Boolean flag = false;
        if (connection != null) {
            // insert if not exist, otherwise update
            String sql = "insert into permission(setting_id,screen_id,can_get,can_create,can_update,can_delete) values(?,?,?,?,?,?) on duplicate key update can_get = ?,can_create = ?,can_update = ?,can_delete = ?";
            Object[] params = { roleId, permission.getScreenId(), permission.isCanGet(), permission.isCanCreate(),
                    permission.isCanUpdate(), permission.isCanDelete(), permission.isCanGet(), permission.isCanCreate(),
                    permission.isCanUpdate(), permission.isCanDelete() };
            try {
                int updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
                if (updateRows > 0) {
                    flag = true;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
        return flag;
    }

    @Override
    public RolePermissionMessage getRolePermission(Connection connection, int roleId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        RolePermissionMessage rolePermissionMessageList = new RolePermissionMessage();
        rolePermissionMessageList.setRoleId(roleId);
        List<Permission> permissions = new ArrayList<Permission>();
        if (connection != null) {
            String sql = "select * from permission where setting_id = ?";
            Object[] params = { roleId };
            resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
            while (resultSet.next()) {
                Permission permission = new Permission();
                permission.setSettingId(resultSet.getInt("setting_id"));
                permission.setScreenId(resultSet.getInt("screen_id"));
                permission.setCanCreate(resultSet.getBoolean("can_create"));
                permission.setCanGet(resultSet.getBoolean("can_get"));
                permission.setCanDelete(resultSet.getBoolean("can_delete"));
                permission.setCanUpdate(resultSet.getBoolean("can_update"));
                permissions.add(permission);
            }
            rolePermissionMessageList.setPermissions(permissions);
            BaseDao.closeResource(null, preparedStatement, resultSet);
        }
        return rolePermissionMessageList;
    }

}
