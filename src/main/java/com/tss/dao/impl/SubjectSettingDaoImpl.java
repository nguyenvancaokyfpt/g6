package com.tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.SubjectSettingDao;
import com.tss.model.system.SubjectSetting;

public class SubjectSettingDaoImpl implements SubjectSettingDao {

    @Override
    public int countAll(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT count(*) as count FROM subject_setting";
            Object[] params = {};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return count;
    }

    @Override
    public int add(Connection connection, SubjectSetting subjectSetting) throws SQLException {
        PreparedStatement preparedStatement = null;
        int updateRows = 0;
        if (connection != null) {
            String sql = "INSERT INTO subject_setting (type_id, setting_title, setting_value, display_order, status_id, description, subject_id) VALUES (?,?,?,?,?,?,?)";
            Object[] params = { subjectSetting.getTypeId(), subjectSetting.getTitle(), subjectSetting.getValue(),
                    subjectSetting.getDisplayOrder(), subjectSetting.getStatusId(), subjectSetting.getDescription(),
                    subjectSetting.getSubjectId() };
            try {
                updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
        return updateRows;
    }

    @Override
    public int update(Connection connection, SubjectSetting subjectSetting) throws SQLException {
        PreparedStatement preparedStatement = null;
        int updateRows = 0;
        if (connection != null) {
            String sql = "UPDATE subject_setting SET type_id = ?, setting_title = ?, setting_value = ?, display_order = ?, status_id = ?, description = ?, subject_id = ? WHERE setting_id = ?";
            Object[] params = { subjectSetting.getTypeId(), subjectSetting.getTitle(), subjectSetting.getValue(),
                    subjectSetting.getDisplayOrder(), subjectSetting.getStatusId(), subjectSetting.getDescription(),
                    subjectSetting.getSubjectId(), subjectSetting.getSettingId() };
            try {
                updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
        return updateRows;
    }

    @Override
    public int changeStatus(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        int updateRows = 0;
        if (connection != null) {
            String sql = "UPDATE subject_setting SET status_id = (CASE WHEN status_id = 1 THEN 0 ELSE 1 END) WHERE setting_id = ?";
            Object[] params = { id };
            try {
                updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
        return updateRows;
    }

    @Override
    public SubjectSetting findById(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        SubjectSetting subjectSetting = null;
        if (connection != null) {
            String sql = "SELECT ss.*, s.subject_name, st.setting_title as type_title\n"
                    + "FROM subject_setting ss join subject s on ss.subject_id = s.subject_id\n"
                    + "join setting st on ss.type_id = st.setting_id\n"
                    + "WHERE ss.setting_id = ?";
            Object[] params = { id };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    subjectSetting = new SubjectSetting();
                    subjectSetting.setSettingId(resultSet.getInt("setting_id"));
                    subjectSetting.setTypeId(resultSet.getInt("type_id"));
                    subjectSetting.setTitle(resultSet.getString("setting_title"));
                    subjectSetting.setValue(resultSet.getInt("setting_value"));
                    subjectSetting.setDisplayOrder(resultSet.getString("display_order"));
                    subjectSetting.setStatusId(resultSet.getInt("status_id"));
                    subjectSetting.setDescription(resultSet.getString("description"));
                    subjectSetting.setSubjectId(resultSet.getInt("subject_id"));
                    subjectSetting.setSubjectName(resultSet.getString("subject_name"));
                    subjectSetting.setTypeTitle(resultSet.getString("type_title"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return subjectSetting;
    }

    @Override
    public List<SubjectSetting> getSubjectSettingList(Connection connection, int start, int length, String search,
            String subjectFilter, String typeFilter, String statusFilter) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<SubjectSetting> subjectSettingList = new ArrayList<SubjectSetting>();
        if (connection != null) {
            String sql = "SELECT ss.*, s.subject_name, st.setting_title as type_title\n"
                    + "FROM subject_setting ss join subject s on ss.subject_id = s.subject_id\n"
                    + "join setting st on ss.type_id = st.setting_id\n"
                    + "WHERE (ss.setting_title LIKE ? or ss.setting_value like ?) AND (ss.subject_id LIKE ? and ss.type_id LIKE ? and ss.status_id LIKE ?)\n"
                    + "ORDER BY setting_id DESC LIMIT ?, ?";
            Object[] params = { "%" + search + "%", "%" + search + "%",
                    subjectFilter.equals("") ? "%%" : subjectFilter, "%" + typeFilter + "%",
                    "%" + statusFilter + "%", start, length };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    SubjectSetting subjectSetting = new SubjectSetting();
                    subjectSetting.setSettingId(resultSet.getInt("setting_id"));
                    subjectSetting.setTypeId(resultSet.getInt("type_id"));
                    subjectSetting.setTitle(resultSet.getString("setting_title"));
                    subjectSetting.setValue(resultSet.getInt("setting_value"));
                    subjectSetting.setDisplayOrder(resultSet.getString("display_order"));
                    subjectSetting.setStatusId(resultSet.getInt("status_id"));
                    subjectSetting.setDescription(resultSet.getString("description"));
                    subjectSetting.setSubjectId(resultSet.getInt("subject_id"));
                    subjectSetting.setSubjectName(resultSet.getString("subject_name"));
                    subjectSetting.setTypeTitle(resultSet.getString("type_title"));
                    subjectSettingList.add(subjectSetting);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return subjectSettingList;
    }

    @Override
    public int countAll(Connection connection, String search, String subjectFilter,
            String typeFilter, String statusFilter) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(*) AS count FROM subject_setting ss join subject s on ss.subject_id = s.subject_id\n"
                    + "join setting st on ss.type_id = st.setting_id\n"
                    + "WHERE (ss.setting_title LIKE ? or ss.setting_value like ?) AND (ss.subject_id LIKE ? and ss.type_id LIKE ? and ss.status_id LIKE ?)";
            Object[] params = { "%" + search + "%", "%" + search + "%",
                    subjectFilter.equals("") ? "%%" : subjectFilter, "%" + typeFilter + "%",
                    "%" + statusFilter + "%" };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return count;
    }

}
