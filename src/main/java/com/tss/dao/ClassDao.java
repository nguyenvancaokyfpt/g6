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
}
