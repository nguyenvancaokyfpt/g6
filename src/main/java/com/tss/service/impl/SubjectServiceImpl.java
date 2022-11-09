/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.tss.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.SubjectDao;
import com.tss.dao.impl.SubjectDaoImpl;
import com.tss.model.Subject;
import com.tss.service.SubjectService;

/**
 *
 * @author admin
 */
public class SubjectServiceImpl implements SubjectService {

    private SubjectDao subjectDao;

    public SubjectServiceImpl() {
        subjectDao = new SubjectDaoImpl();
    }

    @Override
    public List<Subject> List(int currentPageNo, int PageSize) {
        Connection connection = null;
        List<Subject> subjectList = null;
        try {
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
        try {
            connection = BaseDao.getConnection();
            if (subjectDao.add(connection, subject) > 0) {
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
            int updateRows = subjectDao.changeStatus(connection, id);
            if (updateRows > 0) {
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
    public boolean update(Subject subject) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (subjectDao.update(connection, subject) > 0) {
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
        try {
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
        try {
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
        try {
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
    public int countAll(String search, String managerFilter,
            String expertFilter, String statusFilter) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = subjectDao.countAll(connection, search, managerFilter, expertFilter, statusFilter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public List<Integer> pages(int totalRecords, int PageSize) {
        List<Integer> pages = new ArrayList<>();
        int totalPages = totalRecords % PageSize == 0 ? totalRecords / PageSize : totalRecords / PageSize + 1;
        for (int i = 1; i <= totalPages; i++) {
            pages.add(i);
        }
        return pages;
    }

    @Override
    public List<Subject> findAllOfManager(int managerId) {
        Connection connection = null;
        List<Subject> subjectList = null;
        try {
            connection = BaseDao.getConnection();
            subjectList = subjectDao.findAllOfManager(connection, managerId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return subjectList;
    }

    public static void main(String[] args) {
        SubjectService subjectService = new SubjectServiceImpl();
        List<Subject> subjectList = subjectService.findAllOfManager(70);
        System.out.println(subjectList.size());

    }

    @Override
    public List<Subject> list(int start, int length,
            String search, String managerFilter, String expertFilter,
            String statusFilter) {
        Connection connection = null;
        List<Subject> subjectList = new ArrayList<>();
        try {
            connection = BaseDao.getConnection();
            subjectList = subjectDao.list(connection, start, length, search, managerFilter, expertFilter, statusFilter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return subjectList;
    }

}
