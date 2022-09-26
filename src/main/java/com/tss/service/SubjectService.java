package com.tss.service;

import java.util.List;

import com.tss.model.Subject;

public interface SubjectService {
    
    List<Subject> List( int currentPageNo, int PageSize);
    
    boolean add(Subject subject);

    boolean inactive(int id);

    boolean active(int id);

    boolean modify(Subject subject);

    Subject findById(int id);

    List<Subject> findAll(int start, int length, String search);

    int countAll();

    int countAll(String search);

    String getUserNameById(int id);

    List<Integer> pages(int PageSize);
}
