/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.TeamDao;
import com.tss.dao.impl.TeamDaoImpl;
import com.tss.model.Team;
import com.tss.service.TeamService;

/**
 *
 * @author Dat Lai
 */
public class TeamServiceImpl implements TeamService {

    private TeamDao teamDao;

    public TeamServiceImpl() {
        teamDao = new TeamDaoImpl();
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

    public static void main(String[] args) {
        TeamServiceImpl s = new TeamServiceImpl();
        Team team = new Team();
        int a = s.GetNewTeamId();
        team.setId(s.GetNewTeamId());
        team.setClassId(10);
        team.setDescription("test");
        team.setTopic_code("test");
        team.setTopic_name("test");
        team.setProject_code("test");
        team.setStatus_id(1);

        System.out.println(s.AddTeam(team));
    }

    @Override
    public boolean RemoveFromTeam(int traineeId, int classId, int teamId) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            flag = teamDao.RemoveFromTeam(connection, traineeId, classId, teamId) == 1;
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
}
