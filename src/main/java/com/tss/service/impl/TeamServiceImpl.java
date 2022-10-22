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
public class TeamServiceImpl implements TeamService{

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
    
    public static void main(String[] args) {
        TeamServiceImpl s = new TeamServiceImpl();
        s.changeStatus(2,1);
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
}
