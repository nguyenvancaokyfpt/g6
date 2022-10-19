/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.EvalCriteriaDao;
import com.tss.dao.impl.EvalCriteriaDaoImpl;
import com.tss.model.EvalCriteria;
import com.tss.model.util.DataTablesColumns;
import com.tss.service.EvalCriteriaService;

/**
 *
 * @author Dat Lai
 */
public class EvalCriteriaServiceImpl implements EvalCriteriaService {

    private EvalCriteriaDao evalDao;

    public EvalCriteriaServiceImpl() {
        evalDao = new EvalCriteriaDaoImpl();
    }

    @Override
    public List<EvalCriteria> List(String fullName, String email, int currentPageNo, int PageSize) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EvalCriteria findById(int id) {
        Connection connection = null;
        EvalCriteria eval = null;
        try {
            connection = BaseDao.getConnection();
            eval = evalDao.findById(connection, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return eval;
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(Object prams[]) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = evalDao.add(connection, prams);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return (count > 0);
    }

    @Override
    public boolean del(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modify(EvalCriteria eval) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = evalDao.modify(connection, eval.getId(), eval);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return (count > 0);
    }

    @Override
    public int countAll() {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = evalDao.countAll(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public List<EvalCriteria> findAll(int start, int length, String search, List<DataTablesColumns> columns,
            int orderColumn, String orderDir, String subjectFilter, String assignFilter, String statusFilter) {
        Connection connection = null;
        List<EvalCriteria> evalList = null;

        // get orderColumn name
        String columnName = columns.get(orderColumn).getData();
        if (columnName.equals("id")) {
            columnName = "criteria_id";
        } else if (columnName.equals("name")) {
            columnName = "criteria_name";
        } else if (columnName.equals("subjectName")) {
            columnName = "subject_name";
        } else if (columnName.equals("assign_name")) {
            columnName = "title";
        } else if (columnName.equals("weight")) {
            columnName = "eval_weight";
        }
        try {
            connection = BaseDao.getConnection();
            evalList = evalDao.findAll(connection, start, length, search, columnName,
                    orderDir, subjectFilter, assignFilter, statusFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return evalList;
    }

    @Override
    public int countAll(String search, String subjectFilter, String assignFilter, String statusFilter) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = evalDao.countAll(connection, search, subjectFilter, assignFilter, statusFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public int getNewId() {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = evalDao.getNewId(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public boolean changeStatus(int id, int status) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = evalDao.changeStatus(connection, id, status);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return (count > 0);
    }

}
