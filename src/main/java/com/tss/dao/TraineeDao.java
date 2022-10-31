package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public interface TraineeDao {

    void dropout(Connection connection, int userId, Date dateDropout) throws SQLException;

    void active(Connection connection, int userId) throws SQLException;

    void deactive(Connection connection, int userId) throws SQLException;

}
