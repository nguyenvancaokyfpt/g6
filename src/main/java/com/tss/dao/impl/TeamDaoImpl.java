/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.dao.impl;

import com.tss.dao.BaseDao;
import com.tss.dao.TeamDao;
import com.tss.model.Team;
import com.tss.model.Trainee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dat Lai
 */
public class TeamDaoImpl implements TeamDao {

    @Override
    public List<Team> FindByClassID(Connection connection, int classID) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Team> teams = new ArrayList<>();
        if (connection != null) {
            try {
                String sql = "SELECT * FROM `team` WHERE class_id = ?";
                Object[] params = { classID };
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    Team team = new Team();
                    team.setId(resultSet.getInt("team_id"));
                    team.setDescription(resultSet.getString("description"));
                    team.setProject_code(resultSet.getString("project_code"));
                    team.setStatus_id(resultSet.getInt("status_id"));
                    team.setTopic_code(resultSet.getString("topic_code"));
                    team.setTopic_name(resultSet.getString("topic_name"));
                    teams.add(team);
                }

                // find trainee
                for (Team team : teams) {
                    sql = "SELECT u.*,class_id,dropout_date FROM class_user c inner JOIN user u on c.user_id = u.user_id where c.class_id = ? and c.team_id = ?";
                    params = new Object[] { classID, team.getId() };
                    resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                    while (resultSet.next()) {
                        Trainee user = new Trainee();
                        user.setUserId(resultSet.getInt("user_id"));
                        user.setFullname(resultSet.getString("full_name"));
                        user.setEmail(resultSet.getString("email"));
                        user.setMobile(resultSet.getString("mobile") == null ? "" : resultSet.getString("mobile"));
                        user.setAvatarUrl(resultSet.getString("avatar_url"));
                        user.setStatusId(resultSet.getInt("status_id"));
                        user.setNote(resultSet.getString("note") == null ? "" : resultSet.getString("note"));
                        user.setCreatedAt(resultSet.getTimestamp("created_at"));
                        user.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                        user.setLastActive(resultSet.getTimestamp("last_active"));
                        user.setClassId(resultSet.getInt("class_id"));
                        user.setDropoutDate(resultSet.getDate("dropout_date"));
                        team.getListTrainee().add(user);
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return teams;
    }

    @Override
    public int changeStatus(Connection connection, int teamId, int statusId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
        if (connection != null) {
            try {
                String sql = "UPDATE `team` SET `status_id` = ? WHERE `team_id` = ?";
                Object[] params = { statusId, teamId };
                result = BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return result;
    }

    @Override
    public int RemoveTeam(Connection connection, int teamId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
        if (connection != null) {
            try {
                Object[] params = { teamId };
                //update team of trainee to null
                String sql = "UPDATE `class_user` SET `team_id` = NULL WHERE `team_id` = ?";
                BaseDao.execute(connection, preparedStatement, sql, params);
                //update submit of trainee to null
                sql = "UPDATE `submit` SET `team_id` = NULL WHERE `team_id` = ?";
                BaseDao.execute(connection, preparedStatement, sql, params);
                //Delete team
                sql = "DELETE FROM `team` WHERE `team_id` = ?";
                result = BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return result;
    }

    @Override
    public Team FindTeamById(Connection connection, int teamId,int class_id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Team team = null;
        if (connection != null) {
            try {
                String sql = "SELECT t.* ,c.class_code FROM `team` t inner join class c on t.class_id = c.class_id where team_id = ?";
                Object[] params = { teamId };
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    team = new Team();
                    team.setClassName(resultSet.getString("class_code"));
                    team.setId(resultSet.getInt("team_id"));
                    team.setDescription(resultSet.getString("description"));
                    team.setProject_code(resultSet.getString("project_code"));
                    team.setStatus_id(resultSet.getInt("status_id"));
                    team.setTopic_code(resultSet.getString("topic_code"));
                    String b = resultSet.getString("topic_name");
                    team.setTopic_name(resultSet.getString("topic_name"));
                }

                if (team != null) {
                    sql = "SELECT u.*,class_id,dropout_date FROM class_user c inner JOIN user u on c.user_id = u.user_id where c.team_id = ? and c.class_id = ?";
                    params = new Object[] { teamId, class_id };
                    resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                    while (resultSet.next()) {
                        Trainee user = new Trainee();
                        user.setUserId(resultSet.getInt("user_id"));
                        user.setFullname(resultSet.getString("full_name"));
                        user.setEmail(resultSet.getString("email"));
                        user.setMobile(resultSet.getString("mobile") == null ? "" : resultSet.getString("mobile"));
                        user.setAvatarUrl(resultSet.getString("avatar_url"));
                        user.setStatusId(resultSet.getInt("status_id"));
                        user.setNote(resultSet.getString("note") == null ? "" : resultSet.getString("note"));
                        user.setCreatedAt(resultSet.getTimestamp("created_at"));
                        user.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                        user.setLastActive(resultSet.getTimestamp("last_active"));
                        user.setClassId(resultSet.getInt("class_id"));
                        user.setDropoutDate(resultSet.getDate("dropout_date"));
                        team.getListTrainee().add(user);
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return team;
    }

    public static void main(String[] args) throws SQLException {
        TeamDaoImpl t = new TeamDaoImpl();
       
    }
}
