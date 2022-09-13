package com.tss.service;

import com.tss.model.User;
import java.util.List;

public interface UserService {

    User login(String userCode, String password);

    boolean updatePwd(String userCode, String password);

    List<User> List(String fullName, String email, int currentPageNo, int PageSize);

    User findById(int id);

    boolean add(User user);

    boolean del(int id);

    boolean modify(int id, User user);
}
