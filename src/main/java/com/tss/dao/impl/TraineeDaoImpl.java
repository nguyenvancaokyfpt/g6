package com.tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.tss.dao.BaseDao;
import com.tss.dao.TraineeDao;
import com.tss.helper.DebugHelper;
import com.tss.model.Trainee;

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

    @Override
    public Trainee getTraineeById(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Trainee trainee = null;
        if (connection != null) {
            String sql = "SELECT user.*, class_user.class_id, class_user.status_id, class_user.dropout_date FROM user, class_user WHERE user.id = class_user.user_id AND user.id = ?";
            Object[] params = { id };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    trainee = new Trainee();
                    trainee.setUserId(resultSet.getInt("user_id"));
                    trainee.setFullname(resultSet.getString("fullname"));
                    trainee.setEmail(resultSet.getString("email"));
                    trainee.setMobile(resultSet.getString("mobile"));
                    trainee.setNote(resultSet.getString("note"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return trainee;
    }

    @Override
    public Trainee getTraineeByTraineeIdAndClassId(Connection connection, int id, int classId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Trainee trainee = null;
        if (connection != null) {
            String sql = "SELECT user.*, class_user.class_id, class_user.status_id, class_user.dropout_date FROM user, class_user WHERE user.user_id = class_user.user_id AND user.user_id = ? AND class_user.class_id = ?";
            Object[] params = { id, classId };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    trainee = new Trainee();
                    trainee.setUserId(resultSet.getInt("user_id"));
                    trainee.setFullname(resultSet.getString("full_name"));
                    trainee.setEmail(resultSet.getString("email"));
                    trainee.setMobile(resultSet.getString("mobile"));
                    trainee.setNote(resultSet.getString("note"));
                    trainee.setClassId(resultSet.getInt("class_id"));
                    trainee.setStatusId(resultSet.getInt("status_id"));
                    trainee.setDropoutDate(resultSet.getDate("dropout_date"));
                }
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return trainee;
    }

    @Override
    public void update(Connection connection, Trainee trainee) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "UPDATE user SET full_name = ?, email = ?, mobile = ?, note = ? WHERE user_id = ?";
            Object[] params = { trainee.getFullname(), trainee.getEmail(), trainee.getMobile(), trainee.getNote(),
                    trainee.getUserId() };
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
    public void updateClassUser(Connection connection, Trainee trainee) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "UPDATE class_user SET status_id = ?, dropout_date = ? WHERE user_id = ? AND class_id = ?";
            Object[] params = { trainee.getStatusId(), trainee.getDropoutDate(), trainee.getUserId(),
                    trainee.getClassId() };
            try {
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
    }

}
