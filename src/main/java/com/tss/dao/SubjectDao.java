package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.model.Subject;

public interface SubjectDao {

        List<Subject> List(Connection connection, int currentPageNo, int PageSize)
                        throws SQLException;

        int add(Connection connection, Subject subject) throws SQLException;

        int changeStatus(Connection connection, int subjectId) throws SQLException;

        int update(Connection connection, Subject subject) throws SQLException;

        Subject findById(Connection connection, int subjectId) throws SQLException;

        List<Subject> findAll(Connection connection, int start, int length, String search) throws SQLException;

        List<Subject> list(Connection connection, int start, int length,
                        String search, String managerFilter, String expertFilter,
                        String statusFilter) throws SQLException;

        List<Subject> findAllOfManager(Connection connection, int managerId) throws SQLException;
        List<Subject> subjectByManager(Connection connection, int managerId) throws SQLException;

        int countAll(Connection connection) throws SQLException;

        int countAll(Connection connection, String search, String managerFilter,
                        String expertFilter, String statusFilter) throws SQLException;

}
