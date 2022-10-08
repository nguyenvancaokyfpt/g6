package com.tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.SettingDao;
import com.tss.model.system.Setting;

public class SettingDaoIml implements SettingDao {

    @Override
    public List<Setting> List(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Setting> settingList = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT * FROM setting";
            try {
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    settingList.add(new Setting(resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getInt(6),
                            resultSet.getString(7)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return settingList;
    }

    @Override
    public List<Setting> ListByTypeId(Connection connection) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Setting findById(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Setting> settingList = new ArrayList<>();
        Setting settingDetail = new Setting();
        if (connection != null) {
            String sql = "SELECT setting_id, type_id, setting_title, setting_value, display_order, status_title, description "
                    + "FROM setting inner join status on setting.status_id = status.status_id "
                    + "WHERE setting_id = ?";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    settingDetail.setId(resultSet.getInt(1));
                    settingDetail.setType_id(resultSet.getInt(2));
                    settingDetail.setTitle(resultSet.getString(3));
                    settingDetail.setValue(resultSet.getString(4));
                    settingDetail.setDisplay_order(resultSet.getString(5));
                    settingDetail.setStatusString(resultSet.getString(6));
                    settingDetail.setDescription(resultSet.getString(7));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return settingDetail;
    }

    @Override
    public int add(Connection connection, Setting setting) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int del(Connection connection, int id) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int modify(Connection connection, int id, Setting setting) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Setting> settingList = new ArrayList<>();
        Setting settingDetail = new Setting();
        if (connection != null) {
            String sql = "UPDATE setting\n"
                    + "SET type_id = ?, setting_title = ?,setting_value = ?,display_order = ?,status_id = ?,description = ?\n"
                    + "WHERE setting_id = ?;";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return 0;
    }

    @Override
    public Setting findByName(Connection connection, String name) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int count(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int totalSetting = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(*) FROM setting";
            try {
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    totalSetting = resultSet.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return totalSetting;
    }

    @Override
    public List<Setting> ListPaging(Connection connection, int offset) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Setting> settingList = new ArrayList<>();
        if (connection != null) {
            String sql = "select * from setting limit ?,5";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, offset);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    settingList.add(new Setting(resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getInt(6),
                            resultSet.getString(7)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return settingList;
    }

    @Override
    public List<Setting> CompleteList(Connection connection, int offset, String searchword, String order, String dir) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Setting> settingList = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT setting_id, type_id, setting_title, setting_value, display_order, setting.status_id, status_title, description \n"
                    + "FROM setting inner join status on setting.status_id = status.status_id \n"
                    + "where setting_title like ? ORDER BY " + order + " " + dir + " limit ?,5";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + searchword + "%");
                preparedStatement.setInt(2, offset);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    settingList.add(new Setting(resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getInt(6),
                            resultSet.getString(8),
                            resultSet.getString(7)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return settingList;
    }

    @Override
    public int countComplete(Connection connection, String searchword, String order) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int totalSetting = 0;
        if (connection != null) {
            String sql = "SELECT COUNT(*) FROM setting where setting_title like ? ORDER BY ?";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + searchword + "%");
                preparedStatement.setString(2, order);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    totalSetting = resultSet.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return totalSetting;
    }

    @Override
    public void addSetting(Connection connection, int id, int type_id, String title, String value, String display_order, int status_id, String description) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            String sql = "INSERT INTO setting(setting_id, type_id, setting_title, setting_value, display_order, status_id, description) \n"
                    + "VALUES (?,?,?,?,?,?,?);";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, type_id);
                preparedStatement.setString(3, title);
                preparedStatement.setString(4, value);
                preparedStatement.setString(5, display_order);
                preparedStatement.setInt(6, status_id);
                preparedStatement.setString(7, description);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
    }

    @Override
    public void updateSetting(Connection connection, int id, int type_id, String title, String value, String display_order, int status_id, String description) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            String sql = "UPDATE setting\n"
                    + "SET type_id = ?, setting_title = ?,setting_value = ?,display_order = ?,status_id = ?,description = ?\n"
                    + "WHERE setting_id = ?";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(7, id);
                preparedStatement.setInt(1, type_id);
                preparedStatement.setString(2, title);
                preparedStatement.setString(3, value);
                preparedStatement.setString(4, display_order);
                preparedStatement.setInt(5, status_id);
                preparedStatement.setString(6, description);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
    }

}
