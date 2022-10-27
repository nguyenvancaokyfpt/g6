/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.model.Team;

/**
 *
 * @author Dat Lai
 */
public interface TeamDao {

    List<Team> FindByClassID(Connection connection, int classID);

    int changeStatus(Connection connection, int id, int status) throws SQLException;

    int RemoveTeam(Connection connection, int teamId) throws SQLException;

    Team FindTeamById(Connection connection, int teamId, int class_id) throws SQLException;

    int UpdateTeam(Connection connection, Team team) throws SQLException;

    int ChangeTeam(Connection connection, int traineeId, int classId, int teamId) throws SQLException;

    int GetMaxTeamId(Connection connection) throws SQLException;

    int AddTeam(Connection connection, Team team) throws SQLException;

    void resetTeam(Connection connection, int classId);

    void setNullTeamId(Connection connection, int teamId);

}
