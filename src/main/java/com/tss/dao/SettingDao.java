package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.model.system.Setting;

public interface SettingDao {

    List<Setting> List(Connection connection) throws SQLException;

    List<Setting> ListByTypeId(Connection connection) throws SQLException;

    Setting findById(Connection connection, int id) throws SQLException;

    int add(Connection connection, Setting setting) throws SQLException;

    int del(Connection connection, int id) throws SQLException;

    int modify(Connection connection, int id, Setting setting) throws SQLException;

    Setting findByName(Connection connection, String name) throws SQLException;

    int count(Connection connection) throws SQLException;

    
}
