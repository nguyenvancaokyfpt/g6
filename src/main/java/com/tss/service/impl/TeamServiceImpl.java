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
        List<Team> t = s.FindByClassID(10);
        System.out.println(t.get(0).getListTrainee().size());
    }
}
