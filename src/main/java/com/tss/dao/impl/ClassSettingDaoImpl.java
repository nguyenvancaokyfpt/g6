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
            String orderDir, String typeFilter, String statusFilter) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ClassSetting> settingList = new ArrayList<ClassSetting>();
        if (connection != null) {
            String sql = "SELECT * FROM class_setting WHERE ( setting_title LIKE ? OR setting_value LIKE ? ) AND( type_id LIKE ? AND status_id LIKE ? ) ORDER BY "
                    + columnName + " " + orderDir + " LIMIT ?,?";
            Object[] params = { "%" + search + "%", "%" + search + "%", "%" + typeFilter + "%",
                    "%" + statusFilter + "%", start, length };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    ClassSetting setting = new ClassSetting();
                    setting.setId(resultSet.getInt("setting_id"));
                    setting.setTitle(resultSet.getString("setting_title"));
                    setting.setValue(resultSet.getString("setting_value"));
                    setting.setDescription(resultSet.getString("description"));
                    setting.setTypeId(resultSet.getInt("type_id"));
                    setting.setStatusId(resultSet.getInt("status_id"));
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
    public int countAll(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(*) AS count FROM class_setting";
            Object[] params = {};
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
    public int countAll(Connection connection, String search, String typeFilter, String statusFilter)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(*) AS count FROM class_setting WHERE ( setting_title LIKE ? OR setting_value LIKE ? ) AND( type_id LIKE ? AND status_id LIKE ? )";
            Object[] params = { "%" + search + "%", "%" + search + "%", "%" + typeFilter + "%",
                    "%" + statusFilter + "%" };
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

}
