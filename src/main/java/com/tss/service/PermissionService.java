package com.tss.service;

import java.util.List;

import com.tss.model.sercurity.Permission;

public interface PermissionService {
    
    List<Permission> List();

    List<Permission> ListByScreenId(int screenId);

    List<Permission> ListBySettingId(int settingId);

    Permission findByScreenId(int screenId);

    Permission findBySettingId(int settingId);

    Permission findByScreenIdAndSettingId(int screenId, int settingId);

    int add(Permission permission);

    int del(int settingId, int screenId);

    int modify(int settingId, int screenId, Permission permission);
    
}
