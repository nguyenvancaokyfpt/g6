/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.model.Team;
import com.tss.model.Trainee;

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

    int ChangeTeam2(Connection connection, int traineeId, int classId, int teamId) throws SQLException;

    int GetMaxTeamId(Connection connection) throws SQLException;

    int AddTeam(Connection connection, Team team) throws SQLException;

    void resetTeam(Connection connection, int classId);

    void setNullTeamId(Connection connection, int teamId);

    int RemoveFromTeam(Connection connection, int traineeId, int classId, int teamId) throws SQLException;

    int SetLeader(Connection connection, int traineeId, int classId, int teamId) throws SQLException;

    void DeleteTeam(Connection connection, int teamId) throws SQLException;

    List<Team> FindByClassUser(Connection connection, int classId) throws SQLException;

    void removeTeamMilestone(Connection connection, int classId, int milestoneId) throws SQLException;

    void insertTeamMember(Connection connection, int teamId, int traineeId, int isIsLeader, int status)
            throws SQLException;

    void setTeamMilestone(Connection connection, int classId, int milestoneId, Integer teamId) throws SQLException;

    List<Integer> getTeamIdByClassIdAndMilestoneId(Connection connection, int classId, int milestoneId)
            throws SQLException;

    List<Trainee> getTraineeByTeamId(Connection connection, Integer teamId) throws SQLException;

    int cloneTeam(Connection connection, Integer id, int newTeamId) throws SQLException;

    void cloneTeamMember(Connection connection, Integer oldTeamId, Integer newTeamId) throws SQLException;

    boolean checkClassTeamMilestone(Connection connection, int classId, int newMilestoneId) throws SQLException;

    void resetTeam(Connection connection, int classId, int milestoneId) throws SQLException;

}
