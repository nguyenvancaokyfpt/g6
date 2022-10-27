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
    public List<Team> FindByClassID(int classID) {
        Connection connection = null;
        List<Team> teams = null;
        try {
            connection = BaseDao.getConnection();
            teams = teamDao.FindByClassID(connection, classID);
        } catch (Exception e) {
            System.out.println("Sevice");
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
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
            for (Trainee trainee : traineeList) {
                User user = userService.findByEmail(trainee.getEmail());
                if (user != null) {
                    listId.add(user.getUserId());
                    ChangeTeam(user.getUserId(), trainee.getClassId(), teamId);
                }
            }
        }
        return listId;
    }

    @Override
    public void removeStudentLinkToTeam(int classId) {
        List<Team> teamList = FindByClassID(classId);
        for (Team team : teamList) {
            setNullTeamId(team.getId());
        }
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

}
