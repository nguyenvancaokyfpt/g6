/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.service;

import com.tss.model.Milestone;
import com.tss.model.MilestoneRequest;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface MilestoneService {
    List<Milestone> List(int currentPageNo, int PageSize, String search); 
    int countAll();
    boolean add(MilestoneRequest milestoneRequest);
    Milestone findById(int mileStoneId);
    boolean update(Milestone milestone, int assId, int classId , Date fromDate , Date toDate , String title, String assBody , String desscription , int statusId);
}
