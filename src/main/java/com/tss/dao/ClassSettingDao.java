package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.model.system.ClassSetting;

public interface ClassSettingDao {

    List<ClassSetting> findAll(Connection connection, int start, int length, String search, String columnName,
            String orderDir, String typeFilter, String statusFilter) throws SQLException;

    int countAll(Connection connection) throws SQLException;

    int countAll(Connection connection, String search, String typeFilter, String statusFilter) throws SQLException;
    
}
