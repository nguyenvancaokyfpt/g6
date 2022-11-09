package com.tss.dao;

import com.tss.model.Schedule;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ScheduleDao {

    List<Schedule> getScheduleList(Connection connection, int begin, int length,
            String search, String classFilter)
            throws SQLException;

    int getScheduleCount(Connection connection, String search, String classFilter) throws SQLException;

    int update(Connection connection, Schedule schedule) throws SQLException;

    int add(Connection connection, Schedule schedule) throws SQLException;

    Schedule getScheduleById(Connection connection, int id) throws SQLException;

    boolean checkDupSchedule(Connection connection, Schedule schedule) throws SQLException;

    int checkAttendance(Connection connection, int scheduleId) throws SQLException;
}
