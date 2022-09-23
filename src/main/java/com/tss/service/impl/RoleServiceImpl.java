package com.tss.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.TreeSet;

import com.tss.dao.BaseDao;
import com.tss.dao.UserRoleDao;
import com.tss.dao.impl.UserRoleDaoImpl;
import com.tss.model.sercurity.UserRole;
import com.tss.service.RoleService;
import com.tss.constants.RoleConstants;

public class RoleServiceImpl implements RoleService {

    private UserRoleDao userRoleDao;

    public RoleServiceImpl() {
        userRoleDao = new UserRoleDaoImpl();
    }

    @Override
    public List<UserRole> findByUserId(int userId) {
        Connection connection = null;
        List<UserRole> list = null;
        try {
            connection = BaseDao.getConnection();
            list = userRoleDao.findByUserId(connection, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return list;
    }

    @Override
    public TreeSet<RoleConstants> convertRoleListToRoleConstantsList(List<UserRole> roles) {
        TreeSet<RoleConstants> roleSet = new TreeSet<RoleConstants>();
        for (UserRole userRole : roles) {
            // get role name
            RoleConstants role = RoleConstants.getRoleById(userRole.getSettingId());
            roleSet.add(role);
        }
        return roleSet;
    }

    @Override
    public boolean addRoleForUserByUserEmail(String email, RoleConstants student) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            flag = userRoleDao.addRoleForUserByUserEmail(connection, email, student.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

}
