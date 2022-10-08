/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.dao.impl;

import com.tss.dao.BaseDao;
import com.tss.dao.ClassDao;
import com.tss.model.ClassEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ClassDaoImpl implements ClassDao{
  @Override
    public java.util.List<ClassEntity> List(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ClassEntity> classEntitys = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT \n" +
"    c.class_id AS id, c.class_code AS classCode\n" +
"FROM\n" +
"    class AS c\n" +
"        LEFT JOIN\n" +
"    milestone AS m ON m.class_id = c.class_id;";
            // Search and Paging
            Object[] params = {};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);

                while (resultSet.next()) {
                    ClassEntity classEntity = new ClassEntity();
                    classEntity.setId(resultSet.getInt("id"));
                    classEntity.setClassCode(resultSet.getString("classCode"));
                    classEntitys.add(classEntity);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return classEntitys;}  
}
