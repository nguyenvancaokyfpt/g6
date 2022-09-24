package com.tss.service;

import com.tss.model.User;
import com.tss.model.sercurity.UserRole;
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

    boolean modify(User user);

    int countAll();

    int countAll(String search);
}
