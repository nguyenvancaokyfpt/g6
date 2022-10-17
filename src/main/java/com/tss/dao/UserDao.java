package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tss.model.Trainee;
import com.tss.model.User;

public interface UserDao {

        List<User> List(Connection connection, String fullName, String email, int currentPageNo, int PageSize)
                        throws SQLException;

        User findById(Connection connection, int userId) throws SQLException;

        int add(Connection connection, User user) throws SQLException;

        int del(Connection connection, int id) throws SQLException;

        int modify(Connection connection, int id, User user) throws SQLException;

        User findByUsername(Connection connection, String username) throws SQLException;

        User findByEmail(Connection connection, String email) throws SQLException;

        int count(Connection connection) throws SQLException;

        int count(Connection connection, String fullName, String email) throws SQLException;

        List<User> findAll(Connection connection, int start, int length, String search) throws SQLException;

        int countAll(Connection connection) throws SQLException;

        int countAll(Connection connection, String search) throws SQLException;

        boolean register(Connection connection, User user) throws SQLException;

        boolean registerWithGoogle(Connection connection, User user) throws SQLException;

        void updateResetPasswordToken(Connection connection, String token, int user_id, long millis)
                        throws SQLException;

        long getResetPasswordSaltByToken(Connection connection, String token) throws SQLException;

        void updatePwdByEmail(Connection connection, String email, String password) throws SQLException;

        void detachResetPasswordToken(Connection connection, String email) throws SQLException;

        String getCurrentPassword(Connection connection, int userId) throws SQLException;

        void updatePassword(Connection connection, int userId, String generateSecurePassword) throws SQLException;

        void update(Connection connection, int userId, String fullName, String email, String mobile)
                        throws SQLException;

        List<User> findAll(Connection connection, int start, int length, String search, String columnName,
                        String orderDir) throws SQLException;

        List<User> findAll(Connection connection, int start, int length, String search, String columnName,
                        String orderDir, String roleFilter, String statusFilter) throws SQLException;

        int countAll(Connection connection, String search, String roleFilter, String statusFilter) throws SQLException;

        java.util.List<Trainee> findAllByClassId(Connection connection, int start, int length, String search,
                String columnName, String orderDir, String statusFilter, int classId) throws SQLException;

        int countAllByClassId(Connection connection, int classId) throws SQLException;

        int countAllByClassId(Connection connection, String search, String statusFilter, int classId) throws SQLException;

}
