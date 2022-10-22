/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.dao;

import com.tss.model.ClassEvalCriteria;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author a
 */
public interface ClassEvalCriteriaDao {
    List<ClassEvalCriteria> findAll(Connection connection, int start, int length, String search) throws SQLException;
    int countAll(Connection connection, String search) throws SQLException;
    int count(Connection connection) throws SQLException;
}
