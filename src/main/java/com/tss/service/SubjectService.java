package com.tss.service;

import java.util.List;

import com.tss.model.Subject;

public interface SubjectService {

    List<Subject> List(int currentPageNo, int PageSize);

    boolean add(Subject subject);

    boolean changeStatus(int id);

    boolean update(Subject subject);

    Subject findById(int id);

    List<Subject> findAll(int start, int length, String search);

    List<Subject> list(int start, int length,
                        String search, String managerFilter, String expertFilter,
                        String statusFilter);

    int countAll();


    int countAll(String search, String managerFilter,
                        String expertFilter, String statusFilter);

    List<Integer> pages(int totalRecords, int pageSize);
    
    List<Subject> findAllOfManager(int managerId);
}
