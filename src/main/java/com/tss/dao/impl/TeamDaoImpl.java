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
import com.tss.dao.TeamDao;
import com.tss.helper.DebugHelper;
import com.tss.model.Team;
import com.tss.model.Trainee;

/**
 *
 * @author Dat Lai
 */
public class TeamDaoImpl implements TeamDao {

    @Override
    public List<Team> FindByClassID(Connection connection, int classID, int milestone_id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Team> teams = new ArrayList<>();
        if (connection != null) {
            try {
                String sql = "SELECT t.* ,c.class_code FROM `team` t inner join class c on t.class_id = c.class_id where t.milestone_id = ?";
                Object[] params = {milestone_id };
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
                    sql = "SELECT u.*,c.class_id,tm.is_leader FROM `team` t inner join team_member tm on t.team_id = tm.team_id inner join user u on tm.user_id = u.user_id INNER JOIN class c on c.class_id = t.class_id WHERE t.team_id = ?;";
                    params = new Object[] { team.getId() };
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
                        user.setIsLeader(resultSet.getBoolean("is_leader"));
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
                // update team,leader of trainee in class_user to null
                String sql = "UPDATE `class_user` SET `team_id` = NULL,`is_leader` =0 WHERE `team_id` = ?";
                BaseDao.execute(connection, preparedStatement, sql, params);
                // update submit of trainee to null
                sql = "UPDATE `submit` SET `team_id` = NULL WHERE `team_id` = ?";
                BaseDao.execute(connection, preparedStatement, sql, params);
                // delete team_Member
                sql = "DELETE FROM `team_member` WHERE `team_id` = ?";
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
                    sql = "SELECT u.* FROM `team_member` c inner JOIN user u on c.user_id = u.user_id where c.team_id = ?";
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
    public int ChangeTeam(Connection connection, int traineeId, int oldTeam, int newTeam) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
        if (connection != null) {
            try {
                String sql = "UPDATE `team_member` SET `team_id` = ?,`is_leader` =0 WHERE `user_id` = ? and `team_Id` = ?";
                Object[] params = { newTeam, traineeId, oldTeam };
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
                String sql = "INSERT INTO `team`(`team_id`, `class_id`, `description`, `topic_code`, `topic_name`, `project_code`, `status_id`,milestone_id) VALUES (?,?,?,?,?,?,?,?)";
                Object[] params = { team.getId(), team.getClassId(), team.getDescription(), team.getTopic_code(),
                        team.getTopic_name(), team.getProject_code(), team.getStatus_id(), team.getMilestoneId() };
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
    public void resetTeam(Connection connection, int classId) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                String sql = "DELETE FROM `team` WHERE `class_id` = ?";
                Object[] params = { classId };
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
    }

    @Override
    public void setNullTeamId(Connection connection, int teamId) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                String sql = "UPDATE `class_user` SET `team_id` = NULL WHERE `team_id` = ?";
                Object[] params = { teamId };
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
    }

    @Override
    public int RemoveFromTeam(Connection connection, int traineeId, int classId, int teamId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
        if (connection != null) {
            try {
                String sql = "DELETE FROM `team_member` WHERE `user_id` = ? and `team_id` = ?";
                Object[] params = { traineeId, teamId };
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
                Object[] params = { teamId };
                String sql = "UPDATE `team_member` SET `is_leader`= 0 WHERE `team_id` = ?";
                result = BaseDao.execute(connection, preparedStatement, sql, params);
                sql = "UPDATE `team_member` SET `is_leader` = 1 WHERE `user_id` = ? and `team_id` = ?";
                params = new Object[] { traineeId, teamId };
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
    public void DeleteTeam(Connection connection, int teamId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                String sql = "DELETE FROM `team` WHERE `team_id` = ?";
                Object[] params = { teamId };
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
    }

    @Override
    public List<Team> FindByClassUser(Connection connection, int classId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Team> teamList = new ArrayList<>();
        if (connection != null) {
            try {
                String sql = "SELECT team.* FROM class_user INNER JOIN team ON class_user.team_id = team.team_id WHERE class_user.class_id = ? GROUP BY team.team_id;";
                Object[] params = { classId };
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    Team team = new Team();
                    team.setId(resultSet.getInt("team_id"));
                    team.setClassId(resultSet.getInt("class_id"));
                    team.setDescription(resultSet.getString("description"));
                    team.setTopic_code(resultSet.getString("topic_code"));
                    team.setTopic_name(resultSet.getString("topic_name"));
                    team.setProject_code(resultSet.getString("project_code"));
                    team.setStatus_id(resultSet.getInt("status_id"));
                    teamList.add(team);
                }
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return teamList;
    }

    @Override
    public void removeTeamMilestone(Connection connection, int classId, int milestoneId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                String sql = "DELETE FROM `team_milestone` WHERE `class_id` = ? and `milestone_id` = ?";
                Object[] params = { classId, milestoneId };
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
    }

    @Override
    public void insertTeamMember(Connection connection, int teamId, int traineeId, int isIsLeader, int status) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                String sql = "INSERT INTO `team_member`(`team_id`, `user_id`, `is_leader`, `is_active`) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE `is_leader` = ?, `is_active` = ?";
                Object[] params = { teamId, traineeId, isIsLeader, status, isIsLeader, status };
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
    }

    @Override
    public void setTeamMilestone(Connection connection, int classId, int milestoneId, Integer teamId)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DebugHelper.print("setTeamMilestone " + classId + " " + milestoneId + " " + teamId);
        if (connection != null) {
            try {
                String sql = "INSERT INTO `team_milestone`(`class_id`, `milestone_id`, `team_id`) VALUES (?,?,?) ON DUPLICATE KEY UPDATE `team_id` = ?";
                Object[] params = { classId, milestoneId, teamId, teamId };
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
    }

    @Override
    public List<Integer> getTeamIdByClassIdAndMilestoneId(Connection connection, int classId, int milestoneId)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> teamIdList = new ArrayList<>();
        if (connection != null) {
            try {
                String sql = "SELECT `team_id` FROM `team_milestone` WHERE `class_id` = ? and `milestone_id` = ?";
                Object[] params = { classId, milestoneId };
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    teamIdList.add(resultSet.getInt("team_id"));
                }
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return teamIdList;
    }

    @Override
    public List<Trainee> getTraineeByTeamId(Connection connection, Integer teamId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Trainee> traineeList = new ArrayList<>();
        if (connection != null) {
            try {
                String sql = "SELECT user.*, team_member.is_leader  FROM team_member INNER JOIN user ON team_member.user_id = user.user_id WHERE team_member.team_id = ?";
                Object[] params = { teamId };
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    Trainee trainee = new Trainee();
                    trainee.setUserId(resultSet.getInt("user_id"));
                    trainee.setFullname(resultSet.getString("full_name"));
                    trainee.setAvatarUrl(resultSet.getString("avatar_url"));
                    trainee.setUsername(resultSet.getString("username"));
                    trainee.setEmail(resultSet.getString("email"));
                    trainee.setMobile(resultSet.getString("mobile"));
                    trainee.setStatusId(resultSet.getInt("status_id"));
                    trainee.setIsLeader(resultSet.getBoolean("is_leader"));
                    traineeList.add(trainee);
                }
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return traineeList;
    }

    @Override
    public int cloneTeam(Connection connection, Integer id, int newTeamId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                String sql = "INSERT INTO `team`(`team_id`, `class_id`, `description`, `topic_code`, `topic_name`, `project_code`, `status_id`) SELECT ?, `class_id`, `description`, `topic_code`, `topic_name`, `project_code`, `status_id` FROM `team` WHERE `team_id` = ?";
                Object[] params = { newTeamId, id };
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return newTeamId;
    }

    @Override
    public void cloneTeamMember(Connection connection, Integer oldTeamId, Integer newTeamId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                String sql = "INSERT INTO `team_member`(`team_id`, `user_id`, `is_leader`, `is_active`) SELECT ?, `user_id`, `is_leader`, `is_active` FROM `team_member` WHERE `team_id` = ?";
                Object[] params = { newTeamId, oldTeamId };
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
    }

    @Override
    public boolean checkClassTeamMilestone(Connection connection, int classId, int newMilestoneId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isExist = false;
        if (connection != null) {
            try {
                String sql = "SELECT * FROM `team_milestone` WHERE `class_id` = ? and `milestone_id` = ?";
                Object[] params = { classId, newMilestoneId };
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    isExist = true;
                }
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return isExist;
    }

    @Override
    public void resetTeam(Connection connection, int classId, int milestoneId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                String sql = "DELETE FROM `team_milestone` WHERE `class_id` = ? and `milestone_id` = ?";
                Object[] params = { classId, milestoneId };
                BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
    }

    @Override
    public List<Trainee> GetWaitingList(Connection connection, int classID, int milestone_id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Trainee> traineeList = new ArrayList<>();
        if (connection != null) {
            try {
                String sql = "SELECT us.* FROM `class_user` cu INNER JOIN user us ON cu.user_id = us.user_id WHERE cu.class_id = ? AND cu.user_id NOT IN ( SELECT u.user_id FROM `team` t inner join team_member tm on t.team_id = tm.team_id inner join user u on tm.user_id = u.user_id INNER JOIN class c on c.class_id = t.class_id WHERE c.class_id = ? and t.milestone_id = ? )";
                Object[] params = { classID, classID, milestone_id };
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
                    traineeList.add(user);
                }
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return traineeList;
    }

    public static void main(String[] args) {
        TeamDaoImpl teamDao = new TeamDaoImpl();
        Connection connection = BaseDao.getConnection();
        try {
            System.out.println(teamDao.FindByClassID(connection, 1, 99).size());
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int AddToTeam(Connection connection, int traineeId, int teamId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
        if (connection != null) {
            try {
                String sql = "INSERT INTO `team_member`(`team_id`, `user_id`, `is_leader`, `is_active`) VALUES (?,?,?,?)";
                Object[] params = { teamId, traineeId, 0, 1 };
                result = BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return result;
    }

    @Override
    public int RemoveAllMember(Connection connection, int teamId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
        if (connection != null) {
            try {
                String sql = "DELETE FROM `team_member` WHERE `team_id` = ?";
                Object[] params = { teamId };
                result = BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return result;
    }
}
