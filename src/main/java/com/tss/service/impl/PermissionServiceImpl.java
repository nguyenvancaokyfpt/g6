package com.tss.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.PermissionDao;
import com.tss.dao.impl.PermissionDaoImpl;
import com.tss.model.sercurity.Permission;
import com.tss.service.PermissionService;

public class PermissionServiceImpl implements PermissionService {

    private PermissionDao permissionDao;

    public PermissionServiceImpl() {
        permissionDao = new PermissionDaoImpl();
    }

    @Override
    public List<Permission> List() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Permission> ListByScreenId(int screenId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Permission> ListBySettingId(int settingId) {
        Connection connection = null;
        List<Permission> permissions = null;
        try {
            connection = BaseDao.getConnection();
            permissions = permissionDao.ListBySettingId(connection, settingId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return permissions;
    }

    @Override
    public Permission findByScreenId(int screenId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Permission findBySettingId(int settingId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Permission findByScreenIdAndSettingId(int screenId, int settingId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int add(Permission permission) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int del(int settingId, int screenId) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int modify(int settingId, int screenId, Permission permission) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
