package com.tss.dao;

import com.tss.model.Assignment;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface AssignmentDao {

    List<Assignment> findAll(Connection connection, int start, int length, String search,
            String subjectFilter, String isTeamworkFilter, String isOngoingFilter,
            String statusFilter)
            throws SQLException;

    int countAll(Connection connection, String search, String subjectFilter,
            String isTeamworkFilter, String isOngoingFilter, String statusFilter)
            throws SQLException;

    int countAll(Connection connection) throws SQLException;

    int add(Connection connection, Assignment assignment) throws SQLException;

    int update(Connection connection, Assignment assignment) throws SQLException;

    int changeStatus(Connection connection, int id) throws SQLException;

    Assignment findById(Connection connection, int id) throws SQLException;
    
}
