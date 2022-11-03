/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tss.service;

import java.util.List;

import com.tss.model.Issue;

/**
 *
 * @author Dat Lai
 */
public interface IssueService {
    List<Issue> findAll(int start, int length, String search, String columnName, String orderDir
    , int classFilter, int teamFilter, int assignFilter, int statusFilter);

    int countAll(int classFilter, int teamFilter);

    int countFilter(String search, int classFilter, int teamFilter, int assignFilter, int statusFilter);

    int addIssue(Issue issue);
}
