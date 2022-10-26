/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.dao.impl;

import com.tss.dao.BaseDao;
import com.tss.dao.TeamDao;
import com.tss.model.Team;
import com.tss.model.Trainee;

import java.rmi.server.ObjID;
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
                String sql = "SELECT t.* ,c.class_code FROM `team` t inner join class c on t.class_id = c.class_id where t.class_id = ?";
                Object[] params = { classID };
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    Team team = new Team();
                    team.setClassName(resultSet.getString("class_code"));
                    team.setClassId(resultSet.getInt("class_id"));
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
                    sql = "SELECT u.*,class_id,dropout_date,is_leader FROM class_user c inner JOIN user u on c.user_id = u.user_id where c.class_id = ? and c.team_id = ?";
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
                        user.setIsLeader(resultSet.getInt("is_leader"));
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
                // update team,leader of trainee to null
                String sql = "UPDATE `class_user` SET `team_id` = NULL,`is_leader` =0 WHERE `team_id` = ?";
                BaseDao.execute(connection, preparedStatement, sql, params);
                // update submit of trainee to null
                sql = "UPDATE `submit` SET `team_id` = NULL WHERE `team_id` = ?";
                BaseDao.execute(connection, preparedStatement, sql, params);
                // Delete team
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
    public Team FindTeamById(Connection connection, int teamId, int class_id) throws SQLException {
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
                    team.setClassId(resultSet.getInt("class_id"));
                    team.setId(resultSet.getInt("team_id"));
                    team.setDescription(resultSet.getString("description"));
                    team.setProject_code(resultSet.getString("project_code"));
                    team.setStatus_id(resultSet.getInt("status_id"));
                    team.setTopic_code(resultSet.getString("topic_code"));
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

    @Override
    public int UpdateTeam(Connection connection, Team team) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
        if (connection != null) {
            try {
                String sql = "UPDATE `team` SET `description` = ?, `topic_code` = ?, `topic_name` = ?, `project_code` = ?, `status_id` = ? WHERE `team_id` = ?";
                Object[] params = { team.getDescription(), team.getTopic_code(), team.getTopic_name(),
                        team.getProject_code(), team.getStatus_id(), team.getId() };
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
    public int ChangeTeam(Connection connection, int traineeId, int classId, int teamId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
        if (connection != null) {
            try {
                String sql = "UPDATE `class_user` SET `team_id` = ?,`is_leader` =0 WHERE `user_id` = ? and `class_id` = ?";
                Object[] params = { teamId, traineeId, classId };
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
    public int ChangeTeam2(Connection connection, int traineeId, int classId, int teamId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
        if (connection != null) {
            try {
                String sql = "UPDATE `class_user` SET `team_id` = ? WHERE `user_id` = ? and `class_id` = ?";
                Object[] params = { teamId, traineeId, classId };
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
    public int GetMaxTeamId(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
        if (connection != null) {
            try {
                String sql = "SELECT MAX(team_id) FROM `team`";
                Object[] params = {};
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    result = resultSet.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return result;
    }

    @Override
    public int AddTeam(Connection connection, Team team) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
        if (connection != null) {
            try {
                String sql = "INSERT INTO `team`(`team_id`, `class_id`, `description`, `topic_code`, `topic_name`, `project_code`, `status_id`) VALUES (?,?,?,?,?,?,?)";
                Object[] params = { team.getId(), team.getClassId(), team.getDescription(), team.getTopic_code(),
                        team.getTopic_name(), team.getProject_code(), team.getStatus_id() };
                result = BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return result;
    }

    public static void main(String[] args) throws SQLException {
        TeamDaoImpl teamDao = new TeamDaoImpl();
        Connection connection = BaseDao.getConnection();
        teamDao.RemoveTeam(connection, 5);

    }

    @Override
    public int RemoveFromTeam(Connection connection, int traineeId, int classId, int teamId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
        if (connection != null) {
            try {
                String sql = "UPDATE `class_user` SET `team_id` = null ,`is_leader`= 0 WHERE `user_id` = ? and `class_id` = ? and `team_id` = ?";
                Object[] params = { traineeId, classId, teamId };
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
    public int SetLeader(Connection connection, int traineeId, int classId, int teamId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
        if (connection != null) {
            try {
                Object[] params = { classId, teamId };
                String sql = "UPDATE `class_user` SET `is_leader`= 0 WHERE  `class_id` = ? and `team_id` = ?";
                result = BaseDao.execute(connection, preparedStatement, sql, params);
                sql = "UPDATE `class_user` SET `is_leader`= 1 WHERE `user_id` = ? and `class_id` = ? and `team_id` = ?";
                params = new Object[] { traineeId, classId, teamId };
                result = BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return result;
    }
}
