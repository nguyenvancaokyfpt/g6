package com.tss.service;

import java.util.List;

import com.tss.model.Trainee;
import com.tss.model.User;
import com.tss.model.system.Role;
import com.tss.model.util.DataTablesColumns;

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

        boolean update(User user, String fullName, String email, String mobile);

        List<User> findAll(int start, int length, String search, List<DataTablesColumns> columns, int orderColumn,
                        String orderDir);

        List<User> findAll(int start, int length, String search, java.util.List<DataTablesColumns> columns,
                        int orderColumn, String orderDir, String roleFilter, String statusFilter);

        int countAll(String search, String roleFilter, String statusFilter);

        java.util.List<Trainee> findAllByClassId(int start, int length, String search,
                        java.util.List<DataTablesColumns> columns, int orderColumn, String orderDir,
                        String statusFilter,
                        int classId);

        int countAllByClassId(int classId);

        int countAllByClassId(String search, String statusFilter, int classId);

        void createTraineeAccount(Trainee trainee);

        void updateUser(int userId, String fullname, String mobile);

        List<Trainee> GetWaitingList(int classId);

        List<Role> getRoles();

        boolean UpdateRole(int userId, int roleId);

        List<User> getSupporter();
}
