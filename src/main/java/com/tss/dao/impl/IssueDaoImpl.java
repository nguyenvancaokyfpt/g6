/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.dao.impl;

import com.tss.dao.BaseDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.dao.IssueDao;
import com.tss.model.Issue;
import com.tss.model.Milestone;
import com.tss.model.Status;
import com.tss.model.Team;
import com.tss.model.Trainee;
import com.tss.model.system.Role;

/**
 *
 * @author Dat Lai
 */
public class IssueDaoImpl implements IssueDao {

    @Override
    public List<Issue> findAll(Connection connection, int start, int length, String search, String columnName,
            String orderDir, int classFilter, int teamFilter, int assignFilter, int statusFilter, int supId,
            int mileFilter)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Issue> issues = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT i.*,u.full_name,m.milestone_id,m.title as mile_title,s.status_title,t.project_code "
                    + "FROM `issue` i inner join team t on i.team_id = t.team_id "
                    + "inner join class c on c.class_id = t.class_id "
                    + "inner join user u on u.user_id = i.author_id "
                    + "INNER JOIN milestone m on m.milestone_id = t.milestone_id "
                    + "inner join status s on i.status_id = s.status_id "
                    + "where i.title LIKE ? ";
            if (classFilter == -1 || classFilter == 0) {
                if (!checkAdmin(connection, supId)) {
                    sql += " and c.trainer_id = " + supId;
                }
            }
            if (classFilter != -1 && classFilter != 0) {
                sql += " and c.class_id =  " + classFilter;
            }
            if (mileFilter != -1) {
                sql += " and m.milestone_id =  " + mileFilter;
            }
            if (teamFilter != -1) {
                sql += " and t.team_id =  " + teamFilter;
            }
            if (assignFilter != -1) {
                sql += " and i.author_id =  " + assignFilter;
            }
            if (statusFilter != -1) {
                sql += " and i.status_id =  " + statusFilter;
            }
            sql += " order BY " + columnName + " " + orderDir + " limit ?,?";

            Object[] params = { "%" + search + "%", start, length };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    Issue is = new Issue();
                    is.setIssueId(resultSet.getInt("issue_id"));
                    Team t = new Team();
                    t.setId(resultSet.getInt("team_id"));
                    t.setProject_code(resultSet.getString("project_code"));
                    is.setTeam(t);
                    Trainee assign = new Trainee();
                    assign.setUserId(resultSet.getInt("author_id"));
                    assign.setFullname(resultSet.getString("full_name"));
                    is.setAssignee(assign);
                    is.setTitle(resultSet.getString("title"));
                    is.setType(resultSet.getInt("type_id"));
                    Status s = new Status();
                    s.setStatusId(resultSet.getInt("status_id"));
                    s.setTitle(resultSet.getString("status_title"));
                    is.setStatus(s);
                    is.setExtra_labels(resultSet.getString("extra_labels"));
                    is.setDecription(resultSet.getString("description"));
                    is.setLink_id(resultSet.getInt("linked_id"));
                    is.setGitlab_url(resultSet.getString("gitlab_url"));
                    Milestone mile = new Milestone();
                    mile.setMilestoneId(resultSet.getInt("milestone_id"));
                    mile.setTitle(resultSet.getString("mile_title"));
                    is.setMilestone(mile);
                    is.setIsClose(resultSet.getInt("is_closed"));
                    issues.add(is);
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return issues;
    }

    public boolean checkAdmin(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Role role = new Role();
        if (connection != null) {
            String sql = "SELECT s.setting_id,s.setting_title FROM `user_role` u inner JOIN setting s on u.setting_id = s.setting_id  where u.user_id = ?";
            Object[] params = { id };
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

    public static void main(String[] args) throws SQLException {
        IssueDaoImpl issueDaoImpl = new IssueDaoImpl();
        // test find all
        List<Issue> issues = issueDaoImpl.findAll(BaseDao.getConnection(), 0, 10, "", "issue_id", "asc", -1, -1, -1, -1,
                2, -1);
        System.out.println(issues.size());
    }

    @Override
    public int countAll(Connection connection, int classFilter, int teamFilter) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(1) AS count "
                    + "FROM `issue` i inner join team t on i.team_id = t.team_id "
                    + "inner join class c on c.class_id = t.class_id "
                    + "inner join user u on u.user_id = i.author_id "
                    + "INNER JOIN milestone m on m.milestone_id = t.milestone_id "
                    + "inner join status s on i.status_id = s.status_id";
            if (classFilter == -1 || classFilter == 0) {
                if (!checkAdmin(connection, teamFilter)) {
                    sql += " and c.trainer_id = " + teamFilter;
                }
            }
            if (classFilter != -1 && classFilter != 0) {
                sql += " and c.class_id =  " + classFilter;
            }
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
    public int countFilter(Connection connection, String search, int classFilter, int teamFilter, int assignFilter,
            int statusFilter, int supId, int mileFilter) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(1) AS count "
                    + "FROM `issue` i inner join team t on i.team_id = t.team_id "
                    + "inner join class c on c.class_id = t.class_id "
                    + "inner join user u on u.user_id = i.author_id "
                    + "INNER JOIN milestone m on m.milestone_id = t.milestone_id "
                    + "inner join status s on i.status_id = s.status_id"
                    + " where i.title LIKE ? ";
            if (classFilter == -1 || classFilter == 0) {
                if (!checkAdmin(connection, supId)) {
                    sql += " and c.trainer_id = " + supId;
                }
            }
            if (classFilter != -1 && classFilter != 0) {
                sql += " and m.class_id =  " + classFilter;
            }
            if (mileFilter != -1) {
                sql += " and m.milestone_id =  " + mileFilter;
            }
            if (teamFilter != -1) {
                sql += " and t.team_id =  " + teamFilter;
            }
            if (assignFilter != -1) {
                sql += " and i.author_id =  " + assignFilter;
            }
            if (statusFilter != -1) {
                sql += " and i.status_id =  " + statusFilter;
            }
            Object[] params = { "%" + search + "%" };
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
    public int addIssue(Connection connection, Issue issue) throws SQLException {
        issue.setIssueId(getNewId(connection));
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "INSERT INTO `issue`(`issue_id`,`team_id`, `author_id`, `title`, `type_id`, `status_id`, `extra_labels`, `description`, `linked_id`, `gitlab_url`, `is_closed`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            Object[] params = { issue.getIssueId(), issue.getTeam().getId(), issue.getAssignee().getUserId(),
                    issue.getTitle(),
                    issue.getType(), issue.getStatus().getStatusId(), issue.getExtra_labels(), issue.getDecription(),
                    issue.getLink_id(), issue.getGitlab_url(), issue.getIsClose() };
            try {
                count = BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return count;
    }

    @Override
    public int getNewId(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int id = 0;
        if (connection != null) {
            String sql = "SELECT MAX(issue_id) AS id FROM `issue`";
            Object[] params = {};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    id = resultSet.getInt("id");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return id + 1;
    }

}
