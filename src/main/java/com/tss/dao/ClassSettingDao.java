package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.model.system.ClassSetting;

public interface ClassSettingDao {

    List<ClassSetting> findAll(Connection connection, int start, int length, String search, String columnName,
            String orderDir, String typeFilter, String statusFilter, int classId) throws SQLException;

    int countAll(Connection connection, int classId) throws SQLException;

    int countAll(Connection connection, String search, String typeFilter, String statusFilter, int classId) throws SQLException;

    void updateStatus(Connection connection, int settingId, boolean b) throws SQLException;

    ClassSetting getSettingById(Connection connection, int settingId) throws SQLException;

    void updateClassSetting(Connection connection, int settingId, String value, String description, String displayOrder,
            int active) throws SQLException;
    
}
