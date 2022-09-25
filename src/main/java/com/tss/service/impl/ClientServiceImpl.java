/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.service.impl;

import com.tss.dao.BaseDao;
import com.tss.dao.ClientDao;
import com.tss.dao.impl.ClientDaoImpl;
import com.tss.model.Client;
import com.tss.service.ClientService;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class ClientServiceImpl implements ClientService{
    private ClientDao clientDao;
    @Override
    public Client findClientById(int userId) {
        Connection connection = null;
        Client client = null;
        try {
            connection = BaseDao.getConnection();
            client = clientDao.findClientById(connection,userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public String update(int userId, String address, String company) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            clientDao.update(connection,userId,address,company);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return "Success!";
    }
    
}
