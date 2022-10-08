package com.tss.dao.impl;

import com.tss.dao.AssignmentDao;
import com.tss.dao.BaseDao;
import com.tss.model.Assignment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDaoImpl implements AssignmentDao {

    @Override
    public List<Assignment> findAll(Connection connection, int start, int length, String search, 
             String subjectFilter, String isTeamworkFilter, String isOngoingFilter, String statusFilter)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Assignment> list = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT a.*, s.subject_name\n"
            +"FROM assignment a join subject s on a.subject_id = s.subject_id\n" 
            +"WHERE (a.title LIKE ? or s.subject_name like ?)\n" 
            +"AND a.subject_id LIKE ? AND a.is_ongoing LIKE ? AND a.is_team_work LIKE ? AND a.status_id like ?\n" 
            +"LIMIT ?, ?;";
            Object[] params = { "%" + search + "%", "%" + search + "%", "%" + subjectFilter + "%",
                    "%" + isOngoingFilter + "%",
                    "%" + isTeamworkFilter + "%", "%" + statusFilter + "%", start, length };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    Assignment assignment = new Assignment();
                    assignment.setAssId(resultSet.getInt("ass_id"));
                    assignment.setSubjectId(resultSet.getInt("subject_id"));
                    assignment.setTitle(resultSet.getString("title"));
                    assignment.setAssBody(resultSet.getString("ass_body"));
                    assignment.setEvalWeight(resultSet.getInt("eval_weight"));
                    assignment.setIsTeamwork(resultSet.getInt("is_team_work"));
                    assignment.setIsOngoing(resultSet.getInt("is_ongoing"));
                    assignment.setStatusId(resultSet.getInt("status_id"));
                    assignment.setSubjectName(resultSet.getString("subject_name"));
                    list.add(assignment);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return list;
    }

    @Override
    public int countAll(Connection connection, String search, String subjectFilter,
            String isTeamworkFilter, String isOngoingFilter, String statusFilter)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(*)\n"
            +"FROM assignment a join subject s on a.subject_id = s.subject_id\n" 
            +"WHERE (a.title LIKE ? or s.subject_name like ?)\n" 
            +"AND a.subject_id LIKE ? AND a.is_ongoing LIKE ? AND a.is_team_work LIKE ? AND a.status_id like ?"; 
            Object[] params = { "%" + search + "%", "%" + search + "%", "%" + subjectFilter + "%",
                    "%" + isOngoingFilter + "%",
                    "%" + isTeamworkFilter + "%", "%" + statusFilter + "%" };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return count;
    }

    @Override
    public int countAll(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "select count(*) from assignment";
            Object[] params = {};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return count;
    }

    @Override
    public int add(Connection connection, Assignment assignment) throws SQLException {
        PreparedStatement preparedStatement = null;
        int updateRows = 0;
        if (connection != null) {
            String sql = "INSERT INTO assignment (subject_id, title, ass_body, eval_weight, is_team_work, is_ongoing, status_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
            Object[] params = { assignment.getSubjectId(), assignment.getTitle(), assignment.getAssBody(),
                    assignment.getEvalWeight(), assignment.getIsTeamwork(), assignment.getIsOngoing(),
                    assignment.getStatusId() };
            try {
                updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
        return updateRows;
    }

    @Override
    public int update(Connection connection, Assignment assignment) throws SQLException {
        PreparedStatement preparedStatement = null;
        int updateRows = 0;
        if (connection != null) {
            String sql = "UPDATE assignment SET subject_id = ?, title = ?, ass_body = ?, eval_weight = ?, is_team_work = ?, is_ongoing = ?, status_id = ? WHERE ass_id = ?";
            Object[] params = { assignment.getSubjectId(), assignment.getTitle(), assignment.getAssBody(),
                    assignment.getEvalWeight(), assignment.getIsTeamwork(), assignment.getIsOngoing(),
                    assignment.getStatusId(), assignment.getAssId() };
            try {
                updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
        return updateRows;
    }

    @Override
    public int changeStatus(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        int updateRows = 0;
        if (connection != null) {
            String sql = "";
            if (findById(connection, id).getStatusId() == 1) {
                sql = "UPDATE assignment SET status_id = 0 WHERE ass_id = ?";
            } else {
                sql = "UPDATE assignment SET status_id = 1 WHERE ass_id = ?";
            }
            Object[] params = { id };
            try {
                updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
        return updateRows;
    }

    @Override
    public Assignment findById(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Assignment assignment = null;
        if (connection != null) {
            String sql = "SELECT * FROM assignment WHERE ass_id = ?";
            Object[] params = { id };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    assignment = new Assignment();
                    assignment.setAssId(resultSet.getInt("ass_id"));
                    assignment.setSubjectId(resultSet.getInt("subject_id"));
                    assignment.setTitle(resultSet.getString("title"));
                    assignment.setAssBody(resultSet.getString("ass_body"));
                    assignment.setEvalWeight(resultSet.getInt("eval_weight"));
                    assignment.setIsTeamwork(resultSet.getInt("is_team_work"));
                    assignment.setIsOngoing(resultSet.getInt("is_ongoing"));
                    assignment.setStatusId(resultSet.getInt("status_id"));
                    assignment.setSubjectName(resultSet.getString("subject_name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return assignment;
    }

}
