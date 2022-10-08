package com.tss.service;

import com.tss.model.Assignment;
import com.tss.model.util.DataTablesColumns;
import java.util.List;

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
