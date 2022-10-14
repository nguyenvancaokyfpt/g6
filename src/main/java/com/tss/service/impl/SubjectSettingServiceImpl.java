package com.tss.service.impl;

import com.tss.dao.BaseDao;
import com.tss.dao.SubjectSettingDao;
import com.tss.dao.impl.SubjectSettingDaoImpl;
import com.tss.model.system.SubjectSetting;
import com.tss.service.SubjectSettingService;

import java.sql.Connection;
import java.util.List;

public class SubjectSettingServiceImpl implements SubjectSettingService {

    private SubjectSettingDao subjectSettingDao;

    public SubjectSettingServiceImpl() {
        subjectSettingDao = new SubjectSettingDaoImpl();
    }

    @Override
    public List<SubjectSetting> getSubjectSettingList(int start, int length,
            String search, String subjectFilter, String displayOrderFilter,
            String statusFilter, String sort) {
        Connection connection = null;
        List<SubjectSetting> list = null;
        try {
            connection = BaseDao.getConnection();
            list = subjectSettingDao.getSubjectSettingList(connection, start, length,
                    search, subjectFilter, displayOrderFilter, statusFilter, sort);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return list;
    }

    @Override
    public int countAll(String search, String subjectFilter,
            String displayOrderFilter, String statusFilter) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = subjectSettingDao.countAll(connection, search, subjectFilter,
                    displayOrderFilter, statusFilter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
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

}
