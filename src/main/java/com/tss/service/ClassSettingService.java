package com.tss.service;

import java.util.List;

import com.tss.model.system.ClassSetting;
import com.tss.model.util.DataTablesColumns;

public interface ClassSettingService {

    List<ClassSetting> findAll(int start, int length, String search, List<DataTablesColumns> columns, int orderColumn,
            String orderDir, String typeFilter, String statusFilter, int classId);

    int countAll(int classId);

    int countAll(String search, String typeFilter, String statusFilter, int classId);

    void updateStatus(int settingId, boolean b);

    ClassSetting getSettingById(int settingId);

    void updateClassSetting(int settingId, String value, String description, String displayOrder, int active);
    
}
