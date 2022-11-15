/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.TeamDao;
import com.tss.dao.impl.TeamDaoImpl;
import com.tss.helper.DebugHelper;
import com.tss.model.Team;
import com.tss.model.Trainee;
import com.tss.model.User;
import com.tss.service.TeamService;
import com.tss.service.UserService;

/**
 *
 * @author Dat Lai
 */
public class TeamServiceImpl implements TeamService {

    private TeamDao teamDao;
    private UserService userService;

    public TeamServiceImpl() {
        teamDao = new TeamDaoImpl();
        userService = new UserServiceImpl();
    }

    @Override
    public List<Team> FindByClassID(int classID, int milestone_id) {
        Connection connection = null;
        List<Team> teams = null;
        try {
            connection = BaseDao.getConnection();
            teams = teamDao.FindByClassID(connection, classID, milestone_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return teams;
    }

    @Override
    public boolean changeStatus(int id, int status) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            flag = teamDao.changeStatus(connection, id, status) == 1;
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public boolean RemoveTeam(int teamId) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            flag = teamDao.RemoveTeam(connection, teamId) == 1;
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public Team FindTeamById(int teamId, int class_id) {
        Connection connection = null;
        Team team = null;
        try {
            connection = BaseDao.getConnection();
            team = teamDao.FindTeamById(connection, teamId, class_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return team;
    }

    @Override
    public boolean UpdateTeam(Team team) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            flag = teamDao.UpdateTeam(connection, team) == 1;
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public boolean ChangeTeam(int traineeId, int classId, int teamId) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            flag = teamDao.ChangeTeam(connection, traineeId, classId, teamId) == 1;
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public boolean ChangeTeam2(int traineeId, int classId, int teamId) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            flag = teamDao.ChangeTeam2(connection, traineeId, classId, teamId) == 1;
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public int GetNewTeamId() {
        Connection connection = null;
        int teamId = 0;
        try {
            connection = BaseDao.getConnection();
            teamId = teamDao.GetMaxTeamId(connection) + 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return teamId;
    }

    @Override
    public boolean AddTeam(Team team) {
        team.setId(GetNewTeamId());
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            flag = teamDao.AddTeam(connection, team) == 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public void resetTeam(int classId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            teamDao.resetTeam(connection, classId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
    }

    @Override
    public List<Integer> importTeam(List<Team> listTeam) {
        List<Integer> listId = new java.util.ArrayList<>();
        Connection connection = null;
        for (Team team : listTeam) {
            team.setId(GetNewTeamId());
            listId.add(team.getId());
            team.setStatus_id(1);
            try {
                connection = BaseDao.getConnection();
                teamDao.AddTeam(connection, team);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(connection, null, null);
            }
        }
        return listId;
    }

    @Override
    public List<Integer> importStudent(HashMap<Integer, List<Trainee>> traineeTeamMap, List<Integer> listTeamId) {
        List<Integer> listId = new java.util.ArrayList<>();
        for (Integer key : traineeTeamMap.keySet()) {
            int teamId = listTeamId.get(key - 1);
            List<Trainee> traineeList = traineeTeamMap.get(key);
            boolean setLeader = false;
            for (Trainee trainee : traineeList) {
                User user = userService.findByEmail(trainee.getEmail());
                if (user != null) {
                    listId.add(user.getUserId());
                    ChangeTeam(user.getUserId(), trainee.getClassId(), teamId);
                    if ((trainee.isIsLeader() && !setLeader)
                            || (trainee == traineeList.get(traineeList.size() - 1) && !setLeader)) {
                        SetLeader(user.getUserId(), trainee.getClassId(), teamId);
                        setLeader = true;
                    }
                }
            }
        }
        return listId;
    }

    @Override
    public void removeStudentLinkToTeam(int classId) {
        // List<Team> teamList = FindByClassID(classId);
        // List<Team> teamList2 = FindByClassUser(classId);
        // for (Team team : teamList) {
        // setNullTeamId(team.getId());
        // }
        // DebugHelper.print(teamList2);
        // for (Team team : teamList2) {
        // DeleteTeam(team.getId());
        // }
    }

    @Override
    public void setNullTeamId(int teamId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            teamDao.setNullTeamId(connection, teamId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
    }

    public boolean RemoveFromTeam(int traineeId, int teamId) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            flag = teamDao.RemoveFromTeam(connection, traineeId, teamId) == 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public boolean SetLeader(int traineeId, int classId, int teamId) {

        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            flag = teamDao.SetLeader(connection, traineeId, classId, teamId) == 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public void DeleteTeam(int teamId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            teamDao.DeleteTeam(connection, teamId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
    }

    @Override
    public List<Team> FindByClassUser(int classId) {
        Connection connection = null;
        List<Team> teamList = null;
        try {
            connection = BaseDao.getConnection();
            teamList = teamDao.FindByClassUser(connection, classId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return teamList;
    }

    @Override
    public void removeTeamMilestone(int classId, int milestoneId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            teamDao.removeTeamMilestone(connection, classId, milestoneId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
    }

    @Override
    public List<Integer> importTeamMembers(HashMap<Integer, List<Trainee>> traineeTeamMap, List<Integer> listTeamId) {
        List<Integer> listId = new java.util.ArrayList<>();
        for (Integer key : traineeTeamMap.keySet()) {
            int teamId = listTeamId.get(key - 1);
            List<Trainee> traineeList = traineeTeamMap.get(key);
            Boolean setLeader = false;
            for (Trainee trainee : traineeList) {
                User user = userService.findByEmail(trainee.getEmail());
                if (user != null) {
                    listId.add(user.getUserId());
                    if ((trainee.isIsLeader() && !setLeader)
                            || (trainee == traineeList.get(traineeList.size() - 1) && !setLeader)) {
                        insertTeamMember(teamId, user.getUserId(), 1, 1);
                        setLeader = true;
                    } else {
                        insertTeamMember(teamId, user.getUserId(), 0, 1);
                    }
                }
            }
        }
        return listId;
    }

    @Override
    public void insertTeamMember(int teamId, int traineeId, int isIsLeader, int status) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            teamDao.insertTeamMember(connection, teamId, traineeId, isIsLeader, status);
        } catch (SQLException e) {
            DebugHelper.print(e);
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
    }

    @Override
    public void setTeamMilestone(int classId, int milestoneId, List<Integer> listTeamId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            for (Integer teamId : listTeamId) {
                teamDao.setTeamMilestone(connection, classId, milestoneId, teamId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
    }

    @Override
    public List<Integer> getTeamIdByClassIdAndMilestoneId(int classId, int milestoneId) {
        Connection connection = null;
        List<Integer> listTeamId = null;
        try {
            connection = BaseDao.getConnection();
            listTeamId = teamDao.getTeamIdByClassIdAndMilestoneId(connection, classId, milestoneId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return listTeamId;
    }

    @Override
    public List<Trainee> getTraineeByTeamId(Integer teamId) {
        Connection connection = null;
        List<Trainee> traineeList = null;
        try {
            connection = BaseDao.getConnection();
            traineeList = teamDao.getTraineeByTeamId(connection, teamId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return traineeList;
    }

    @Override
    public int cloneTeam(Integer id) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            int newTeamId = GetNewTeamId();
            teamDao.cloneTeam(connection, id, newTeamId);
            return newTeamId;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return 0;
    }

    @Override
    public void cloneTeamMember(List<Integer> listTeamId, List<Integer> listNewTeamId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            for (int i = 0; i < listTeamId.size(); i++) {
                teamDao.cloneTeamMember(connection, listTeamId.get(i), listNewTeamId.get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
    }

    @Override
    public boolean checkClassTeamMilestone(int classId, int newMilestoneId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            return teamDao.checkClassTeamMilestone(connection, classId, newMilestoneId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return false;
    }

    @Override
    public void resetTeam(int classId, int milestoneId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            teamDao.resetTeam(connection, classId, milestoneId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
    }

    @Override
    public List<Trainee> GetWaitingList(int classID, int milestone_id) {
        Connection connection = null;
        List<Trainee> traineeList = null;
        try {
            connection = BaseDao.getConnection();
            traineeList = teamDao.GetWaitingList(connection, classID, milestone_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return traineeList;
    }

    @Override
    public int AddToTeam(int traineeId, int teamId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            return teamDao.AddToTeam(connection, traineeId, teamId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return 0;
    }

    @Override
    public boolean RemoveAllMember(int teamId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            return teamDao.RemoveAllMember(connection, teamId) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return false;
    }
}
