/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.WebContactDao;
import com.tss.dao.impl.WebContactDaoImpl;
import com.tss.model.WebContact;
import com.tss.service.WebContactService;

/**
 *
 * @author Dat Lai
 */
public class WebContactServiceImpl implements WebContactService {

    private WebContactDao webDao;

    public WebContactServiceImpl() {
        webDao = new WebContactDaoImpl();
    }

    @Override
    public List<WebContact> List(String fullName, String email, int currentPageNo, int PageSize) {
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
    public List<WebContact> findAll(int start, int length, String search, String orderBy, String orderDir,
            int supporter_id) {
        Connection connection = null;
        List<WebContact> webList = null;
        try {
            connection = BaseDao.getConnection();
            webList = webDao.findAll(connection, start, length, search, orderBy, orderDir, supporter_id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return webList;
    }

    @Override
    public WebContact findById(int catId) {
        Connection connection = null;
        WebContact web = null;
        try {
            connection = BaseDao.getConnection();
            web = webDao.findById(connection, catId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return web;
    }

    @Override
    public WebContact findByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public WebContact findByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int count(String fullName, String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(WebContact web) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean del(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modify(int id, WebContact web) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public int countAll(String search, int supFilter) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = webDao.countAll(connection, search, supFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    public static void main(String[] args) {
        WebContactService webService = new WebContactServiceImpl();
        System.out.println(webService.countAll("", 2));
    }

    @Override
    public boolean reply(int id, String reply) {
        Connection connection = null;
        int count = 0;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            count = webDao.reply(connection, id, reply);
            if (count > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

}
