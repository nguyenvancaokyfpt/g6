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

/**
 *
 * @author Dat Lai
 */
public class IssueDaoImpl implements IssueDao {

    @Override
    public List<Issue> findAll(Connection connection, int start, int length, String search, String columnName,
            String orderDir, int classFilter, int teamFilter, int assignFilter, int statusFilter)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Issue> issues = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT i.*,u.full_name,m.milestone_id,m.title as mile_title,s.status_title "
                    + "FROM `issue` i inner join team t on i.team_id = t.team_id "
                    + "inner join class c on c.class_id = t.class_id "
                    + "inner join user u on u.user_id = i.author_id "
                    + "INNER JOIN milestone m on m.class_id = c.class_id "
                    + "inner join status s on i.status_id = s.status_id"
                    + " where i.title LIKE ? ";
            if (classFilter != -1) {
                sql += " and c.class_id =  " + classFilter;
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

    public static void main(String[] args) throws SQLException {
        IssueDaoImpl issueDaoImpl = new IssueDaoImpl();
        // List<Issue> issues = issueDaoImpl.findAll(BaseDao.getConnection(), 0, 10, "", "issue_id", "asc", -1, -1, -1, -1);
        // int count = issueDaoImpl.countFilter(BaseDao.getConnection(), "", -1, -1, -1, -1);
        // int count2 = issueDaoImpl.countAll(BaseDao.getConnection(), -1, -1);
        System.out.println(issueDaoImpl.getNewId(BaseDao.getConnection()));
        Issue issue = new Issue();
        issue.setIssueId(1);
        Trainee t = new Trainee();
        t.setUserId(57);
        issue.setAssignee(t);
        issue.setDecription("test");
        issue.setExtra_labels("test");
        issue.setGitlab_url("test");
        issue.setIsClose(1);
        issue.setLink_id(1);
        Status s = new Status();
        s.setStatusId(3);
        issue.setStatus(s);
        Team tt = new Team();
        tt.setId(1);
        issue.setTeam(tt);
        issue.setTitle("test");
        issue.setType(1);
        issueDaoImpl.addIssue(BaseDao.getConnection(), issue);
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
                    + "INNER JOIN milestone m on m.class_id = c.class_id "
                    + "inner join status s on i.status_id = s.status_id";
                    if (classFilter != -1) {
                        sql += " and c.class_id =  " + classFilter;
                    }
                    if (teamFilter != -1) {
                        sql += " and t.team_id =  " + teamFilter;
                    }
            Object[] params = { };
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
            int statusFilter) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(1) AS count "
                    + "FROM `issue` i inner join team t on i.team_id = t.team_id "
                    + "inner join class c on c.class_id = t.class_id "
                    + "inner join user u on u.user_id = i.author_id "
                    + "INNER JOIN milestone m on m.class_id = c.class_id "
                    + "inner join status s on i.status_id = s.status_id"
                    + " where i.title LIKE ? ";
                    if (classFilter != -1) {
                        sql += " and c.class_id =  " + classFilter;
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
            Object[] params = { "%" + search + "%"};
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
            Object[] params = { issue.getIssueId(),issue.getTeam().getId(), issue.getAssignee().getUserId(), issue.getTitle(),
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
            Object[] params = { };
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
