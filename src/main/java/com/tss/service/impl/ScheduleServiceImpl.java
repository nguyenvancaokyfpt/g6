package com.tss.service.impl;

import com.tss.dao.BaseDao;
import com.tss.dao.ScheduleDao;
import com.tss.dao.impl.ScheduleDaoImpl;
import com.tss.model.Schedule;
import com.tss.service.ScheduleService;
import java.sql.Connection;
import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {

    private ScheduleDao scheduleDao;

    public ScheduleServiceImpl() {
        scheduleDao = new ScheduleDaoImpl();
    }

    @Override
    public List<Schedule> getScheduleList(String begin, String end, String search, 
            String classFilter) {
        Connection connection = null;
        List<Schedule> scheduleList = null;
        try {
            connection = BaseDao.getConnection();
            scheduleList = scheduleDao.getScheduleList(connection, begin, end, search, classFilter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return scheduleList;
    }

    @Override
    public boolean update(Schedule schedule) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (scheduleDao.update(connection, schedule) > 0) {
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
    public boolean add(Schedule schedule) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (scheduleDao.add(connection, schedule) > 0) {
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
    public Schedule getScheduleById(int id) {
        Connection connection = null;
        Schedule schedule = null;
        try {
            connection = BaseDao.getConnection();
            schedule = scheduleDao.getScheduleById(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return schedule;
    }

    @Override
    public boolean checkDupSchedule(Schedule schedule) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            flag = scheduleDao.checkDupSchedule(connection, schedule);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

}
