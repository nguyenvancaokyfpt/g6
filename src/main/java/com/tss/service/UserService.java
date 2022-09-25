package com.tss.service;

import java.util.List;

import com.tss.model.User;

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

    String generateResetPasswordToken(User user);

    Boolean checkResetPasswordToken(String token, String email);

    void updatePwdByEmail(String email, String password);

    void detachResetPasswordToken(String email);

    boolean changePassword(User user, String currentpassword, String newpassword);
    String update(int id, String fullName, String email, String mobile);
}
