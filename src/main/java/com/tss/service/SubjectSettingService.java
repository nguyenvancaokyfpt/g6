package com.tss.service;

import com.tss.model.system.Setting;
import java.util.List;

import com.tss.model.system.SubjectSetting;

public interface SubjectSettingService {

    List<SubjectSetting> getSubjectSettingList(int start, int length, String search,
            String subjectFilter, String typeFilter, String statusFilter);

    int countAll(String search, String subjectFilter, String typeFilter, String statusFilter);

    int countAll();

    boolean add(SubjectSetting subjectSetting);

    boolean update(SubjectSetting subjectSetting);

    boolean changeStatus(int id);

    SubjectSetting findById(int id);

    List<Setting> getSettings();
}
