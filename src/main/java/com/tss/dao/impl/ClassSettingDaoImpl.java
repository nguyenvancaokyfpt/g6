package com.tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.ClassSettingDao;
import com.tss.helper.DebugHelper;
import com.tss.model.system.ClassSetting;

public class ClassSettingDaoImpl implements ClassSettingDao {

    @Override
    public List<ClassSetting> findAll(Connection connection, int start, int length, String search, String columnName,
            String orderDir, String typeFilter, String statusFilter, int classId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ClassSetting> settingList = new ArrayList<ClassSetting>();
        if (connection != null) {
            String sql = "SELECT setting_id,type_id,setting_title as title ,setting_value as value,value_type,display_order,class_id,status.status_id,status.status_title,description FROM class_setting inner join status on class_setting.status_id = status.status_id WHERE ( setting_title LIKE ? OR setting_value LIKE ? ) AND( type_id LIKE ? AND class_setting.status_id LIKE ? ) AND class_id = ? ORDER BY "
                    + columnName + " " + orderDir + " LIMIT ?,?";
            Object[] params = { "%" + search + "%", "%" + search + "%", "%" + typeFilter + "%",
                    "%" + statusFilter + "%",
                    classId, start, length };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    ClassSetting setting = new ClassSetting();
                    setting.setSettingId(resultSet.getInt("setting_id"));
                    setting.setTitle(resultSet.getString("title"));
                    setting.setValue(resultSet.getString("value"));
                    setting.setValueType(resultSet.getString("value_type"));
                    setting.setDescription(resultSet.getString("description"));
                    setting.setTypeId(resultSet.getInt("type_id"));
                    setting.setStatusId(resultSet.getInt("status_id"));
                    setting.setDisplayOrder(resultSet.getString("display_order"));
                    setting.setStatusTitle(resultSet.getString("status_title"));
                    setting.setClassId(resultSet.getInt("class_id"));
                    settingList.add(setting);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                DebugHelper.print("ClassSettingDaoImpl.findAll() error: " + e.getMessage());
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return settingList;
    }

    @Override
    public int countAll(Connection connection, int classId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(*) AS count FROM class_setting WHERE class_id = ?";
            Object[] params = { classId };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return count;
    }

    @Override
    public int countAll(Connection connection, String search, String typeFilter, String statusFilter, int classId)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(*) AS count FROM class_setting WHERE ( setting_title LIKE ? OR setting_value LIKE ? ) AND( type_id LIKE ? AND status_id LIKE ? ) AND class_id = ?";
            Object[] params = { "%" + search + "%", "%" + search + "%", "%" + typeFilter + "%",
                    "%" + statusFilter + "%", classId };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return count;
    }

    @Override
    public void updateStatus(Connection connection, int settingId, boolean b) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "UPDATE class_setting SET status_id = ? WHERE setting_id = ?";
            Object[] params = { b ? 1 : 0, settingId };
            try {
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
    }

    @Override
    public ClassSetting getSettingById(Connection connection, int settingId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ClassSetting setting = null;
        if (connection != null) {
            String sql = "SELECT setting_id,type_id,setting_title as title ,setting_value as value,value_type,display_order,class_id,status.status_id,status.status_title,description FROM class_setting inner join status on class_setting.status_id = status.status_id WHERE setting_id = ?";
            Object[] params = { settingId };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    setting = new ClassSetting();
                    setting.setSettingId(resultSet.getInt("setting_id"));
                    setting.setTitle(resultSet.getString("title"));
                    setting.setValue(resultSet.getString("value"));
                    setting.setValueType(resultSet.getString("value_type"));
                    setting.setDescription(resultSet.getString("description"));
                    setting.setTypeId(resultSet.getInt("type_id"));
                    setting.setStatusId(resultSet.getInt("status_id"));
                    setting.setDisplayOrder(resultSet.getString("display_order"));
                    setting.setStatusTitle(resultSet.getString("status_title"));
                    setting.setClassId(resultSet.getInt("class_id"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                DebugHelper.print("ClassSettingDaoImpl.getSettingById() error: " + e.getMessage());
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return setting;
    }

    @Override
    public void updateClassSetting(Connection connection, int settingId, String value, String description,
            String displayOrder, int active) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "UPDATE class_setting SET setting_value = ?,description = ?,display_order = ?,status_id = ? WHERE setting_id = ?";
            Object[] params = { value, description, displayOrder, active, settingId };
            try {
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
    }

}
