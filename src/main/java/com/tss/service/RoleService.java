package com.tss.service;

import java.util.List;
import java.util.TreeSet;

import com.tss.constants.RoleConstants;
import com.tss.model.sercurity.UserRole;

public interface RoleService {
    
    List<UserRole> findByUserId(int userId);

    TreeSet<RoleConstants> convertRoleListToRoleConstantsList(List<UserRole> roles);

    boolean addRoleForUserByUserEmail(String email, RoleConstants student);
    
}
