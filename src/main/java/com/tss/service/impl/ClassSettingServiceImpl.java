package com.tss.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.ClassSettingDao;
import com.tss.dao.impl.ClassSettingDaoImpl;
import com.tss.model.system.ClassSetting;
import com.tss.model.util.DataTablesColumns;
import com.tss.service.ClassSettingService;

public class ClassSettingServiceImpl implements ClassSettingService {

    private ClassSettingDao classSettingDao;

    public ClassSettingServiceImpl() {
        classSettingDao = new ClassSettingDaoImpl();
    }

    @Override
    public List<ClassSetting> findAll(int start, int length, String search, List<DataTablesColumns> columns,
            int orderColumn,
            String orderDir, String typeFilter, String statusFilter, int classId) {
        Connection connection = null;
        List<ClassSetting> settingList = null;

        // get orderColumn name
        String columnName = "";
        try {
            columnName = columns.get(orderColumn).getData();
        } catch (Exception e) {
            columnName = "setting_id";
        }
        try {
            connection = BaseDao.getConnection();
            settingList = classSettingDao.findAll(connection, start, length, search, columnName, orderDir, typeFilter,
                    statusFilter, classId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return settingList;
    }

    @Override
    public int countAll(int classId) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = classSettingDao.countAll(connection, classId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public int countAll(String search, String typeFilter, String statusFilter, int classId) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = classSettingDao.countAll(connection, search, typeFilter, statusFilter, classId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

}
