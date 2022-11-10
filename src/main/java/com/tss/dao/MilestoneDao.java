/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.tss.model.Assignment;
import com.tss.model.Milestone;

/**
 *
 * @author ADMIN
 */
public interface MilestoneDao {
        List<Milestone> List(Connection connection, String title, int currentPageNo, int PageSize) throws SQLException;

        int count(Connection connection) throws SQLException;

        int countAll(Connection connection, String search) throws SQLException;

        int add(Connection connection, Milestone milestone) throws SQLException;

        Milestone findById(Connection connection, int mileStoneId) throws SQLException;

        void update(Connection connection, int mileStoneId, int classId, Date fromDate, Date toDate, String title,
                        String assBody, String description, int statusId)
                        throws SQLException;

        void updateAssId(Connection connection, int assId, int subjectId)
                        throws SQLException;

        List<Assignment> findAll(Connection connection, int start, int length)
                        throws SQLException;

        List<Milestone> findAllBySupporter(Connection connection, int supID,int classID)
                        throws SQLException;

        java.util.List<Milestone> findByClassId(Connection connection, int classroomId)
                        throws SQLException;
}
