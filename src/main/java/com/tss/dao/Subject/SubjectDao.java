package com.tss.dao.Subject;

import com.tss.model.Subject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface SubjectDao {

    List<Subject> List(Connection connection, int currentPageNo, int PageSize)
            throws SQLException;

    int add(Connection connection, Subject subject) throws SQLException;

    int inactive(Connection connection, int subjectId) throws SQLException;

    int active(Connection connection, int subjectId) throws SQLException;

    int modify(Connection connection, Subject subject) throws SQLException;

    Subject findById(Connection connection, int subjectId) throws SQLException;

    List<Subject> findAll(Connection connection, int start, int length, String search) throws SQLException;

    int countAll(Connection connection) throws SQLException;

    int countAll(Connection connection, String search) throws SQLException;

    String getUserNameById(Connection connection, int id) throws SQLException;

    List<Integer> pages(Connection connection, int PageSize) throws SQLException;
}
