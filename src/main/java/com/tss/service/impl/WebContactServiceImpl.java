/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.service.impl;

import com.tss.dao.BaseDao;
import com.tss.dao.WebContactServiceDao;
import com.tss.dao.impl.WebContactServiceDaoImpl;
import com.tss.model.WebContact;
import com.tss.model.WebContact;
import com.tss.service.WebContactService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dat Lai
 */
public class WebContactServiceImpl implements WebContactService {

    private WebContactServiceDao webDao;

    public WebContactServiceImpl() {
        webDao = new WebContactServiceDaoImpl();
    }

    @Override
    public java.util.List<WebContact> List(String fullName, String email, int currentPageNo, int PageSize) {
        Connection connection = null;
        List<WebContact> webList = null;

        try {
            connection = BaseDao.getConnection();

            webList = webDao.List(connection, fullName, email, currentPageNo, PageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return webList;
    }

    @Override
    public java.util.List<WebContact> findAll(int start, int length, String search) {
        Connection connection = null;
        List<WebContact> webList = null;
        try {
            connection = BaseDao.getConnection();
            webList = webDao.findAll(connection, start, length, search);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return webList;
    }

    @Override
    public WebContact findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public WebContact findByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public WebContact findByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int count(String fullName, String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(WebContact web) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean del(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modify(int id, WebContact web) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int countAll() {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = webDao.countAll(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public int countAll(String search) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = webDao.countAll(connection, search);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

}
