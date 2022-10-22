package com.tss.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.ClassDao;
import com.tss.dao.impl.ClassDaoImpl;
import com.tss.helper.DebugHelper;
import com.tss.model.ClassEntity;
import com.tss.model.Classroom;
import com.tss.model.User;
import com.tss.service.ClassService;

public class ClassServiceImpl implements ClassService {

    private ClassDao classDao;

    public ClassServiceImpl() {
        classDao = new ClassDaoImpl();
    }

    @Override
    public List<Classroom> findAllClassroom() {
        Connection connection = null;
        List<Classroom> classrooms = null;
        try {
            connection = BaseDao.getConnection();
            classrooms = classDao.findAllClassroom(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return classrooms;
    }

    @Override
    public List<Classroom> findClassroomByStudent(int userId) {
        Connection connection = null;
        List<Classroom> classrooms = null;
        try {
            connection = BaseDao.getConnection();
            classrooms = classDao.findClassroomByStudent(connection, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return classrooms;
    }

    @Override
    public List<Classroom> findClassroomByTeacher(int userId) {
        Connection connection = null;
        List<Classroom> classrooms = null;
        try {
            connection = BaseDao.getConnection();
            classrooms = classDao.findClassroomByTeacher(connection, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return classrooms;
    }

    @Override
    public List<ClassEntity> List() {
        Connection connection = null;
        List<ClassEntity> classEntitys = null;
        try {
            connection = BaseDao.getConnection();
            classEntitys = classDao.List(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return classEntitys;
    }

    @Override
    public void grantTraineeToClass(User user, int classId, float grade) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            classDao.grantTraineeToClass(connection, user, classId, grade);
        } catch (SQLException e) {
            DebugHelper.print(e.getMessage());
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
    }

    @Override
    public Classroom findClassById(int classId) {
        Connection connection = null;
        Classroom classroom = null;
        try {
            connection = BaseDao.getConnection();
            classroom = classDao.findClassById(connection, classId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return classroom;
    }

}
