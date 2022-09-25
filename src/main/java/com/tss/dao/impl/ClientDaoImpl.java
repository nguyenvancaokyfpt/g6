/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.dao.impl;

import com.tss.dao.BaseDao;
import com.tss.dao.ClientDao;
import com.tss.model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ClientDaoImpl implements ClientDao {

  

    @Override
    public void update(Connection connection, int userId, String address, String company) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            String sql = "UPDATE client set address = ? , company = ? WHERE user_id = ?";
            Object[] params = {userId};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    preparedStatement.setString(1, address);
                    preparedStatement.setString(2, company);
                    preparedStatement.setInt(3, userId);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
    }

    @Override
    public Client findClientById(Connection cnctn, int userId) throws SQLException {
    
        if (cnctn != null) {
            String sql = "SELECT client_id , user_id,mobile,address ,position,company FROM client WHERE user_id = ?";
            // Object[] params = {userId};
            try {
                // resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
              PreparedStatement   preparedStatement = cnctn.prepareStatement(sql);
                preparedStatement.setInt(1, userId);
               ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new Client(resultSet.getInt("client_id"),
                            resultSet.getInt("user_id"), resultSet.getString("mobile"),
                            resultSet.getString("address"),
                            resultSet.getString("position"),
                            resultSet.getString("company"));
//                   client.setClientId(resultSet.getInt("client_id"));
//                    client.setUserId(resultSet.getInt("user_id"));
//                    client.setMobile(resultSet.getString("mobile"));
//                    client.setAddress(resultSet.getString("address"));
//                    client.setCompany(resultSet.getString("company"));
//                    client.setPosition(resultSet.getString("position"));
                }

            } catch (SQLException e) {
                e.printStackTrace();}
//            } finally {
//                BaseDao.closeResource(null, preparedStatement, resultSet);
//            }
        }
        return null;
    }

}
