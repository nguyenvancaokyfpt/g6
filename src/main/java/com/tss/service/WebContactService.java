/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tss.service;

import com.tss.model.WebContact;
import java.util.List;

/**
 *
 * @author Dat Lai
 */
public interface WebContactService {
     List<WebContact> List(String fullName, String email, int currentPageNo, int PageSize);

    List<WebContact> findAll(int start, int length, String search);

    WebContact findById(int catId);

    WebContact findByUsername(String username);

    WebContact findByEmail(String email);

    int count();

    int count(String fullName, String email);

    boolean add(WebContact web);

    boolean del(int id);

    boolean modify(int id, WebContact web);

    int countAll();

    int countAll(String search);
}
