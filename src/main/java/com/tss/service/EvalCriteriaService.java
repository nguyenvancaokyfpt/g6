package com.tss.service;

import java.util.List;

import com.tss.model.*;
import com.tss.model.util.DataTablesColumns;

public interface EvalCriteriaService {

    List<EvalCriteria> List(String fullName, String email, int currentPageNo, int PageSize);

    EvalCriteria findById(int id);

    int count();

    boolean add(Object prams[]);

    boolean del(int id);

    boolean modify(EvalCriteria eval);

    int countAll();

    List<EvalCriteria> findAll(int start, int length, String search, java.util.List<DataTablesColumns> columns,
            int orderColumn, String orderDir, String subjectFilter,String assignFilter, String statusFilter);

    int countAll(String search, String subjectFilter,String assignFilter, String statusFilter);

    public int getNewId();
}
