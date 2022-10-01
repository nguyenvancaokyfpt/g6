package com.tss.service;

import java.util.List;

import com.tss.model.Subject;

public interface SubjectService {

    List<Subject> List(int currentPageNo, int PageSize);

    boolean add(Subject subject);

    boolean changeStatus(int id);

    boolean modify(Subject subject);

    Subject findById(int id);

    List<Subject> findAll(int start, int length, String search);

    List<Subject> findAll(int start, int length, String search, String filterStatus);

    int countAll();

    int countAll(String search);

    int countAll(String search, String filterStatus);

    List<Integer> pages(int totalRecords,int pageSize);
}
