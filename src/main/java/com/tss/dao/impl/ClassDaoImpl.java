package com.tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.ClassDao;
import com.tss.model.Classroom;

public class ClassDaoImpl implements ClassDao {

    @Override
    public List<Classroom> findAllClassroom(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Classroom> classrooms = new ArrayList<Classroom>();
        if (connection != null) {
            String sql = "select class_id, class_code, combo_id, trainer_id, term_id, status.status_id, status.status_title, description from class, status where class.status_id = status.status_id;";
            Object[] params = {};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    Classroom classroom = new Classroom();
                    classroom.setClassId(resultSet.getInt("class_id"));
                    classroom.setClassCode(resultSet.getString("class_code"));
                    classroom.setComboId(resultSet.getInt("combo_id"));
                    classroom.setTrainerId(resultSet.getInt("trainer_id"));
                    classroom.setTermId(resultSet.getInt("term_id"));
                    classroom.setStatusId(resultSet.getInt("status_id"));
                    classroom.setStatusTitle(resultSet.getString("status_title"));
                    classroom.setDescription(resultSet.getString("description"));
                    classrooms.add(classroom);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return classrooms;
    }

    @Override
    public List<Classroom> findClassroomByStudent(Connection connection, int userId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Classroom> classrooms = new ArrayList<Classroom>();
        if (connection != null) {
            String sql = "select class.class_id, class.class_code, class.combo_id, class.trainer_id, class.term_id, class.status_id, status.status_title, class.description from class, status, student_class where class.status_id = status.status_id and class.class_id = student_class.class_id and student_class.student_id = ?;";
            Object[] params = {userId};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    Classroom classroom = new Classroom();
                    classroom.setClassId(resultSet.getInt("class_id"));
                    classroom.setClassCode(resultSet.getString("class_code"));
                    classroom.setComboId(resultSet.getInt("combo_id"));
                    classroom.setTrainerId(resultSet.getInt("trainer_id"));
                    classroom.setTermId(resultSet.getInt("term_id"));
                    classroom.setStatusId(resultSet.getInt("status_id"));
                    classroom.setStatusTitle(resultSet.getString("status_title"));
                    classroom.setDescription(resultSet.getString("description"));
                    classrooms.add(classroom);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return classrooms;
    }

    @Override
    public List<Classroom> findClassroomByTeacher(Connection connection, int userId) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
    

