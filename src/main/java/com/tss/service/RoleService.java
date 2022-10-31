package com.tss.service;

import java.util.List;
import java.util.TreeSet;

import com.tss.constants.RoleConstants;
import com.tss.model.payload.RolePermissionMessage;
import com.tss.model.sercurity.Permission;
import com.tss.model.sercurity.UserRole;
import com.tss.model.system.Screen;

public interface RoleService {

    List<UserRole> findByUserId(int userId);

    TreeSet<RoleConstants> convertRoleListToRoleConstantsList(List<UserRole> roles);

    boolean addRoleForUserByUserEmail(String email, RoleConstants student);

    int countUserByRole(RoleConstants role);

    List<Screen> getPermissionByRole(RoleConstants role);

    Boolean updateRolePermission(int roleId, List<Permission> permissions);

    RolePermissionMessage getRolePermission(int roleId);

}
