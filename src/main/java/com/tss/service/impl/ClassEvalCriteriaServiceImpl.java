/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.service.impl;

import com.tss.dao.BaseDao;
import com.tss.dao.ClassEvalCriteriaDao;
import com.tss.dao.impl.ClassEvalCriteriaDaoImpl;
import com.tss.model.ClassEvalCriteria;
import com.tss.model.Milestone;
import com.tss.service.ClassEvalCriteriaService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author a
 */
public class ClassEvalCriteriaServiceImpl implements ClassEvalCriteriaService{
    private ClassEvalCriteriaDao evalDao;

    public ClassEvalCriteriaServiceImpl() {
        evalDao = new ClassEvalCriteriaDaoImpl();
    }

    @Override
    public List<ClassEvalCriteria> List(String search, int currentPageNo, int PageSize) {
        Connection connection = null;
        List<ClassEvalCriteria> evalCriterias = null;
        try {
            connection = BaseDao.getConnection();

            evalCriterias = evalDao.findAll(connection ,currentPageNo, PageSize , search);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return evalCriterias;}

    @Override
    public int countAll(String search) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = evalDao.countAll(connection, search);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;}

    @Override
    public int countAll() {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = evalDao.count(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count; }
    
}
