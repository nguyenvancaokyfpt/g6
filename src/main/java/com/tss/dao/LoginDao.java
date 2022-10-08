package com.tss.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface LoginDao {

    /**
     * @param connection
     * @param email
     * @param password
     * @return boolean
     * @throws SQLException
     */
    boolean login(Connection connection, String email, String password) throws SQLException;

}
