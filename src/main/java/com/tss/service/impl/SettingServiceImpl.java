package com.tss.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.tss.dao.BaseDao;
import com.tss.dao.SettingDao;
import com.tss.dao.impl.SettingDaoImpl;
import com.tss.model.system.Setting;
import com.tss.service.SettingService;

public class SettingServiceImpl implements SettingService {

    private SettingDao settingDao;

    public SettingServiceImpl() {
        settingDao = new SettingDaoImpl();
    }

    @Override
    public Setting getSettingById(int id) {
        Connection connection = null;
        Setting setting = new Setting();
        try {
            connection = BaseDao.getConnection();
            setting = settingDao.getSettingById(connection, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return setting;
    }

}
