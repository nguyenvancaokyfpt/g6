/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tss.dao;

import com.tss.model.Team;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Dat Lai
 */
public interface TeamDao {

    List<Team> FindByClassID(Connection connection, int classID);
    
}
