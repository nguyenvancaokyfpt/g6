/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.IssueDao;
import com.tss.dao.impl.IssueDaoImpl;
import com.tss.model.Issue;
import com.tss.service.IssueService;

/**
 *
 * @author Dat Lai
 */
public class InsueServiceImpl implements IssueService {

    private IssueDao issueDao;

    public InsueServiceImpl() {
        issueDao = new IssueDaoImpl();
    }

    @Override
    public List<Issue> findAll(int start, int length, String search, String columnName, String orderDir
    , int classFilter, int teamFilter, int assignFilter, int statusFilter,int supId,int mileFilter) {
        Connection connection = null;
        List<Issue> issues = null;
        try {
            connection = BaseDao.getConnection();
            issues = issueDao.findAll(connection, start, length, search, columnName,
                    orderDir, classFilter, teamFilter, assignFilter, statusFilter,supId,mileFilter);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return issues;
    }

    public static void main(String[] args) {
        InsueServiceImpl issueService = new InsueServiceImpl();
        // List<Issue> issues = issueService.findAll(0, 10, "", "issue_id", "asc", "", "", "", "");
    }

    @Override
    public int countAll(int classFilter, int teamFilter) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = issueDao.countAll(connection, classFilter, teamFilter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;

    }

    @Override
    public int countFilter(String search,int classFilter, int teamFilter, int assignFilter,
            int statusFilter, int supId, int mileFilter) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = issueDao.countFilter(connection,search, classFilter, teamFilter,
                    assignFilter, statusFilter,supId, mileFilter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public int addIssue(Issue issue) {
        Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = issueDao.addIssue(connection, issue);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

}
