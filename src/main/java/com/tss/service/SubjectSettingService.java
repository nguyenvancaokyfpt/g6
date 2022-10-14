package com.tss.service;

import java.util.List;

import com.tss.model.system.SubjectSetting;

public interface SubjectSettingService {

    List<SubjectSetting> getSubjectSettingList(int start, int length, String search,
            String subjectFilter, String displayOrderFilter, String statusFilter, String sort);

    int countAll(String search, String subjectFilter, String displayOrderFilter, String statusFilter);

    int countAll();

    boolean add(SubjectSetting subjectSetting);

    boolean update(SubjectSetting subjectSetting);

    boolean changeStatus(int id);

    SubjectSetting findById(int id);

}
