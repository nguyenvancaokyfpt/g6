/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.service.impl;

import com.tss.dao.BaseDao;
import com.tss.dao.ClassDao;
import com.tss.dao.impl.ClassDaoImpl;
import com.tss.model.ClassEntity;
import com.tss.service.ClassService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ClassServiceImpl implements ClassService{
    private ClassDao classDao;
    public ClassServiceImpl(){
        classDao = new ClassDaoImpl();
    }

    @Override
    public List<ClassEntity> List() {
         Connection connection = null;
        List<ClassEntity> classEntitys = null;
        try {
            connection = BaseDao.getConnection();

            classEntitys = classDao.List(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return classEntitys;
    }
}
