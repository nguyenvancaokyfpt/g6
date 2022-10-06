package com.tss.helper;

import java.util.List;

import com.tss.constants.ScreenConstants;
import com.tss.model.sercurity.Permission;

public class PermissionHelper {

    private List<Permission> permissions;

    public PermissionHelper() {}

    public PermissionHelper(List<Permission> permissions) {
        this.permissions = permissions;
    }

    /**
     * @return List<Permission> return the permissions
     */
    public List<Permission> getPermissions() {
        return permissions;
    }

    /**
     * @param permissions the permissions to set
     */
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public boolean hasPermission(ScreenConstants screen) {
        for (Permission permission : permissions) {
            if (permission.getScreen().equals(screen)) {
                if (permission.isCanGet()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasGroupPermissions(String groupName) {
        for (Permission permission : permissions) {
            if (permission.getScreen().getParentPath().equals(groupName)) {
                if (permission.isCanGet()) {
                    return true;
                }
            }
        }
        return false;
    }


}
