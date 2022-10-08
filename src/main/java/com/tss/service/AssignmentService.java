package com.tss.service;

import java.util.List;

import com.tss.model.Assignment;

public interface AssignmentService {

    List<Assignment> findAll(int start, int length, String search, 
            String subjectFilter, String isTeamworkFilter, String isOngoingFilter,
            String statusFilter);

    int countAll(String search, String subjectFilter,
            String isTeamworkFilter, String isOngoingFilter, String statusFilter);

    int countAll();

    boolean add(Assignment assignment);

    boolean update(Assignment assignment);

    boolean changeStatus(int id);

    Assignment findById(int id);
}
