/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tss.service;

import java.util.HashMap;
import java.util.List;

import com.tss.model.Team;
import com.tss.model.Trainee;

/**
 *
 * @author Dat Lai
 */
public interface TeamService {
    List<Team> FindByClassID(int classID, int milestone_id);

    List<Trainee> GetWaitingList(int classID, int milestone_id);

    boolean changeStatus(int id, int status);

    boolean RemoveTeam(int teamId);

    Team FindTeamById(int teamId, int class_id);

    boolean UpdateTeam(Team team);

    boolean ChangeTeam(int traineeId, int classId, int teamId);

    boolean ChangeTeam2(int traineeId, int classId, int teamId);

    int GetNewTeamId();

    boolean AddTeam(Team team);

    void resetTeam(int classId);

    List<Integer> importTeam(List<Team> listTeam);

    List<Integer> importStudent(HashMap<Integer, List<Trainee>> traineeTeamMap, List<Integer> listTeamId);

    void removeStudentLinkToTeam(int classId);

    void setNullTeamId(int teamId);

    boolean RemoveFromTeam(int traineeId,int teamId);

    boolean SetLeader(int traineeId, int classId, int teamId);

    void DeleteTeam(int teamId);

    List<Team> FindByClassUser(int classId);

    void removeTeamMilestone(int classId, int milestoneId);

    List<Integer> importTeamMembers(HashMap<Integer, List<Trainee>> traineeTeamMap, List<Integer> listTeamId);

    void insertTeamMember(int teamId, int traineeId, int isIsLeader, int status);

    void setTeamMilestone(int classId, int milestoneId, List<Integer> listTeamId);

    List<Integer> getTeamIdByClassIdAndMilestoneId(int classId, int milestoneId);

    List<Trainee> getTraineeByTeamId(Integer teamId);

    int cloneTeam(Integer id);

    void cloneTeamMember(List<Integer> listTeamId, List<Integer> listNewTeamId);

    boolean checkClassTeamMilestone(int classId, int newMilestoneId);

    void resetTeam(int classId, int milestoneId);

    int AddToTeam(int traineeId, int teamId) ;

    boolean RemoveAllMember(int teamId);
}
