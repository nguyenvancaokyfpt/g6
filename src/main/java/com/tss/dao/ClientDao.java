package com.tss.dao;
import com.tss.model.Client;
import java.sql.Connection;
import java.sql.SQLException;

public interface ClientDao {
    Client findClientById(Connection connection, int userId) throws SQLException;
    void update(Connection connection, int userId, String address, String company) throws SQLException;

}
