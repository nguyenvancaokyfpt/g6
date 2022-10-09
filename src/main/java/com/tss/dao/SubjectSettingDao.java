package com.tss.dao;

import com.tss.model.system.SubjectSetting;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface SubjectSettingDao {

    List<SubjectSetting> getSubjectSettingList(Connection connection, int start, int length,
            String search, String subjectFilter, String typeFilter, String displayOrderFilter,
            String statusFilter, String sort)
            throws SQLException;

    int countAll(Connection connection, String search, String subjectFilter, String typeFilter,
            String displayOrderFilter, String statusFilter) throws SQLException;

    int countAll(Connection connection) throws SQLException;

    int add(Connection connection, SubjectSetting subjectSetting) throws SQLException;

    int update(Connection connection, SubjectSetting subjectSetting) throws SQLException;

    int changeStatus(Connection connection, int id) throws SQLException;

    SubjectSetting findById(Connection connection, int id) throws SQLException;

}
