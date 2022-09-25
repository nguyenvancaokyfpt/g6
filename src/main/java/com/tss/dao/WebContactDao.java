/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tss.dao;

import com.tss.model.WebContact;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dat Lai
 */
public interface WebContactDao {
     List<WebContact> List(Connection connection, String fullName, String email, int currentPageNo, int PageSize) throws SQLException;

    WebContact findById(Connection connection, int catId) throws SQLException;

    int add(Connection connection, WebContact web) throws SQLException;

    int del(Connection connection, int id) throws SQLException;

    int modify(Connection connection, int id, WebContact web) throws SQLException;

    WebContact findByUsername(Connection connection, String username) throws SQLException;

    WebContact findByEmail(Connection connection, String email) throws SQLException;

    int count(Connection connection) throws SQLException;

    int count(Connection connection, String fullName, String email) throws SQLException;

    java.util.List<WebContact> findAll(Connection connection, int start, int length, String search) throws SQLException;

    int countAll(Connection connection) throws SQLException;

    int countAll(Connection connection, String search) throws SQLException;
}
