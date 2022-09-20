package com.tss.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.dao.SettingDao;
import com.tss.model.system.Setting;

public class SettingDaoIml implements SettingDao {

    @Override
    public List<Setting> List(Connection connection) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Setting> ListByTypeId(Connection connection) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Setting findById(Connection connection, int id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int add(Connection connection, Setting setting) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int del(Connection connection, int id) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int modify(Connection connection, int id, Setting setting) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Setting findByName(Connection connection, String name) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int count(Connection connection) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }


}
    
