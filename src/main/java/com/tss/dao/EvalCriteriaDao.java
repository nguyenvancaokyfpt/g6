package com.tss.dao;

import com.tss.model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EvalCriteriaDao {


    EvalCriteria findById(Connection connection, int Id) throws SQLException;

    int add(Connection connection, Object prams[]) throws SQLException;

    int del(Connection connection, int id) throws SQLException;

    int modify(Connection connection, int id, EvalCriteria eval) throws SQLException;

    int count(Connection connection) throws SQLException;

    List<EvalCriteria> findAll(Connection connection, int start, int length, String search) throws SQLException;

    int countAll(Connection connection) throws SQLException;

    List<EvalCriteria> findAll(Connection connection, int start, int length, String search, String columnName,
            String orderDir, String subjectFilter, String assignFilter, String statusFilter) throws SQLException;

    int countAll(Connection connection, String search, String subjectFilter, String assignFilter, String statusFilter) throws SQLException;

    int getNewId(Connection connection) throws SQLException;
}
