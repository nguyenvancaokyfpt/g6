package com.tss.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.tss.dao.BaseDao;
import com.tss.dao.TraineeDao;
import com.tss.dao.impl.TraineeDaoImpl;
import com.tss.model.Trainee;
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

    @Override
    public Trainee getTraineeById(int id) {
        Connection connection = null;
        Trainee trainee = null;
        try {
            connection = BaseDao.getConnection();
            trainee = traineeDao.getTraineeById(connection, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return trainee;
    }

    @Override
    public Trainee getTraineeByTraineeIdAndClassId(int id, int classId) {
        Connection connection = null;
        Trainee trainee = null;
        try {
            connection = BaseDao.getConnection();
            trainee = traineeDao.getTraineeByTraineeIdAndClassId(connection, id, classId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return trainee;
    }

    @Override
    public void update(Trainee trainee) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            traineeDao.update(connection, trainee);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
    }

    @Override
    public void updateClassUser(Trainee trainee) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            traineeDao.updateClassUser(connection, trainee);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
    }

}
