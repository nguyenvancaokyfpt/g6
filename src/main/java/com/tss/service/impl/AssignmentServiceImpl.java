/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.service.impl;

import java.sql.Connection;
import java.util.List;

import com.tss.dao.AssignmentDao;
import com.tss.dao.BaseDao;
import com.tss.dao.impl.AssignmentDaoImpl;
import com.tss.model.Assignment;
import com.tss.service.AssignmentService;

/**
 *
 * @author admin
 */
public class AssignmentServiceImpl implements AssignmentService {

    private AssignmentDao assignmentDao;

    public AssignmentServiceImpl() {
        assignmentDao = new AssignmentDaoImpl();
    }

    @Override
    public List<Assignment> findAll(int start, int length, String search, String subjectFilter, String isTeamworkFilter,
            String isOngoingFilter, String statusFilter) {
        Connection connection = null;
        List<Assignment> assignments = null;
        try {
            connection = BaseDao.getConnection();
            assignments = assignmentDao.findAll(connection, start, length, search, subjectFilter, isTeamworkFilter,
                    isOngoingFilter, statusFilter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return assignments;
    }

    @Override
    public int countAll(String search, String subjectFilter, String isTeamworkFilter, String isOngoingFilter,
            String statusFilter) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = assignmentDao.countAll(connection, search, subjectFilter, isTeamworkFilter, isOngoingFilter,
                    statusFilter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public int countAll() {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = assignmentDao.countAll(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public boolean add(Assignment assignment) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (assignmentDao.add(connection, assignment) > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public boolean update(Assignment assignment) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (assignmentDao.update(connection, assignment) > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public boolean changeStatus(int id) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (assignmentDao.changeStatus(connection, id) > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public Assignment findById(int id) {
        Connection connection = null;
        Assignment assignment = null;
        try {
            connection = BaseDao.getConnection();
            assignment = assignmentDao.findById(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return assignment;
    }

    @Override
    public List<Assignment> findBySubId(int id) {
        Connection connection = null;
        List<Assignment> assignment = null;
        try {
            connection = BaseDao.getConnection();
            assignment = assignmentDao.findBySubId(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return assignment;
    }
}
