package com.tss.dao.SubjectImpl;

import com.tss.dao.BaseDao;
import com.tss.dao.Subject.SubjectDao;
import com.tss.model.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        if (connection != null) {
            String sql = "insert into subject(subject_code,subject_name,manager_id,expert_id,status_id,body) values(?,?,?,?,?,?)";
            Object[] params = { subject.getSubjectCode(), subject.getSubjectName(), subject.getManagerId(),
                    subject.getExpertId(), subject.getStatusId(), subject.getBody() };
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
            String sql = "update subject set subject_code = ?,subject_name = ?,manager_id = ?,expert_id = ?,status_id = ?,body = ? where subject_id = ?";
            Object[] params = { subject.getSubjectCode(), subject.getSubjectName(), subject.getManagerId(),
                    subject.getExpertId(), subject.getStatusId(), subject.getBody(), subject.getSubjectId() };
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
    public String getUserNameById(Connection connection, int id) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String name = null;
        if (connection != null) {
            String sql = "select user_name from user where user_id = ?";
            Object[] params = { id };
            try {
                rs = BaseDao.execute(connection, ps, rs, sql, params);
                if (rs.next()) {
                    name = rs.getString("user_name");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, ps, rs);
            }
        }
        return name;
    }

    @Override
    public List<Integer> pages(Connection connection, int PageSize) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Integer> list = new ArrayList<Integer>();
        if (connection != null) {
            String sql = "select count(*) from subject";
            Object[] params = {};
            try {
                rs = BaseDao.execute(connection, ps, rs, sql, params);
                if (rs.next()) {
                    int count = rs.getInt(1);
                    int pages = count / PageSize;
                    if (count % PageSize != 0) {
                        pages+=1;
                    }
                    for (int i = 1; i <= pages; i++) {
                        list.add(i);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, ps, rs);
            }
        }
        return list;
    }

}
