/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.model.ClassAnhPT;
import com.tss.model.ClassEntity;
import com.tss.model.Classroom;
import com.tss.model.Trainee;
import com.tss.model.User;

public interface ClassDao {

    List<Classroom> findAllClassroom(Connection connection) throws SQLException;

    List<Classroom> findClassroomByStudent(Connection connection, int userId) throws SQLException;

    List<Classroom> findClassroomByTeacher(Connection connection, int userId) throws SQLException;

    List<ClassEntity> List(Connection connection)
            throws SQLException;

    List<ClassEntity> ListCbx(Connection connection)
            throws SQLException;

    List<ClassAnhPT> listSearchFilter(Connection connection, int offset, String searchword, String term,
            String status,
            String order, String dir, String subject) throws SQLException;

    List<ClassAnhPT> listSearchFilter2(Connection connection, int offset, String searchword, String term,
            String status,
            String order, String dir, int trainer, String subject) throws SQLException;

    ClassAnhPT findById(Connection connection, int id) throws SQLException;
    ClassAnhPT findById2(Connection connection, int id) throws SQLException;

    ClassEntity findClassById(Connection connection, int id) throws SQLException;

    int countSearchFilter(Connection connection, String searchword, String term, String status,String subject) throws SQLException;

    int countSearchFilter2(Connection connection, String searchword, String term, String status, int trainer,String subject) throws SQLException;

    void add(Connection connection, String code, int supporter_id, int trainer_id, int term_id, int status_id,
            String description) throws SQLException;

    void add2(Connection connection, String code, int supporter_id, int trainer_id, int term_id, int status_id,
            String description, int subject_id) throws SQLException;

    void edit(Connection connection, int class_id, String code, int supporter_id, int trainer_id, int term_id,
            int status_id, String description) throws SQLException;

    void edit2(Connection connection, int class_id, String code, int supporter_id, int trainer_id, int term_id,
            int status_id, String description, int subject_id) throws SQLException;

    void changeStatus(Connection connection, int id, int status_id) throws SQLException;

    List<ClassAnhPT> listTrainer(Connection connection, int role) throws SQLException;

    void grantTraineeToClass(Connection connection, User user, int classId, float grade) throws SQLException;

    Classroom findClassByIdK(Connection connection, int classId) throws SQLException;

    java.util.List<Trainee> findTraineeByClassId(Connection connection, int classId) throws SQLException;

}
