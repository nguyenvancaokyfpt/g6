package com.tss.model.payload;

import java.util.ArrayList;
import java.util.List;

import com.tss.model.sercurity.Permission;

public class RolePermissionMessage {

    private int roleId;
    private List<Permission> permissions = new ArrayList<Permission>();

    public RolePermissionMessage() {
    }

    public RolePermissionMessage(int roleId, List<Permission> permission) {
        this.roleId = roleId;
        this.permissions = permission;
    }

    /**
     * @return int return the roleId
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * @return List<Permission> return the permission
     */
    public List<Permission> getPermissions() {
        return permissions;
    }

    /**
     * @param permission the permission to set
     */
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

}
