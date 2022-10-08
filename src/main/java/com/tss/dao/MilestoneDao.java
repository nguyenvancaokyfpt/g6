/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.dao;

import com.tss.model.Milestone;
import com.tss.model.MilestoneRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface MilestoneDao {
    List<Milestone> List(Connection connection, String title , int currentPageNo, int PageSize) throws SQLException;
    int count(Connection connection) throws SQLException;
    
    int add(Connection connection, MilestoneRequest milestoneRequest) throws SQLException;

    Milestone findById(Connection connection, int mileStoneId) throws SQLException;

    void update(Connection connection, int mileStoneId, int assId, int classId, Date fromDate, Date toDate , String title, String assBody , String description , int statusId )
            throws SQLException;
}
