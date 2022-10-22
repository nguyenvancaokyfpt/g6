/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.service;

import com.tss.model.ClassEvalCriteria;
import java.util.List;

/**
 *
 * @author a
 */
public interface ClassEvalCriteriaService {
    List<ClassEvalCriteria> List(String search, int currentPageNo, int PageSize);
    int countAll(String search);
    int countAll();
}
