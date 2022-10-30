/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.model.Issue;

/**
 *
 * @author Dat Lai
 */
public interface IssueDao {
    List<Issue> findAll(Connection connection, int start, int length, String search, String columnName,
    String orderDir, int classFilter, int teamFilter, int assignFilter, int statusFilter) throws SQLException;
    int countAll(Connection connection, int classFilter, int teamFilter)throws SQLException;
    int countFilter(Connection connection,String search, int classFilter, int teamFilter, int assignFilter, int statusFilter)throws SQLException;
    int addIssue(Connection connection, Issue issue) throws SQLException;
    int getNewId(Connection connection) throws SQLException;
}
