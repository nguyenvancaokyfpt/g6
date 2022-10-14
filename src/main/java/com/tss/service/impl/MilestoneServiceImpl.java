/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.service.impl;

import com.tss.dao.BaseDao;
import com.tss.dao.MilestoneDao;
import com.tss.dao.impl.MilestoneDaoImpl;
import com.tss.model.Milestone;
import com.tss.model.MilestoneRequest;
import com.tss.service.MilestoneService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class MilestoneServiceImpl implements MilestoneService {

    private MilestoneDao mileStoneDao;

    public MilestoneServiceImpl() {
        mileStoneDao = new MilestoneDaoImpl();
    }
    @Override
    public java.util.List<Milestone> List(int currentPageNo, int PageSize, String search) {
        Connection connection = null;
        List<Milestone> milestoneList = null;
        try {
            connection = BaseDao.getConnection();

            milestoneList = mileStoneDao.List(connection,search,currentPageNo, PageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return milestoneList; }

    @Override
    public int countAll() {
       Connection connection = null;
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            count = mileStoneDao.count(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count; }
    @Override
    public boolean add(Milestone milestone) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (mileStoneDao.add(connection, milestone) > 0) {
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
    public Milestone findById(int mileStoneId) {
        Connection connection = null;
        Milestone milestone = null;
        try {
            connection = BaseDao.getConnection();
            milestone = mileStoneDao.findById(connection, mileStoneId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return milestone;
    }

    @Override
    public boolean update(Milestone milestone, int classId, Date fromDate, Date toDate, String title, String assBody, String desscription, int statusId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            mileStoneDao.update(connection, milestone.getMilestoneId(), classId, fromDate ,toDate ,title , assBody,desscription , statusId);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return false;
    }

    @Override
    public boolean updateAss(int assId, int subjectId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            mileStoneDao.updateAssId(connection,assId,subjectId);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return false;
    }
    
}
