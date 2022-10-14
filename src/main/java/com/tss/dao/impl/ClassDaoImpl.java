package com.tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.ClassDao;
import com.tss.model.ClassEntity;
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
            String sql = "select class.class_id, class.class_code, class.combo_id, class.trainer_id, class.term_id, class.status_id, status.status_title, class.description from class, status, class_user where class.status_id = status.status_id and class.class_id = class_user.class_id and class_user.user_id = ?;";
            Object[] params = { userId };
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
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Classroom> classrooms = new ArrayList<Classroom>();
        if (connection != null) {
            String sql = "select class.class_id, class.class_code, class.combo_id, class.trainer_id, class.term_id, class.status_id, status.status_title, class.description from class, status where class.status_id = status.status_id and trainer_id = ?;";
            Object[] params = { userId };
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
    public java.util.List<ClassEntity> List(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ClassEntity> classEntitys = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT \n" +
                    "    c.class_id AS id, c.class_code AS classCode\n" +
                    "FROM\n" +
                    "    class AS c\n" +
                    "        LEFT JOIN\n" +
                    "    milestone AS m ON m.class_id = c.class_id;";
            // Search and Paging
            Object[] params = {};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);

                while (resultSet.next()) {
                    ClassEntity classEntity = new ClassEntity();
                    classEntity.setId(resultSet.getInt("id"));
                    classEntity.setClassCode(resultSet.getString("classCode"));
                    classEntitys.add(classEntity);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return classEntitys;
    }

    @Override
    public List<Classroom> listSearchFilter(Connection connection, int offset, String searchword, String term, String status, String order, String dir) throws SQLException {
        throw new UnsupportedOperationException("<Cần Fix>"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Classroom findById(Connection connection, int id) throws SQLException {
        throw new UnsupportedOperationException("<Cần Fix>"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int countSearchFilter(Connection connection, String searchword, String term, String status) throws SQLException {
        throw new UnsupportedOperationException("<Cần Fix>"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Connection connection, String code, int supporter_id, int trainer_id, int term_id, int status_id, String description) throws SQLException {
        throw new UnsupportedOperationException("<Cần Fix>"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void edit(Connection connection, int class_id, String code, int supporter_id, int trainer_id, int term_id, int status_id, String description) throws SQLException {
        throw new UnsupportedOperationException("<Cần Fix>"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void changeStatus(Connection connection, int id, int status_id) throws SQLException {
        throw new UnsupportedOperationException("<Cần Fix>"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Classroom> listTrainer(Connection connection, int role) throws SQLException {
        throw new UnsupportedOperationException("<Cần Fix>"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
