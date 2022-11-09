/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.dao.impl;

import com.tss.dao.BaseDao;
import com.tss.dao.ScheduleDao;
import com.tss.model.Schedule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ScheduleDaoImpl implements ScheduleDao {

    @Override
    public List<Schedule> getScheduleList(Connection connection, int begin,
            int length, String search, String classFilter)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Schedule> scheduleList = new ArrayList<>();
        if (connection != null) {
            String sql = "select s.*, c.class_code from schedule s join class c\n"
                    + "on s.class_id = c.class_id\n"
                    + "where (room like ? or training_date like ? or c.class_code like ?)\n"
                    + "and s.class_id like ?\n"
                    + "order by training_date asc, slot_id asc\n"
                    + "limit ?, ?";
            Object[] params = { "%" + search + "%", "%" + search + "%", "%" + search + "%",
                    classFilter.equals("") ? "%%" : classFilter, begin, length };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement,
                        resultSet, sql, params);
                while (resultSet.next()) {
                    Schedule schedule = new Schedule();
                    schedule.setScheduleId(resultSet.getInt("schedule_id"));
                    schedule.setClassId(resultSet.getInt("class_id"));
                    schedule.setSlot(resultSet.getInt("slot_id"));
                    schedule.setTrainingDate(resultSet.getDate("training_date"));
                    schedule.setFrom(resultSet.getTime("from_time"));
                    schedule.setTo(resultSet.getTime("to_time"));
                    schedule.setRoom(resultSet.getString("room"));
                    schedule.setClassCode(resultSet.getString("class_code"));
                    scheduleList.add(schedule);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return scheduleList;
    }

    @Override
    public int getScheduleCount(Connection connection, String search, String classFilter)
            throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "select count(*) as count from schedule s join class c\n"
                    + "on s.class_id = c.class_id\n"
                    + "where (room like ? or training_date like ? or c.class_code like ?)\n"
                    + "and s.class_id like ?";
            Object[] params = { "%" + search + "%", "%" + search + "%", "%" + search + "%",
                    classFilter.equals("") ? "%%" : classFilter };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement,
                        resultSet, sql, params);
                if (resultSet.next()) {
                    count = resultSet.getInt("count");
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
    public int update(Connection connection, Schedule schedule) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int execute = 0;
        if (connection != null) {
            String sql = "update schedule set class_id = ?, slot_id = ?,\n"
                    + "training_date = ?, from_time = ?, to_time = ?, room = ?\n"
                    + "where schedule_id = ?";
            Object[] params = { schedule.getClassId(), schedule.getSlot(),
                    schedule.getTrainingDate(), schedule.getFrom(),
                    schedule.getTo(), schedule.getRoom(), schedule.getScheduleId() };
            try {
                execute = BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return execute;
    }

    @Override
    public int add(Connection connection, Schedule schedule) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int execute = 0;
        if (connection != null) {
            String sql = "insert into schedule(class_id, slot_id, training_date,\n"
                    + "from_time, to_time, room)\n"
                    + "values(?, ?, ?, ?, ?, ?)";
            Object[] params = { schedule.getClassId(), schedule.getSlot(),
                    schedule.getTrainingDate(), schedule.getFrom(),
                    schedule.getTo(), schedule.getRoom() };
            try {
                execute = BaseDao.execute(connection, preparedStatement, sql, params);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return execute;
    }

    @Override
    public Schedule getScheduleById(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Schedule schedule = null;
        if (connection != null) {
            String sql = "select * from schedule where schedule_id = ?";
            Object[] params = { id };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement,
                        resultSet, sql, params);
                if (resultSet.next()) {
                    schedule = new Schedule();
                    schedule.setScheduleId(resultSet.getInt("schedule_id"));
                    schedule.setClassId(resultSet.getInt("class_id"));
                    schedule.setSlot(resultSet.getInt("slot_id"));
                    schedule.setTrainingDate(resultSet.getDate("training_date"));
                    schedule.setFrom(resultSet.getTime("from_time"));
                    schedule.setTo(resultSet.getTime("to_time"));
                    schedule.setRoom(resultSet.getString("room"));
                    schedule.setClassCode(resultSet.getString("class_code"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return schedule;
    }

    @Override
    public boolean checkDupSchedule(Connection connection, Schedule schedule) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean flag = false;
        if (connection != null) {
            String sql = "select * from schedule where class_id = ? and slot_id = ?\n"
                    + "and training_date = ? and schedule_id <> ?";
            Object[] params = { schedule.getClassId(), schedule.getSlot(),
                    schedule.getTrainingDate(), schedule.getScheduleId() };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement,
                        resultSet, sql, params);
                if (resultSet.next()) {
                    flag = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return flag;
    }

    @Override
    public int checkAttendance(Connection connection, int scheduleId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            String sql = "SELECT count(*) FROM attendance where schedule_id = ?";
            Object[] params = { scheduleId };
            try {
                resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
                while (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, null);
            }
        }
        return count;
    }
}
