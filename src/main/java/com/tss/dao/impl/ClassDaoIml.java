/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.dao.impl;

/**
 *
 * @author msi
 */
import com.tss.dao.BaseDao;
import com.tss.dao.ClassDao;
import com.tss.model.Class;
import com.tss.model.system.Setting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDaoIml implements ClassDao {

    @Override
    public List<Class> listSearchFilter(Connection connection, int offset, String searchword, String term, String status, String order, String dir) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Class> classList = new ArrayList<>();
        if (connection != null) {
            String sql = "select class_id,class_code,combo_id,trainer_id,term_id,class.status_id,\n"
                    + "class.description,a.full_name,b.full_name,setting_title,status.status_title\n"
                    + "from class\n"
                    + "inner join user_role aa on aa.user_id = class.trainer_id\n"
                    + "inner join user_role bb on bb.user_id = class.combo_id\n"
                    + "inner join user a on a.user_id = aa.user_id\n"
                    + "inner join user b on b.user_id = bb.user_id\n"
                    + "inner join status on class.status_id = status.status_id\n"
                    + "inner join setting on class.term_id = setting.setting_id\n"
                    + "where (class.class_code like ?) \n"
                    + "and setting_title like ?\n"
                    + "and status.status_title like ?\n"
                    + "order by " + order + " " + dir + " limit ?,5;";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + searchword + "%");
                preparedStatement.setString(2, "%" + term + "%");
                preparedStatement.setString(3, "" + status + "%");
                preparedStatement.setInt(4, offset);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    classList.add(new Class(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getInt(4),
                            resultSet.getInt(5),
                            resultSet.getInt(6),
                            resultSet.getString(7),
                            resultSet.getString(10),
                            resultSet.getString(8),
                            resultSet.getString(9),
                            resultSet.getString(11)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return classList;
    }

    @Override
    public Class findById(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Class> classList = new ArrayList<>();
        Class classDetail = new Class();
        if (connection != null) {
            String sql = "select class_id,class_code,combo_id,trainer_id,term_id,class.status_id,\n"
                    + "class.description,a.full_name,b.full_name,setting_title,status.status_title\n"
                    + "from class\n"
                    + "inner join user_role aa on aa.user_id = class.trainer_id\n"
                    + "inner join user_role bb on bb.user_id = class.combo_id\n"
                    + "inner join user a on a.user_id = aa.user_id\n"
                    + "inner join user b on b.user_id = bb.user_id\n"
                    + "inner join status on class.status_id = status.status_id\n"
                    + "inner join setting on class.term_id = setting.setting_id\n"
                    + "where class_id = ?;";

            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    classDetail.setClass_id(resultSet.getInt(1));
                    classDetail.setClass_code(resultSet.getString(2));
                    classDetail.setCombo_id(resultSet.getInt(3));
                    classDetail.setTrainer_id(resultSet.getInt(4));
                    classDetail.setTerm_id(resultSet.getInt(5));
                    classDetail.setStatus_id(resultSet.getInt(6));
                    classDetail.setDescription(resultSet.getString(7));
                    classDetail.setTrainerString(resultSet.getString(8));
                    classDetail.setSupporterString(resultSet.getString(9));
                    classDetail.setTermString(resultSet.getString(10));
                    classDetail.setStatusString(resultSet.getString(11));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return classDetail;
    }

    @Override
    public int countSearchFilter(Connection connection, String searchword, String term, String status) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int totalSetting = 0;
        if (connection != null) {
            String sql = "select count(*) from class\n"
                    + "inner join user_role aa on aa.user_id = class.trainer_id\n"
                    + "inner join user_role bb on bb.user_id = class.combo_id\n"
                    + "inner join user a on a.user_id = aa.user_id\n"
                    + "inner join user b on b.user_id = bb.user_id\n"
                    + "inner join status on class.status_id = status.status_id\n"
                    + "inner join setting on class.term_id = setting.setting_id\n"
                    + "where (class.class_code like ?) \n"
                    + "and setting_title like ?\n"
                    + "and status.status_title like ?;";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + searchword + "%");
                preparedStatement.setString(2, "%" + term + "%");
                preparedStatement.setString(3, "" + status + "%");
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
    public void add(Connection connection, String code, int supporter_id, int trainer_id, int term_id, int status_id, String description) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            String sql = "INSERT INTO class(class_code,combo_id,trainer_id,term_id,status_id,description) VALUES (?,?,?,?,?,?);";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, code);
                preparedStatement.setInt(2, supporter_id);
                preparedStatement.setInt(3, trainer_id);
                preparedStatement.setInt(4, term_id);
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

    @Override
    public void edit(Connection connection, int class_id, String code, int supporter_id, int trainer_id, int term_id, int status_id, String description) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            String sql = "UPDATE class SET class_code = ?, combo_id = ?,trainer_id = ?,term_id = ?,status_id = ?,description = ? WHERE class_id = ?;";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, code);
                preparedStatement.setInt(2, supporter_id);
                preparedStatement.setInt(3, trainer_id);
                preparedStatement.setInt(4, term_id);
                preparedStatement.setInt(5, status_id);
                preparedStatement.setString(6, description);
                preparedStatement.setInt(7, class_id);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
    }

    @Override
    public void changeStatus(Connection connection, int id, int status_id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            String sql = "update class set status_id = ? where class_id = ?;";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(2, id);
                preparedStatement.setInt(1, status_id);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
    }

    @Override
    public List<Class> listTrainer(Connection connection, int role) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Class> classList = new ArrayList<>();
        if (connection != null) {
            String sql = "select user.user_id,full_name,user_role.setting_id,setting_title\n"
                    + "from user inner join user_role on user.user_id = user_role.user_id\n"
                    + "inner join setting on user_role.setting_id = setting.setting_id\n"
                    + "where user_role.setting_id = ? and user.status_id = 1";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, role);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    classList.add(new Class(resultSet.getInt(1),
                            resultSet.getString(2)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return classList;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = BaseDao.getConnection();
        ClassDaoIml dao = new ClassDaoIml();
        List<Class> list = new ArrayList<>();
        list = dao.listSearchFilter(connection, 0, "", "", "", "class_code", "asc");
        Class aclass = dao.findById(connection, 1);
        //list = dao.listTrainer(connection, 24);
        for (Class class1 : list) {

        }
        System.out.println(aclass.toString());

    }
}
