/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.service;

import java.util.Date;
import java.util.List;

import com.tss.model.Assignment;
import com.tss.model.Milestone;

/**
 *
 * @author ADMIN
 */
public interface MilestoneService {
    List<Milestone> List(int currentPageNo, int PageSize, String search);

    int countAll();

    int countAll(String search);

    boolean add(Milestone milestone);

    Milestone findById(int mileStoneId);

    boolean update(Milestone milestone, int classId, Date fromDate, Date toDate, String title, String assBody,
            String desscription, int statusId);

    boolean updateAss(int assId, int subjectId);

    List<Assignment> findAll(int start, int length);
}
