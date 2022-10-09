/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.dao;

import com.tss.model.ClassEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ClassDao {
    List<ClassEntity> List(Connection connection)
            throws SQLException;
}
