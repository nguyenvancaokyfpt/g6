package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.model.system.Setting;

public interface SettingDao {

    List<Setting> List(Connection connection) throws SQLException;
    
    List<Setting> ListPaging(Connection connection, int offset) throws SQLException;
    
    List<Setting> CompleteList(Connection connection, int offset, String searchword, String order,String dir) throws SQLException;

    List<Setting> ListByTypeId(Connection connection) throws SQLException;

    Setting findById(Connection connection, int id) throws SQLException;

    int add(Connection connection, Setting setting) throws SQLException;

    int del(Connection connection, int id) throws SQLException;

    int modify(Connection connection, int id, Setting setting) throws SQLException;

    Setting findByName(Connection connection, String name) throws SQLException;

    int count(Connection connection) throws SQLException;
    
    int countComplete(Connection connection, String searchword, String order) throws SQLException;
    
    void updateSetting(Connection connection, int id, int type_id,String title,String value,String display_order,int status_id,String description) throws SQLException;
    void addSetting(Connection connection, int id, int type_id,String title,String value,String display_order,int status_id,String description) throws SQLException;
}
