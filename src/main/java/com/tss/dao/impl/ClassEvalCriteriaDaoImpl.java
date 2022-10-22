/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.dao.impl;

import com.tss.dao.BaseDao;
import com.tss.dao.ClassEvalCriteriaDao;
import com.tss.model.ClassEvalCriteria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class ClassEvalCriteriaDaoImpl implements ClassEvalCriteriaDao{

    @Override
    public List<ClassEvalCriteria> findAll(Connection connection, int start, int length, String search) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ClassEvalCriteria> evalList = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT \n" +
"    e.criteria_id AS id,e.ass_id as assId , e.criteria_name as criteriaName,e.milestone_id as mileStoneId,\n" +
"    a.title AS assName,\n" +
"    c.class_code AS class,\n" +
"    e.is_team_eval AS isTeamEval,\n" +
"    e.eval_weight AS weight,\n" +
"    e.max_loc AS maxLoc,\n" +
"    e.status_id AS status,\n" +
"    e.description AS description\n" +
"FROM\n" +
"    eval_criteria AS e\n" +
"        LEFT JOIN\n" +
"    milestone AS m ON e.milestone_id = m.milestone_id\n" +
"        LEFT JOIN\n" +
"    class AS c ON m.class_id = c.class_id\n" +
"        LEFT JOIN\n" +
"    assignment AS a ON e.ass_id = a.ass_id\n" +
"WHERE\n" +
"    criteria_name LIKE ?\n" +
"        OR c.class_code LIKE ?\n" +
"ORDER BY criteria_id ASC\n" +
"LIMIT ? , ?";
            Object[] params = {"%" + search + "%", "%" + search + "%", start, length};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    ClassEvalCriteria eval = new ClassEvalCriteria();
//                 
                    eval.setId(resultSet.getInt("id"));
                    eval.setAssign(resultSet.getInt("assId"));
                    eval.setMile(resultSet.getInt("mileStoneId"));
                    eval.setName(resultSet.getString("criteriaName"));
                    eval.setIsTeam(resultSet.getInt("isTeamEval"));
                    eval.setWeight(resultSet.getInt("weight"));
                    eval.setMaxLoc(resultSet.getInt("maxLoc"));
                    eval.setStatus(resultSet.getInt("status"));
                    eval.setDescription(resultSet.getString("description"));
                    eval.setAssignName(resultSet.getString("assName"));
                    eval.setClassCode(resultSet.getString("class"));
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
    public int countAll(Connection connection, String search) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(1) AS count FROM\n" +
"    eval_criteria AS e\n" +
"        LEFT JOIN\n" +
"    milestone AS m ON e.milestone_id = m.milestone_id\n" +
"        LEFT JOIN\n" +
"    class AS c ON m.class_id = c.class_id\n" +
"        LEFT JOIN\n" +
"    assignment AS a ON e.ass_id = a.ass_id\n" +
"WHERE\n" +
"    criteria_name LIKE ?\n" +
"        OR c.class_code LIKE ?";
            Object[] params = { "%" + search + "%" , "%" + search + "%"};
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
        return count;}

    @Override
    public int count(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(1) AS count FROM eval_criteria";
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
        return count;}
    
}
