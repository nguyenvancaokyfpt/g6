/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.model.ClassEntity;
import com.tss.model.Classroom;

public interface ClassDao {

    List<Classroom> findAllClassroom(Connection connection) throws SQLException;

    List<Classroom> findClassroomByStudent(Connection connection, int userId) throws SQLException;

    List<Classroom> findClassroomByTeacher(Connection connection, int userId) throws SQLException;

    List<ClassEntity> List(Connection connection)
            throws SQLException;

    List<Classroom> listSearchFilter(Connection connection, int offset, String searchword, String term, String status,
            String order, String dir) throws SQLException;

    Classroom findById(Connection connection, int id) throws SQLException;

    int countSearchFilter(Connection connection, String searchword, String term, String status) throws SQLException;

    void add(Connection connection, String code, int supporter_id, int trainer_id, int term_id, int status_id,
            String description) throws SQLException;

    void edit(Connection connection, int class_id, String code, int supporter_id, int trainer_id, int term_id,
            int status_id, String description) throws SQLException;

    void changeStatus(Connection connection, int id, int status_id) throws SQLException;

    List<Classroom> listTrainer(Connection connection, int role) throws SQLException;

}
