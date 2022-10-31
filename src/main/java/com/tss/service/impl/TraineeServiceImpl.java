package com.tss.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.tss.dao.BaseDao;
import com.tss.dao.TraineeDao;
import com.tss.dao.impl.TraineeDaoImpl;
import com.tss.service.TraineeService;

public class TraineeServiceImpl implements TraineeService {

    private TraineeDao traineeDao;

    public TraineeServiceImpl() {
        traineeDao = new TraineeDaoImpl();
    }

    @Override
    public void dropout(int userId, Date dateDropout) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            traineeDao.dropout(connection, userId, dateDropout);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
    }

    @Override
    public void active(int userId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            traineeDao.active(connection, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
    }

    @Override
    public void deactive(int userId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            traineeDao.deactive(connection, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
    }

}
