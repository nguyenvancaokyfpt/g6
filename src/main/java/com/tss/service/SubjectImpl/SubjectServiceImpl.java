/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.service.SubjectImpl;

import com.tss.dao.BaseDao;
import com.tss.dao.SubjectDao;
import com.tss.dao.impl.SubjectDaoImpl;
import com.tss.model.Subject;
import com.tss.service.Subject.SubjectService;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author admin
 */
public class SubjectServiceImpl implements SubjectService{

    private SubjectDao subjectDao;

    public SubjectServiceImpl() {
        subjectDao = new SubjectDaoImpl();
    }

    @Override
    public List<Subject> List(int currentPageNo, int PageSize) {
        Connection connection = null;
        List<Subject> subjectList = null;
        try{
            connection = BaseDao.getConnection();
            subjectList = subjectDao.List(connection, currentPageNo, PageSize);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return subjectList;
    }

    @Override
    public boolean add(Subject subject) {
        Connection connection = null;
        boolean flag = false;
        try{
            connection = BaseDao.getConnection();
            if(subjectDao.add(connection, subject) > 0){
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
    public boolean inactive(int id) {
        Connection connection = null;
        boolean flag = false;
        try{
            connection = BaseDao.getConnection();
            if(subjectDao.inactive(connection, id) > 0){
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
    public boolean active(int id) {
        Connection connection = null;
        boolean flag = false;
        try{
            connection = BaseDao.getConnection();
            if(subjectDao.active(connection, id) > 0){
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
    public boolean modify(Subject subject) {
        Connection connection = null;
        boolean flag = false;
        try{
            connection = BaseDao.getConnection();
            if(subjectDao.modify(connection, subject) > 0){
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
    public Subject findById(int id) {
        Connection connection = null;
        Subject subject = null;
        try{
            connection = BaseDao.getConnection();
            subject = subjectDao.findById(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return subject;
    }

    @Override
    public List<Subject> findAll(int start, int length, String string) {
        Connection connection = null;
        List<Subject> subjectList = null;
        try{
            connection = BaseDao.getConnection();
            subjectList = subjectDao.findAll(connection, start, length, string);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return subjectList;
    }

    @Override
    public int countAll() {
        Connection connection = null;
        int count = 0;
        try{
            connection = BaseDao.getConnection();
            count = subjectDao.countAll(connection);
        } catch (Exception e) {
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
        try{
            connection = BaseDao.getConnection();
            count = subjectDao.countAll(connection, search);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public String getUserNameById(int id) {
        Connection connection = null;
        String name = null;
        try{
            connection = BaseDao.getConnection();
            name = subjectDao.getUserNameById(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return name;
    }

    @Override
    public List<Integer> pages(int PageSize) {
        Connection connection = null;
        List<Integer> pages = null;
        try{
            connection = BaseDao.getConnection();
            pages = subjectDao.pages(connection, PageSize);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return pages;
    }
    
}
