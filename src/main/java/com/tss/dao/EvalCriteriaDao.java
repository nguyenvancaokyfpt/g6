package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.model.EvalCriteria;
import com.tss.model.User;

public interface EvalCriteriaDao {

    EvalCriteria findById(Connection connection, int Id) throws SQLException;

    int add(Connection connection, Object prams[]) throws SQLException;

    int del(Connection connection, int id) throws SQLException;

    int modify(Connection connection, int id, EvalCriteria eval) throws SQLException;

    int count(Connection connection) throws SQLException;

    List<EvalCriteria> findAll(Connection connection, int start, int length, String search) throws SQLException;

    int countAll(Connection connection,int userId) throws SQLException;

    List<EvalCriteria> findAll(Connection connection, int start, int length, String search, String columnName,
            String orderDir, int subjectFilter, int assignFilter, int statusFilter,int userId) throws SQLException;

    int countAll(Connection connection, String search, int subjectFilter, int assignFilter, int statusFilter,int userId)
            throws SQLException;

    int getNewId(Connection connection) throws SQLException;

    int changeStatus(Connection connection, int id, int status) throws SQLException;

    boolean checkAdmin(Connection connection, int id) throws SQLException;
}
