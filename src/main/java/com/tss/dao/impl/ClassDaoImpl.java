package com.tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.ClassDao;
import com.tss.helper.DebugHelper;
import com.tss.model.ClassAnhPT;
import com.tss.model.ClassEntity;
import com.tss.model.Classroom;
import com.tss.model.User;

public class ClassDaoImpl implements ClassDao {

    @Override
    public List<Classroom> findAllClassroom(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Classroom> classrooms = new ArrayList<Classroom>();
        if (connection != null) {
            String sql = "select class_id, class_code, combo_id, trainer_id, term_id, status.status_id, status.status_title, description from class, status where class.status_id = status.status_id;";
            Object[] params = {};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    Classroom classroom = new Classroom();
                    classroom.setClassId(resultSet.getInt("class_id"));
                    classroom.setClassCode(resultSet.getString("class_code"));
                    classroom.setComboId(resultSet.getInt("combo_id"));
                    classroom.setTrainerId(resultSet.getInt("trainer_id"));
                    classroom.setTermId(resultSet.getInt("term_id"));
                    classroom.setStatusId(resultSet.getInt("status_id"));
                    classroom.setStatusTitle(resultSet.getString("status_title"));
                    classroom.setDescription(resultSet.getString("description"));
                    classrooms.add(classroom);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return classrooms;
    }

    @Override
    public List<Classroom> findClassroomByStudent(Connection connection, int userId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Classroom> classrooms = new ArrayList<Classroom>();
        if (connection != null) {
            String sql = "select class.class_id, class.class_code, class.combo_id, class.trainer_id, class.term_id, class.status_id, status.status_title, class.description from class, status, class_user where class.status_id = status.status_id and class.class_id = class_user.class_id and class_user.user_id = ?;";
            Object[] params = { userId };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    Classroom classroom = new Classroom();
                    classroom.setClassId(resultSet.getInt("class_id"));
                    classroom.setClassCode(resultSet.getString("class_code"));
                    classroom.setComboId(resultSet.getInt("combo_id"));
                    classroom.setTrainerId(resultSet.getInt("trainer_id"));
                    classroom.setTermId(resultSet.getInt("term_id"));
                    classroom.setStatusId(resultSet.getInt("status_id"));
                    classroom.setStatusTitle(resultSet.getString("status_title"));
                    classroom.setDescription(resultSet.getString("description"));
                    classrooms.add(classroom);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return classrooms;
    }

    @Override
    public List<Classroom> findClassroomByTeacher(Connection connection, int userId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Classroom> classrooms = new ArrayList<Classroom>();
        if (connection != null) {
            String sql = "select class.class_id, class.class_code, class.combo_id, class.trainer_id, class.term_id, class.status_id, status.status_title, class.description from class, status where class.status_id = status.status_id and trainer_id = ?;";
            Object[] params = { userId };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    Classroom classroom = new Classroom();
                    classroom.setClassId(resultSet.getInt("class_id"));
                    classroom.setClassCode(resultSet.getString("class_code"));
                    classroom.setComboId(resultSet.getInt("combo_id"));
                    classroom.setTrainerId(resultSet.getInt("trainer_id"));
                    classroom.setTermId(resultSet.getInt("term_id"));
                    classroom.setStatusId(resultSet.getInt("status_id"));
                    classroom.setStatusTitle(resultSet.getString("status_title"));
                    classroom.setDescription(resultSet.getString("description"));
                    classrooms.add(classroom);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return classrooms;
    }

    @Override
    public java.util.List<ClassEntity> List(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ClassEntity> classEntitys = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT \n"
                    + "    c.class_id AS id, c.class_code AS classCode\n"
                    + "FROM\n"
                    + "    class AS c\n"
                    + "        LEFT JOIN\n"
                    + "    milestone AS m ON m.class_id = c.class_id;";
            // Search and Paging
            Object[] params = {};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);

                while (resultSet.next()) {
                    ClassEntity classEntity = new ClassEntity();
                    classEntity.setId(resultSet.getInt("id"));
                    classEntity.setClassCode(resultSet.getString("classCode"));
                    classEntitys.add(classEntity);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return classEntitys;
    }

    @Override
    public List<ClassAnhPT> listSearchFilter(Connection connection, int offset, String searchword, String term,
            String status, String order, String dir) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ClassAnhPT> classList = new ArrayList<>();
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
                    classList.add(new ClassAnhPT(resultSet.getInt(1),
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
    public ClassAnhPT findById(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ClassAnhPT> classList = new ArrayList<>();
        ClassAnhPT classDetail = new ClassAnhPT();
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
    public int countSearchFilter(Connection connection, String searchword, String term, String status)
            throws SQLException {
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
    public void add(Connection connection, String code, int supporter_id, int trainer_id, int term_id, int status_id,
            String description) throws SQLException {
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
    public void edit(Connection connection, int class_id, String code, int supporter_id, int trainer_id, int term_id,
            int status_id, String description) throws SQLException {
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
    public List<ClassAnhPT> listTrainer(Connection connection, int role) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ClassAnhPT> classList = new ArrayList<>();
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
                    classList.add(new ClassAnhPT(resultSet.getInt(1),
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

    @Override
    public void grantTraineeToClass(Connection connection, User user, int classId, float grade) throws SQLException {
        PreparedStatement preparedStatement = null;
        boolean flag = false;
        if (connection != null) {
            String sql = "insert into class_user (class_id,user_id,grade) values (?,?,?);";
            Object[] params = { classId, user.getUserId(), grade };
            try {
                int updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
                if (updateRows > 0) {
                    flag = true;
                }
            } catch (SQLException e) {
                DebugHelper.print(e);
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
    }

    @Override
    public Classroom findClassByIdK(Connection connection, int classId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Classroom classroom = null;
        if (connection != null) {
            String sql = "select * from class where class_id = ?;";
            Object[] params = { classId };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                if (resultSet.next()) {
                    classroom = new Classroom();
                    classroom.setClassId(resultSet.getInt("class_id"));
                    classroom.setClassCode(resultSet.getString("class_code"));
                    classroom.setComboId(resultSet.getInt("combo_id"));
                    classroom.setTrainerId(resultSet.getInt("trainer_id"));
                    classroom.setTermId(resultSet.getInt("term_id"));
                    classroom.setStatusId(resultSet.getInt("status_id"));
                    classroom.setDescription(resultSet.getString("description"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return classroom;
    }

    public List<ClassEntity> ListCbx(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ClassEntity> classEntitys = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT \n" +
                    "    class_id, class_code\n" +
                    "FROM\n" +
                    "    class";
            // Search and Paging
            Object[] params = {};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);

                while (resultSet.next()) {
                    ClassEntity classEntity = new ClassEntity();
                    classEntity.setId(resultSet.getInt("class_id"));
                    classEntity.setClassCode(resultSet.getString("class_code"));
                    classEntitys.add(classEntity);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return classEntitys;
    }

    public ClassEntity findClassById(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ClassEntity classDetail = new ClassEntity();
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
                    classDetail.setId(resultSet.getInt(1));
                    classDetail.setClassCode(resultSet.getString(2));
                    classDetail.setComboId(resultSet.getInt(3));
                    classDetail.setTranierId(resultSet.getInt(4));
                    classDetail.setTermId(resultSet.getInt(5));
                    classDetail.setStatusId(resultSet.getInt(6));
                    classDetail.setDescription(resultSet.getString(7));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return classDetail;
    }
}
