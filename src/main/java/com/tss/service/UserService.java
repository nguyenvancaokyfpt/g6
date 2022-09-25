package com.tss.service;

import com.tss.model.User;
import java.util.List;

public interface UserService {

    boolean updatePwd(String userCode, String password);

    List<User> List(String fullName, String email, int currentPageNo, int PageSize);

    List<User> findAll(int start, int length, String search);

    User findById(int id);

    User findByUsername(String username);

    User findByEmail(String email);

    int count();

    int count(String fullName, String email);

    boolean add(User user);

    boolean del(int id);

    boolean modify(int id, User user);

    int countAll();

    int countAll(String search);
    
    String update(int id, String fullName, String email, String mobile);
}
