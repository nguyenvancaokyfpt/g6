/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.dao.impl;

import com.tss.dao.BaseDao;
import com.tss.dao.MilestoneDao;
import com.tss.model.Milestone;
import com.tss.model.MilestoneRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class MilestoneDaoImpl implements MilestoneDao{
   
    @Override
    public List<Milestone> List(Connection connection, String title , int currentPageNo, int PageSize) throws SQLException {
       PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Milestone> milestoneList = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT m.milestone_id AS mileStoneId,s.subject_code AS subject,c.class_code AS classCode, from_date,to_date,m.title AS title,m.ass_body AS assBody, m.description AS description, m.status_id AS statusId FROM milestone AS m LEFT JOIN assignment AS a ON m.ass_id = a.ass_id LEFT JOIN subject s ON a.subject_id = s.subject_id LEFT JOIN class AS c ON m.class_id = c.class_id WHERE m.title LIKE ? LIMIT ?, ?";
            // Search and Paging
            Object[] params = {"%" + title + "%",PageSize, currentPageNo};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);

                while (resultSet.next()) {
                    Milestone milestone = new Milestone();
                    milestone.setMilestoneId(resultSet.getInt("mileStoneId"));
                    milestone.setSubject(resultSet.getString("subject"));
                    milestone.setClassCode(resultSet.getString("classCode"));
                    milestone.setFromDate(resultSet.getTimestamp("from_date"));
                    milestone.setToDate(resultSet.getTimestamp("to_date"));
                    milestone.setTitle(resultSet.getString("title"));
                    milestone.setAssBody(resultSet.getString("assBody"));
                    milestone.setDescription(resultSet.getString("description"));
                    milestone.setStatusId(resultSet.getInt("statusId"));
                    milestoneList.add(milestone);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return milestoneList;

    }

    @Override
    public int count(Connection connection) throws SQLException {
       PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(1) AS count FROM milestone";
            Object[] params = {};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    count = resultSet.getInt("count");
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
    public int add(Connection connection, MilestoneRequest milestoneRequest) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "INSERT INTO milestone(ass_id,class_id,from_date,to_date,title,ass_body,description,status_id) VALUES(?,?,?,?,?,?,?)";
            Object[] params = {milestoneRequest.getAssId(), milestoneRequest.getClassId(), milestoneRequest.getFromDate(),
                    milestoneRequest.getToDate(), milestoneRequest.getTitle(), milestoneRequest.getAssBody(), milestoneRequest.getDescription(), milestoneRequest.getStatusId()};
            try {
                int updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
                if (updateRows > 0) {
                    return updateRows;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
        return 0;
    }

    @Override
    public Milestone findById(Connection connection, int mileStoneId) throws SQLException {
     PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Milestone milestone = new Milestone();
        if (connection != null) {
            String sql = "SELECT \n" +
"    m.milestone_id AS mileStoneId,\n" +
"    s.subject_code AS subject,\n" +
"    c.class_code AS classCode,\n" +
"    from_date,\n" +
"    to_date,\n" +
"    m.title AS title,\n" +
"    m.ass_body AS assBody,\n" +
"    m.description AS description,\n" +
"    m.status_id AS statusId\n" +
"FROM\n" +
"    milestone AS m\n" +
"        LEFT JOIN\n" +
"    assignment AS a ON m.ass_id = a.ass_id\n" +
"        LEFT JOIN\n" +
"    subject s ON a.subject_id = s.subject_id\n" +
"        LEFT JOIN\n" +
"    class AS c ON m.class_id = c.class_id WHERE m.milestone_id = ?";
            Object[] params = {mileStoneId};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    milestone.setMilestoneId(resultSet.getInt("mileStoneId"));
                    milestone.setSubject(resultSet.getString("subject"));
                    milestone.setClassCode(resultSet.getString("classCode"));
                    milestone.setFromDate(resultSet.getTimestamp("from_date"));
                    milestone.setToDate(resultSet.getTimestamp("to_date"));
                    milestone.setTitle(resultSet.getString("title"));
                    milestone.setAssBody(resultSet.getString("assBody"));
                    milestone.setDescription(resultSet.getString("description"));
                    milestone.setStatusId(resultSet.getInt("statusId"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return milestone; }

    @Override
    public void update(Connection connection, int mileStoneId, int assId, int classId, Date fromDate, Date toDate, String title, String assBody, String description, int statusId) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "UPDATE milestone SET ass_id = ?, class_id = ?, " +
                    "from_date = ?, to_date = ?, title = ? , ass_body = ?, description = ?, status_id = ? WHERE milestone_id = ?";
            Object[] params = {assId, classId, fromDate, toDate, title, assBody, description, statusId , mileStoneId};
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
