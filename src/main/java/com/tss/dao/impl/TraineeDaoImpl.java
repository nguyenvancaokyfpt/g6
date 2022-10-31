package com.tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.tss.dao.BaseDao;
import com.tss.dao.TraineeDao;
import com.tss.helper.DebugHelper;

public class TraineeDaoImpl implements TraineeDao {

    @Override
    public void dropout(Connection connection, int userId, Date dateDropout) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "UPDATE class_user SET status_id = 2, dropout_date = ? WHERE user_id = ?";
            Object[] params = { dateDropout, userId };
            try {
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
    }

    @Override
    public void active(Connection connection, int userId) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "UPDATE class_user SET status_id = 1 WHERE user_id = ?";
            Object[] params = { userId };
            try {
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
    }

    @Override
    public void deactive(Connection connection, int userId) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "UPDATE class_user SET status_id = 0 WHERE user_id = ?";
            Object[] params = { userId };
            try {
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
    }

}
