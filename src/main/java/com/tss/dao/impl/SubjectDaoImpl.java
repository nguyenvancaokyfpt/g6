package com.tss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.dao.BaseDao;
import com.tss.dao.SubjectDao;
import com.tss.model.Subject;
import com.tss.model.system.Role;

public class SubjectDaoImpl implements SubjectDao {

    @Override
    public List<Subject> List(Connection connection, int currentPageNo,
            int PageSize) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Subject> subjectList = new ArrayList<Subject>();
        if (connection != null) {
            String sql = "select * from subject limit ?, ?";
            Object[] params = { currentPageNo, PageSize };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);

                while (resultSet.next()) {
                    Subject subject = new Subject();
                    subject.setSubjectId(resultSet.getInt("subject_id"));
                    subject.setSubjectCode(resultSet.getString("subject_code"));
                    subject.setSubjectName(resultSet.getString("subject_name"));
                    subject.setManagerId(resultSet.getInt("manager_id"));
                    subject.setExpertId(resultSet.getInt("expert_id"));
                    subject.setStatusId(resultSet.getInt("status_id"));
                    subject.setBody(resultSet.getString("body"));
                    subject.setImgSrc(resultSet.getString("img_src"));
                    subjectList.add(subject);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return subjectList;
    }

    @Override
    public int add(Connection connection, Subject subject) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "insert into subject(subject_code,subject_name,manager_id,expert_id,status_id,body,img_src) values(?,?,?,?,?,?,?)";
            Object[] params = { subject.getSubjectCode(), subject.getSubjectName(), subject.getManagerId(),
                    subject.getExpertId(), subject.getStatusId(), subject.getBody(), subject.getImgSrc() };
            try {
                int updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
                if (updateRows > 0) {
                    return updateRows;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
        return 0;
    }

    @Override
    public int inactive(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "update subject set status_id = 0 where subject_id = ?";
            Object[] params = { id };
            try {
                int updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
                if (updateRows > 0) {
                    return updateRows;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
        return 0;
    }

    @Override
    public int active(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "update subject set status_id = 1 where subject_id = ?";
            Object[] params = { id };
            try {
                int updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
                if (updateRows > 0) {
                    return updateRows;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
        return 0;
    }

    @Override
    public int modify(Connection connection, Subject subject) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "update subject set subject_code = ?,subject_name = ?,manager_id = ?,expert_id = ?,status_id = ?,body = ?,img_src = ? where subject_id = ?";
            Object[] params = { subject.getSubjectCode(), subject.getSubjectName(), subject.getManagerId(),
                    subject.getExpertId(), subject.getStatusId(), subject.getBody(), subject.getImgSrc(),
                    subject.getSubjectId() };
            try {
                int updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
                if (updateRows > 0) {
                    return updateRows;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
        return 0;
    }

    @Override
    public Subject findById(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Subject subject = new Subject();
        if (connection != null) {
            String sql = "select * from subject where subject_id = ?";
            Object[] params = { id };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    subject.setSubjectId(resultSet.getInt("subject_id"));
                    subject.setSubjectCode(resultSet.getString("subject_code"));
                    subject.setSubjectName(resultSet.getString("subject_name"));
                    subject.setManagerId(resultSet.getInt("manager_id"));
                    subject.setExpertId(resultSet.getInt("expert_id"));
                    subject.setStatusId(resultSet.getInt("status_id"));
                    subject.setBody(resultSet.getString("body"));
                    subject.setImgSrc(resultSet.getString("img_src"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return subject;
    }

    @Override
    public List<Subject> findAll(Connection connection, int start, int length, String search) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Subject> subjectList = new ArrayList<Subject>();
        if (connection != null) {
            String sql = "select * from subject where subject_code like ? or subject_name like ? limit ?, ?";
            Object[] params = { "%" + search + "%", "%" + search + "%", start, length };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    Subject subject = new Subject();
                    subject.setSubjectId(resultSet.getInt("subject_id"));
                    subject.setSubjectCode(resultSet.getString("subject_code"));
                    subject.setSubjectName(resultSet.getString("subject_name"));
                    subject.setManagerId(resultSet.getInt("manager_id"));
                    subject.setExpertId(resultSet.getInt("expert_id"));
                    subject.setStatusId(resultSet.getInt("status_id"));
                    subject.setBody(resultSet.getString("body"));
                    subject.setImgSrc(resultSet.getString("img_src"));
                    subjectList.add(subject);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return subjectList;
    }

    @Override
    public List<Subject> findAll(Connection connection, int start, int length, String search, String filterStatus)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Subject> subjectList = new ArrayList<Subject>();
        if (connection != null) {
            String sql = "select * from subject where (subject_code like ? or subject_name like ?) and status_id = ? limit ?, ?";
            Object[] params = { "%" + search + "%", "%" + search + "%", filterStatus, start, length };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    Subject subject = new Subject();
                    subject.setSubjectId(resultSet.getInt("subject_id"));
                    subject.setSubjectCode(resultSet.getString("subject_code"));
                    subject.setSubjectName(resultSet.getString("subject_name"));
                    subject.setManagerId(resultSet.getInt("manager_id"));
                    subject.setExpertId(resultSet.getInt("expert_id"));
                    subject.setStatusId(resultSet.getInt("status_id"));
                    subject.setBody(resultSet.getString("body"));
                    subject.setImgSrc(resultSet.getString("img_src"));
                    subjectList.add(subject);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return subjectList;
    }

    @Override
    public int countAll(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "select count(*) from subject";
            Object[] params = {};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return count;
    }

    @Override
    public int countAll(Connection connection, String search) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "select count(*) from subject where subject_code like ? or subject_name like ?";
            Object[] params = { "%" + search + "%", "%" + search + "%" };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return count;
    }

    @Override
    public int countAll(Connection connection, String search, String filterStatus) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "select count(*) from subject where (subject_code like ? or subject_name like ?) and status_id = ?";
            Object[] params = { "%" + search + "%", "%" + search + "%", filterStatus };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return count;
    }


    @Override
     public List<Subject> findAllOfManager(Connection connection, int managerId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Subject> subjectList = new ArrayList<Subject>();
        if (connection != null) {
            String sql = "select * from subject where 1 = 1";
            if(!checkAdmin(connection, managerId)) {
                System.out.println("not admin");
                sql += " AND manager_id = " + managerId;
            }
            Object[] params = {};
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    Subject subject = new Subject();
                    subject.setSubjectId(resultSet.getInt("subject_id"));
                    subject.setSubjectCode(resultSet.getString("subject_code"));
                    subject.setSubjectName(resultSet.getString("subject_name"));
                    subject.setManagerId(resultSet.getInt("manager_id"));
                    subject.setExpertId(resultSet.getInt("expert_id"));
                    subject.setStatusId(resultSet.getInt("status_id"));
                    subject.setBody(resultSet.getString("body"));
                    subject.setImgSrc(resultSet.getString("img_src"));
                    subjectList.add(subject);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return subjectList;
    }

    public static void main(String[] args) throws SQLException {
        SubjectDaoImpl s = new SubjectDaoImpl();
        // System.out.println(s.findAllOfManager(BaseDao.getConnection(), 70).size());
    }
    public boolean checkAdmin(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Role role = new Role();
        if (connection != null) {
            String sql = "SELECT s.setting_id,s.setting_title FROM `user_role` u inner JOIN setting s on u.setting_id = s.setting_id  where u.user_id = ?";
            Object[] params = { id };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    role.setId(resultSet.getInt("setting_id"));
                    role.setTitle(resultSet.getString("setting_title"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
            
        }
        return role.getId() == 21;
    }

}
