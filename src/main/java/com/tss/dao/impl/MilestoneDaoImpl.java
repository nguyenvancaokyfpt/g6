/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.MilestoneDao;
import com.tss.helper.DebugHelper;
import com.tss.model.Assignment;
import com.tss.model.Milestone;
import com.tss.model.system.Role;

/**
 *
 * @author ADMIN
 */
public class MilestoneDaoImpl implements MilestoneDao {

    @Override
    public List<Milestone> List(Connection connection, String title, int currentPageNo, int PageSize)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Milestone> milestoneList = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT \n"
                    + "    m.milestone_id AS mileStoneId,\n"
                    + "    a.title AS assTitle,\n"
                    + "    c.class_code AS classCode,\n"
                    + "    from_date,\n"
                    + "    to_date,\n"
                    + "    m.title AS title,\n"
                    + "    m.ass_body AS assBody,\n"
                    + "    m.description AS description,\n"
                    + "    m.status_id AS statusId\n"
                    + "FROM\n"
                    + "    milestone AS m\n"
                    + "        LEFT JOIN\n"
                    + "    assignment AS a ON m.ass_id = a.ass_id\n"
                    + "        LEFT JOIN\n"
                    + "    class AS c ON m.class_id = c.class_id\n"
                    + "WHERE\n"
                    + "    m.title LIKE ?\n"
                    + "LIMIT ? , ?";
            // Search and Paging
            Object[] params = {"%" + title + "%", currentPageNo, PageSize};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);

                while (resultSet.next()) {
                    Milestone milestone = new Milestone();
                    milestone.setMilestoneId(resultSet.getInt("mileStoneId"));
                    milestone.setAssTitle(resultSet.getString("assTitle"));
                    milestone.setClassCode(resultSet.getString("classCode"));
                    milestone.setFromDate(resultSet.getTimestamp("from_date"));
                    milestone.setToDate(resultSet.getTimestamp("to_date"));
                    milestone.setTitle(resultSet.getString("title"));
                    milestone.setAssBody(resultSet.getString("assBody"));
                    milestone.setDescription(resultSet.getString("description"));
                    milestone.setStatusId(resultSet.getInt("statusId"));
                    DebugHelper.print(milestone);
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
    public int add(Connection connection, Milestone milestone) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "INSERT INTO milestone(ass_id,class_id,from_date,to_date,title,ass_body,description,status_id) VALUES(?,?,?,?,?,?,?,?)";
            Object[] params = {milestone.getAssId(), milestone.getClassId(), milestone.getFromDate(),
                milestone.getToDate(), milestone.getTitle(), milestone.getAssBody(), milestone.getDescription(),
                milestone.getStatusId()};
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
            String sql = "SELECT \n"
                    + "    m.milestone_id AS mileStoneId,\n"
                    + "    m.ass_id as assId,\n"
                    + "    m.class_id as classId,\n"
                    + "    s.subject_code AS subject,\n"
                    + "    a.subject_id as subjectId,\n"
                    + "    c.class_code AS classCode,\n"
                    + "    from_date,\n"
                    + "    to_date,\n"
                    + "    m.title AS title,\n"
                    + "    m.ass_body AS assBody,\n"
                    + "    m.description AS description,\n"
                    + "    m.status_id AS statusId\n"
                    + "FROM\n"
                    + "    milestone AS m\n"
                    + "        LEFT JOIN\n"
                    + "    assignment AS a ON m.ass_id = a.ass_id\n"
                    + "        LEFT JOIN\n"
                    + "    subject s ON a.subject_id = s.subject_id\n"
                    + "        LEFT JOIN\n"
                    + "    class AS c ON m.class_id = c.class_id WHERE m.milestone_id = ?";
            Object[] params = {mileStoneId};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    milestone.setMilestoneId(resultSet.getInt("mileStoneId"));
                    milestone.setAssId(resultSet.getInt("assId"));
                    milestone.setClassId(resultSet.getInt("classId"));
                    milestone.setSubject(resultSet.getString("subject"));
                    milestone.setSubjectId(resultSet.getInt("subjectId"));
                    milestone.setClassCode(resultSet.getString("classCode"));
                    milestone.setFromDate(resultSet.getDate("from_date"));
                    milestone.setToDate(resultSet.getDate("to_date"));
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
        return milestone;
    }

    @Override
    public void update(Connection connection, int mileStoneId, int classId, Date fromDate, Date toDate, String title,
            String assBody, String description, int statusId) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "UPDATE milestone SET class_id = ?, "
                    + "from_date = ?, to_date = ?, title = ? , ass_body = ?, description = ?, status_id = ? WHERE milestone_id = ?";
            Object[] params = {classId, fromDate, toDate, title, assBody, description, statusId, mileStoneId};
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
    public void updateAssId(Connection connection, int assId, int subjectId) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "UPDATE assignment SET subject_id = ? WHERE ass_id = ?";
            Object[] params = {subjectId, assId};
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
    public List<Assignment> findAll(Connection connection, int start, int length) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Assignment> list = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT \n"
                    + "    a.*, s.subject_name\n"
                    + "FROM\n"
                    + "    assignment a\n"
                    + "        JOIN\n"
                    + "    subject s ON a.subject_id = s.subject_id\n"
                    + "LIMIT ? , ?";
            Object[] params = {start, length};
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
    public int countAll(Connection connection, String search) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(1) AS count FROM milestone WHERE title LIKE ?";
            Object[] params = {"%" + search + "%"};
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

    public static void main(String[] args) throws SQLException {
        MilestoneDaoImpl milestoneDao = new MilestoneDaoImpl();
        System.out.println(milestoneDao.findAllBySupporter(BaseDao.getConnection(), 2, 0).size());
    }

    @Override
    public java.util.List<Milestone> findAllBySupporter(Connection connection, int supID, int classID) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Milestone> milestoneList = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT m.*,c.class_code from milestone m "
                    + "INNER JOIN class c on m.class_id = c.class_id WHERE 1 = 1";
            if (classID == -1 || classID == 0) {
                if (!checkAdmin(connection, supID)) {
                    sql += " and c.trainer_id = " + supID;
                }
            }
            if (classID != -1 && classID != 0) {
                sql += " and c.class_id = " + classID;
            }
            // Search and Paging
            Object[] params = {};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);

                while (resultSet.next()) {
                    Milestone milestone = new Milestone();
                    milestone.setMilestoneId(resultSet.getInt("milestone_id"));
                    milestone.setAssId(resultSet.getInt("ass_id"));
                    milestone.setClassId(resultSet.getInt("class_id"));
                    milestone.setClassCode(resultSet.getString("class_code"));
                    milestone.setFromDate(resultSet.getDate("from_date"));
                    milestone.setToDate(resultSet.getDate("to_date"));
                    milestone.setTitle(resultSet.getString("title"));
                    milestone.setAssBody(resultSet.getString("ass_body"));
                    milestone.setDescription(resultSet.getString("description"));
                    milestone.setStatusId(resultSet.getInt("status_id"));
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

    public boolean checkAdmin(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Role role = new Role();
        if (connection != null) {
            String sql = "SELECT s.setting_id,s.setting_title FROM `user_role` u inner JOIN setting s on u.setting_id = s.setting_id  where u.user_id = ?";
            Object[] params = {id};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    role.setId(resultSet.getInt("setting_id"));
                    role.setTitle(resultSet.getString("setting_title"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }

        }
        return role.getId() == 21;
    }

    @Override
    public java.util.List<Milestone> findByClassId(Connection connection, int classroomId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Milestone> milestoneList = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT * FROM milestone WHERE class_id = ?;";
            Object[] params = {classroomId};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    Milestone milestone = new Milestone();
                    milestone.setMilestoneId(resultSet.getInt("milestone_id"));
                    milestone.setAssId(resultSet.getInt("ass_id"));
                    milestone.setClassId(resultSet.getInt("class_id"));
                    milestone.setFromDate(resultSet.getDate("from_date"));
                    milestone.setToDate(resultSet.getDate("to_date"));
                    milestone.setTitle(resultSet.getString("title"));
                    milestone.setAssBody(resultSet.getString("ass_body"));
                    milestone.setDescription(resultSet.getString("description"));
                    milestone.setStatusId(resultSet.getInt("status_id"));
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
}
