package com.tss.dao.impl;

import com.tss.dao.BaseDao;
import com.tss.dao.SubjectSettingDao;
import com.tss.model.system.SubjectSetting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectSettingDaoImpl implements SubjectSettingDao {

    @Override
    public List<SubjectSetting> getSubjectSettingList(Connection connection, int start, int length, String search,
            String subjectFilter, String displayOrderFilter, String statusFilter, String sort) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<SubjectSetting> list = new ArrayList<>();
        if (connection != null) {
            String sql = "";
            if (subjectFilter.equals("") && sort.equals("")) {
                sql = "SELECT ss.*, s.subject_name\n"
                        + "FROM subject_setting ss join subject s on ss.subject_id = s.subject_id\n"
                        + "WHERE (s.subject_name LIKE ? OR ss.setting_title LIKE ?)\n"
                        + "AND display_order LIKE ? AND ss.status_id LIKE ?\n"
                        + "LIMIT ?,?";
            } else if (subjectFilter.equals("") && !sort.equals("")) {
                sql = "SELECT ss.*, s.subject_name\n"
                        + "FROM subject_setting ss join subject s on ss.subject_id = s.subject_id\n"
                        + "WHERE (s.subject_name LIKE ? OR ss.setting_title LIKE ?)\n"
                        + "AND display_order LIKE ? AND ss.status_id LIKE ?\n"
                        + "ORDER BY setting_value " + sort + "\n"
                        + "LIMIT ?,?";
            } else if (!subjectFilter.equals("") && sort.equals("")) {
                sql = "SELECT ss.*, s.subject_name\n"
                        + "FROM subject_setting ss join subject s on ss.subject_id = s.subject_id\n"
                        + "WHERE (s.subject_name LIKE ? OR ss.setting_title LIKE ?)\n"
                        + "AND ss.subject_id = " + subjectFilter
                        + "\nAND display_order LIKE ? AND ss.status_id LIKE ?\n"
                        + "LIMIT ?,?";
            } else {
                sql = "SELECT ss.*, s.subject_name\n"
                        + "FROM subject_setting ss join subject s on ss.subject_id = s.subject_id\n"
                        + "WHERE (s.subject_name LIKE ? OR ss.setting_title LIKE ?)\n"
                        + "AND ss.subject_id = " + subjectFilter
                        + "\nAND display_order LIKE ? AND ss.status_id LIKE ?\n"
                        + "ORDER BY setting_value " + sort + "\n"
                        + "LIMIT ?,?";
            }
            Object[] params = { "%" + search + "%", "%" + search + "%",
                    "%" + displayOrderFilter + "%", "%" + statusFilter + "%", start, length };
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
                    list.add(subjectSetting);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return list;
    }

    @Override
    public int countAll(Connection connection, String search, String subjectFilter,
            String displayOrderFilter, String statusFilter) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "";
            if (subjectFilter.equals("")) {
                sql = "SELECT count(*)\n"
                        + "FROM subject_setting ss join subject s on ss.subject_id = s.subject_id\n"
                        + "WHERE (s.subject_name LIKE ? OR ss.setting_title LIKE ?)\n"
                        + "AND display_order LIKE ? AND ss.status_id LIKE ?";
            } else {
                sql = "SELECT count(*)\n"
                        + "FROM subject_setting ss join subject s on ss.subject_id = s.subject_id\n"
                        + "WHERE (s.subject_name LIKE ? OR ss.setting_title LIKE ?)\n"
                        + "AND ss.subject_id = " + subjectFilter
                        + "\nAND display_order LIKE ? AND ss.status_id LIKE ?";
            }
            Object[] params = { "%" + search + "%", "%" + search + "%",
                    "%" + displayOrderFilter + "%", "%" + statusFilter + "%" };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    count = resultSet.getInt(1);
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
            String sql = "SELECT ss.*, s.subject_name FROM subject_setting ss join subject s on ss.subject_id = s.subject_id\n"
                    + "WHERE setting_id = ?";
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
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return subjectSetting;
    }

}
