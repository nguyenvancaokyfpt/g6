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
        int updateRows = 0;
        if (connection != null) {
            String sql = "insert into subject(subject_code, subject_name, manager_id, expert_id, status_id, body) values(?,?,?,?,?,?)";
            Object[] params = {subject.getSubjectCode(), subject.getSubjectName(), subject.getManagerId(),
                subject.getExpertId(), subject.getStatusId(), subject.getBody()};
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
    public int changeStatus(Connection connection, int subjectId) throws SQLException {
        PreparedStatement preparedStatement = null;
        int updateRows = 0;
        if (connection != null) {
            Subject subject = findById(connection, subjectId);
            if (subject != null) {
                String sql = "update subject set status_id = ? where subject_id = ?";
                Object[] params = { subject.getStatusId() == 1 ? 0 : 1, subjectId };
                try {
                    updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    BaseDao.closeResource(null, preparedStatement, null);
                }
            }
        }
        return updateRows;
    }

    @Override
    public int update(Connection connection, Subject subject) throws SQLException {
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "update subject set subject_code = ?,subject_name = ?,manager_id = ?,expert_id = ?,status_id = ?,body = ? where subject_id = ?";
            Object[] params = { subject.getSubjectCode(), subject.getSubjectName(), subject.getManagerId(),
                    subject.getExpertId(), subject.getStatusId(), subject.getBody(),
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
    public List<Subject> list(Connection connection, int start, int length, String search, String managerFilter,
            String expertFilter, String statusFilter) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Subject> subjectList = new ArrayList<Subject>();
        if (connection != null) {
            String sql = "select * from subject \n"
                    + "where (subject_code like ? or subject_name like ?) \n"
                    + "and (manager_id like ? and expert_id like ? \n"
                    + "and status_id like ?) order by subject_id desc limit ?, ?";
            Object[] params = { "%" + search + "%", "%" + search + "%", managerFilter.equals("") ? "%%" : managerFilter,
                    expertFilter.equals("") ? "%%" : expertFilter, "%" + statusFilter + "%", start, length };
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
                    subjectList.add(subject);
                }
            } catch (SQLException e) {
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
    public int countAll(Connection connection, String search, String managerFilter, String expertFilter,
            String statusFilter) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "select count(*) as count from subject \n"
                    + "where (subject_code like ? or subject_name like ?) \n"
                    + "and (manager_id like ? and expert_id like ? \n"
                    + "and status_id like ?)";
            Object[] params = { "%" + search + "%", "%" + search + "%", managerFilter.equals("") ? "%%" : managerFilter,
                    expertFilter.equals("") ? "%%" : expertFilter, "%" + statusFilter + "%" };
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
    public List<Subject> findAllOfManager(Connection connection, int managerId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Subject> subjectList = new ArrayList<Subject>();
        if (connection != null) {
            String sql = "select * from subject where 1 = 1";
            if (!checkAdmin(connection, managerId)) {
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

    @Override
    public List<Subject> subjectByManager(Connection connection, int managerId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Subject> subjectList = new ArrayList<Subject>();
        if (connection != null) {
            String sql = "select * from subject where manager_id = ?";
            Object[] params = { managerId };
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
                    subjectList.add(subject);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return subjectList;
    }

}
