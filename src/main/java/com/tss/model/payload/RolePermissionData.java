package com.tss.model.payload;

import java.util.List;

import com.tss.constants.RoleConstants;
import com.tss.model.system.Screen;

public class RolePermissionData {
    private RoleConstants role;
    private int numberOfUser;
    private List<Screen> permission;

    public RolePermissionData() {

    }

    public RolePermissionData(RoleConstants role, int numberOfUser, List<Screen> permission) {
        this.role = role;
        this.numberOfUser = numberOfUser;
        this.permission = permission;
    }

    /**
     * @return RoleConstants return the role
     */
    public RoleConstants getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(RoleConstants role) {
        this.role = role;
    }

    /**
     * @return int return the numberOfUser
     */
    public int getNumberOfUser() {
        return numberOfUser;
    }

    /**
     * @param numberOfUser the numberOfUser to set
     */
    public void setNumberOfUser(int numberOfUser) {
        this.numberOfUser = numberOfUser;
    }

    /**
     * @return List<Screen> return the permission
     */
    public List<Screen> getPermission() {
        return permission;
    }

    /**
     * @param permission the permission to set
     */
    public void setPermission(List<Screen> permission) {
        this.permission = permission;
    }

}
