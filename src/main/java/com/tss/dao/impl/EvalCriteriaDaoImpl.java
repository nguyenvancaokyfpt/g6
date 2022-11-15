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
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.EvalCriteriaDao;
import com.tss.model.EvalCriteria;
import com.tss.model.system.Role;

/**
 *
 * @author Dat Lai
 */
public class EvalCriteriaDaoImpl implements EvalCriteriaDao {

    @Override
    public EvalCriteria findById(Connection connection, int Id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        EvalCriteria eval = null;
        if (connection != null) {
            String sql = "SELECT * FROM `eval_criteria` WHERE criteria_id = ?";
            Object[] params = { Id };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    eval = new EvalCriteria();
                    eval.setId(resultSet.getInt("criteria_id"));
                    eval.setAssign(resultSet.getInt("ass_id"));
                    eval.setMile(resultSet.getInt("milestone_id"));
                    eval.setName(resultSet.getString("criteria_name"));
                    eval.setIsTeam(resultSet.getInt("is_team_eval"));
                    eval.setWeight(resultSet.getInt("eval_weight"));
                    eval.setMaxLoc(resultSet.getInt("max_loc"));
                    eval.setStatus(resultSet.getInt("status_id"));
                    eval.setDescription(resultSet.getString("description"));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return eval;
    }

    @Override
    public int add(Connection connection, Object params[]) throws SQLException {
        PreparedStatement preparedStatement = null;
        int count = 0;
        if (connection != null) {
            String sql = "INSERT INTO `eval_criteria` (`criteria_id`, `ass_id`, `milestone_id`, `criteria_name`, `is_team_eval`, `eval_weight`, `max_loc`, `status_id`, `description`)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            count = BaseDao.execute(connection, preparedStatement, sql, params);
        }
        return count;
    }

    @Override
    public int del(Connection connection, int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int modify(Connection connection, int id, EvalCriteria eval) throws SQLException {
        PreparedStatement preparedStatement = null;
        int count = 0;
        if (connection != null) {
            String sql = "UPDATE `eval_criteria` SET "
                    + "`ass_id` = ?, "
                    + "`criteria_name` = ?, "
                    + "`is_team_eval` = ?, "
                    + "`eval_weight` = ?, "
                    + "`max_loc` = ?, "
                    + "`description` = ?, "
                    + "`status_id` = ? "
                    + "WHERE `eval_criteria`.`criteria_id` = ?;";
            Object[] params = { eval.getAssign(), eval.getName(), eval.getIsTeam(), eval.getWeight(),
                    eval.getMaxLoc(), eval.getDescription(), eval.getStatus(), id };
            count = BaseDao.execute(connection, preparedStatement, sql, params);
        }
        return count;
    }

    @Override
    public int count(Connection connection) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<EvalCriteria> findAll(Connection connection, int start, int length, String search) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<EvalCriteria> evalList = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT * FROM eval_criteria WHERE criteria_name LIKE ? OR description LIKE ? ORDER BY criteria_id ASC LIMIT ?, ?";
            Object[] params = { "%" + search + "%", "%" + search + "%", start, length };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    EvalCriteria eval = new EvalCriteria();
                    //
                    eval.setId(resultSet.getInt("criteria_id"));
                    eval.setDescription(resultSet.getString("description"));
                    eval.setIsTeam(resultSet.getInt("is_team_eval"));
                    eval.setMaxLoc(resultSet.getInt("max_loc"));
                    eval.setName(resultSet.getString("criteria_name"));
                    eval.setStatus(resultSet.getInt("status_id"));
                    eval.setWeight(resultSet.getInt("eval_weight"));

                    evalList.add(eval);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return evalList;
    }

    @Override
    public int countAll(Connection connection, int userId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(1) AS count FROM `eval_criteria` e inner join assignment a on e.ass_id = a.ass_id inner join subject s on s.subject_id = a.subject_id WHERE 1=1";
            if (!checkAdmin(connection, userId)) {
                sql += " AND s.manager_id = " + userId;
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
    public List<EvalCriteria> findAll(Connection connection, int start, int length, String search,
            String columnName, String orderDir, int subjectFilter, int assignFilter, int statusFilter, int userId)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<EvalCriteria> evalList = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT e.*,a.title,s.subject_name FROM `eval_criteria` e inner join assignment a on e.ass_id = a.ass_id inner join subject s on s.subject_id = a.subject_id";
            sql += " WHERE e.criteria_name LIKE ? ";
            if (!checkAdmin(connection, userId)) {
                sql += " AND s.manager_id = " + userId;
            }
            if (subjectFilter != -1) {
                sql += " AND s.subject_id = " + subjectFilter;
            }
            if (assignFilter != -1) {
                sql += " AND a.ass_id = " + assignFilter;
            }
            if (statusFilter != -1) {
                sql += " AND e.status_id = " + statusFilter;
            }

            sql += " ORDER BY " + columnName + " " + orderDir + " LIMIT ?, ?";
            Object[] params = { "%" + search + "%", start, length };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    EvalCriteria eval = new EvalCriteria();

                    eval.setId(resultSet.getInt("criteria_id"));
                    eval.setDescription(resultSet.getString("description"));
                    eval.setIsTeam(resultSet.getInt("is_team_eval"));
                    eval.setMaxLoc(resultSet.getInt("max_loc"));
                    eval.setName(resultSet.getString("criteria_name"));
                    eval.setStatus(resultSet.getInt("status_id"));
                    eval.setWeight(resultSet.getInt("eval_weight"));
                    eval.setAssignName(resultSet.getString("a.title"));
                    eval.setSubjectName(resultSet.getString("s.subject_name"));
                    evalList.add(eval);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return evalList;
    }

    @Override
    public int countAll(Connection connection, String search, int subjectFilter, int assignFilter, int statusFilter,
            int userId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(1) AS count FROM `eval_criteria` e inner join assignment a on e.ass_id = a.ass_id inner join subject s on s.subject_id = a.subject_id";
            sql += " WHERE e.criteria_name LIKE ? ";
            if (!checkAdmin(connection, userId)) {
                sql += " AND s.manager_id = " + userId;
            }
            if (subjectFilter != -1) {
                sql += " AND s.subject_id = " + subjectFilter;
            }
            if (assignFilter != -1) {
                sql += " AND a.ass_id = " + assignFilter;
            }
            if (statusFilter != -1) {
                sql += " AND e.status_id = " + statusFilter;
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
    public int getNewId(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT * FROM `eval_criteria` ORDER BY criteria_id DESC LIMIT 1;";
            Object[] params = {};

            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    count = resultSet.getInt("criteria_id") + 1;
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
        EvalCriteriaDaoImpl test = new EvalCriteriaDaoImpl();
        Connection connection = BaseDao.getConnection();
        // test find all with params
        // List<EvalCriteria> evalList = test.findAll(connection, 0, 10, "",
        // "criteria_id", "ASC", -1, -1, -1, 70);
        System.out.println(test.countAll(connection, "", -1, -1, -1, 70));

    }

    @Override
    public int changeStatus(Connection connection, int id, int status) throws SQLException {
        PreparedStatement preparedStatement = null;
        int count = 0;
        if (connection != null) {
            String sql = "UPDATE `eval_criteria` SET "
                    + "`status_id` = ? "
                    + "WHERE `eval_criteria`.`criteria_id` = ?;";
            Object[] params = { status, id };
            count = BaseDao.execute(connection, preparedStatement, sql, params);
        }
        return count;
    }

    @Override
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
}
