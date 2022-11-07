package com.tss.service;

import java.util.List;

import com.tss.model.EvalCriteria;
import com.tss.model.util.DataTablesColumns;

public interface EvalCriteriaService {

    List<EvalCriteria> List(String fullName, String email, int currentPageNo, int PageSize);

    EvalCriteria findById(int id);

    int count();

    boolean add(Object prams[]);

    boolean del(int id);

    boolean modify(EvalCriteria eval);

    int countAll(int userId);

    List<EvalCriteria> findAll(int start, int length, String search, java.util.List<DataTablesColumns> columns,
            int orderColumn, String orderDir, int subjectFilter, int assignFilter, int statusFilter,int userId);

    int countAll(String search, int subjectFilter, int assignFilter, int statusFilter,int userId);

    public int getNewId();

    boolean changeStatus(int id, int status);
}
