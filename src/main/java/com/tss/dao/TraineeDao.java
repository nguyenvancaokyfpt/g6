package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.tss.model.Trainee;

public interface TraineeDao {

    void dropout(Connection connection, int userId, Date dateDropout) throws SQLException;

    void active(Connection connection, int userId) throws SQLException;

    void deactive(Connection connection, int userId) throws SQLException;

    Trainee getTraineeById(Connection connection, int id) throws SQLException;

    Trainee getTraineeByTraineeIdAndClassId(Connection connection, int id, int classId) throws SQLException;

    void update(Connection connection, Trainee trainee) throws SQLException;

    void updateClassUser(Connection connection, Trainee trainee) throws SQLException;
}
