package com.tss.service.impl;

import java.sql.Connection;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.SettingDao;
import com.tss.dao.SubjectSettingDao;
import com.tss.dao.impl.SettingDaoImpl;
import com.tss.dao.impl.SubjectSettingDaoImpl;
import com.tss.model.system.Setting;
import com.tss.model.system.SubjectSetting;
import com.tss.service.SubjectSettingService;

public class SubjectSettingServiceImpl implements SubjectSettingService {

    private SubjectSettingDao subjectSettingDao;
    private SettingDao settingDao;

    public SubjectSettingServiceImpl() {
        subjectSettingDao = new SubjectSettingDaoImpl();
        settingDao = new SettingDaoImpl();
    }

    @Override
    public int countAll() {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = subjectSettingDao.countAll(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public boolean add(SubjectSetting subjectSetting) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (subjectSettingDao.add(connection, subjectSetting) > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public boolean update(SubjectSetting subjectSetting) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (subjectSettingDao.update(connection, subjectSetting) > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public boolean changeStatus(int id) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (subjectSettingDao.changeStatus(connection, id) > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public SubjectSetting findById(int id) {
        Connection connection = null;
        SubjectSetting subjectSetting = null;
        try {
            connection = BaseDao.getConnection();
            subjectSetting = subjectSettingDao.findById(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return subjectSetting;
    }

    @Override
    public List<SubjectSetting> getSubjectSettingList(int start, int length, String search, String subjectFilter,
            String typeFilter, String statusFilter) {
        Connection connection = null;
        List<SubjectSetting> subjectSettingList = null;
        try {
            connection = BaseDao.getConnection();
            subjectSettingList = subjectSettingDao.getSubjectSettingList(connection, start, length, search,
                    subjectFilter, typeFilter, statusFilter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return subjectSettingList;
    }

    @Override
    public int countAll(String search, String subjectFilter, String typeFilter, String statusFilter) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = subjectSettingDao.countAll(connection, search, subjectFilter, typeFilter, statusFilter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public List<Setting> getSettings() {
        Connection connection = null;
        List<Setting> settings = null;
        try {
            connection = BaseDao.getConnection();
            settings = settingDao.List(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return settings;
    }

}
