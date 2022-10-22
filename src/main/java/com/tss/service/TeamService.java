/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tss.service;

import java.util.List;

import com.tss.model.Team;

/**
 *
 * @author Dat Lai
 */
public interface TeamService {
    List<Team> FindByClassID(int classID);
    boolean changeStatus(int id, int status);
    boolean RemoveTeam(int teamId);
}
