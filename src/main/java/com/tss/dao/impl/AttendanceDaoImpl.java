package com.tss.dao.impl;

import com.tss.dao.BaseDao;
import com.tss.model.AnhPTClassUser;
import com.tss.model.AnhPTSchedule;
import com.tss.model.Attendance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author msi
 */
public class AttendanceDaoImpl {

    public List<Attendance> findAllAttendance(Connection connection, int class_id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Attendance> attendanceList = new ArrayList<>();
        if (connection != null) {
            String sql = "select class.class_code, user.full_name,user.user_id, DATE_FORMAT(schedule.training_date, \"%d/%m/%Y\") as training_date,schedule.slot_id,status.status_title, attendance.comment \n"
                    + "from attendance \n"
                    + "inner join class on class.class_id = attendance.class_id\n"
                    + "inner join user on user.user_id = attendance.trainer_id\n"
                    + "inner join schedule on schedule.schedule_id = attendance.schedule_id\n"
                    + "inner join status on status.status_id = attendance.status_id where attendance.class_id = ?";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, class_id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Attendance attendance = new Attendance();
                    attendance.setClass_code(resultSet.getString("class_code"));
                    attendance.setFull_name(resultSet.getString("full_name"));
                    attendance.setTraining_date(resultSet.getString("training_date"));
                    attendance.setSlot_id(resultSet.getInt("slot_id"));
                    attendance.setTrainer_id(resultSet.getInt("user_id"));
                    attendance.setStatus(resultSet.getString("status_title"));
                    attendance.setComment(resultSet.getString("comment"));
                    attendanceList.add(attendance);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return attendanceList;
    }

    public List<Attendance> findAttendanceByUser(Connection connection, int class_id, int user_id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Attendance> attendanceList = new ArrayList<>();
        if (connection != null) {
            String sql = "select class.class_code, user.full_name,user.user_id, DATE_FORMAT(schedule.training_date, \"%d/%m/%Y\") as training_date,schedule.slot_id,schedule.schedule_id,status.status_title,attendance.comment\n"
                    + "from attendance \n"
                    + "inner join class on class.class_id = attendance.class_id\n"
                    + "inner join user on user.user_id = attendance.trainer_id\n"
                    + "inner join schedule on schedule.schedule_id = attendance.schedule_id\n"
                    + "inner join status on status.status_id = attendance.status_id\n"
                    + "where attendance.class_id = ? and attendance.trainer_id= ?;";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, class_id);
                preparedStatement.setInt(2, user_id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Attendance attendance = new Attendance();
                    attendance.setClass_code(resultSet.getString("class_code"));
                    attendance.setFull_name(resultSet.getString("full_name"));
                    attendance.setTraining_date(resultSet.getString("training_date"));
                    attendance.setSlot_id(resultSet.getInt("slot_id"));
                    attendance.setSchedule_id(resultSet.getInt("schedule_id"));
                    attendance.setTrainer_id(resultSet.getInt("user_id"));
                    attendance.setStatus(resultSet.getString("status_title"));
                    attendance.setComment(resultSet.getString("comment"));
                    attendanceList.add(attendance);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return attendanceList;
    }
    
    public List<Attendance> findAttendanceBySchedule(Connection connection, int schedule_id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Attendance> attendanceList = new ArrayList<>();
        if (connection != null) {
            String sql = "select class.class_code, user.full_name,user.user_id, DATE_FORMAT(schedule.training_date, \"%d/%m/%Y\") as training_date,schedule.slot_id,schedule.schedule_id,status.status_title,attendance.comment\n"
                    + "from attendance \n"
                    + "inner join class on class.class_id = attendance.class_id\n"
                    + "inner join user on user.user_id = attendance.trainer_id\n"
                    + "inner join schedule on schedule.schedule_id = attendance.schedule_id\n"
                    + "inner join status on status.status_id = attendance.status_id\n"
                    + "where attendance.schedule_id = ?;";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, schedule_id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Attendance attendance = new Attendance();
                    attendance.setClass_code(resultSet.getString("class_code"));
                    attendance.setFull_name(resultSet.getString("full_name"));
                    attendance.setTraining_date(resultSet.getString("training_date"));
                    attendance.setSlot_id(resultSet.getInt("slot_id"));
                    attendance.setSchedule_id(resultSet.getInt("schedule_id"));
                    attendance.setTrainer_id(resultSet.getInt("user_id"));
                    attendance.setStatus(resultSet.getString("status_title"));
                    attendance.setComment(resultSet.getString("comment"));
                    attendanceList.add(attendance);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return attendanceList;
    }

    public List<AnhPTSchedule> findAllSchedule(Connection connection, int class_id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<AnhPTSchedule> scheduleList = new ArrayList<AnhPTSchedule>();
        if (connection != null) {
            String sql = "select schedule_id,class_id,slot_id,title,DATE_FORMAT(schedule.training_date, \"%d/%m/%Y\") "
                    + "as training_date,TIME_FORMAT(from_time, \"%h:%i\") as from_time,TIME_FORMAT(to_time, \"%h:%i\") as to_time,room "
                    + "from schedule where class_id = ?;";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, class_id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    AnhPTSchedule schedule = new AnhPTSchedule();
                    schedule.setSchedule_id(resultSet.getInt("schedule_id"));
                    schedule.setClass_id(resultSet.getInt("class_id"));
                    schedule.setSlot_id(resultSet.getInt("slot_id"));
                    schedule.setTitle(resultSet.getString("title"));
                    schedule.setTraining_date(resultSet.getString("training_date"));
                    schedule.setFrom_time(resultSet.getString("from_time"));
                    schedule.setTo_time(resultSet.getString("to_time"));
                    schedule.setRoom(resultSet.getString("room"));
                    scheduleList.add(schedule);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return scheduleList;
    }

    public List<AnhPTClassUser> findAllClassUser(Connection connection, int class_id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<AnhPTClassUser> userList = new ArrayList<>();
        if (connection != null) {
            String sql = "select class_user.user_id,class_user.class_id,\n"
                    + "user.full_name,\n"
                    + "class.class_code,\n"
                    + "subject.subject_code,\n"
                    + "setting.setting_title as term \n"
                    + "from \n"
                    + "class_user inner join user on class_user.user_id = user.user_id\n"
                    + "inner join class on class_user.class_id = class.class_id\n"
                    + "inner join subject on class.subject = subject.subject_id\n"
                    + "inner join setting on class.term_id = setting.setting_id\n"
                    + "where class.class_id = ?";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, class_id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    AnhPTClassUser user = new AnhPTClassUser();
                    user.setUser_id(resultSet.getInt("user_id"));
                    user.setClass_id(resultSet.getInt("class_id"));
                    user.setFull_name(resultSet.getString("full_name"));
                    user.setClass_code(resultSet.getString("class_code"));
                    user.setSubject_code(resultSet.getString("subject_code"));
                    user.setTerm(resultSet.getString("term"));
                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
        return userList;
    }

    public void takeAttendance(Connection connection, int class_id, int trainer_id, int schedule_id, int status_id, String comment) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            String sql = "INSERT INTO `attendance`(class_id,trainer_id,schedule_id,status_id,comment) VALUES (?,?,?,?,?);";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, class_id);
                preparedStatement.setInt(2, trainer_id);
                preparedStatement.setInt(3, schedule_id);
                preparedStatement.setInt(4, status_id);
                preparedStatement.setString(5, comment);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
    }

    public void changeAttendance(Connection connection, int class_id, int trainer_id, int schedule_id, int status_id, String comment) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            String sql = "UPDATE attendance SET status_id = ?, comment = ? WHERE class_id = ? and trainer_id = ? and schedule_id = ?";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(3, class_id);
                preparedStatement.setInt(4, trainer_id);
                preparedStatement.setInt(5, schedule_id);
                preparedStatement.setInt(1, status_id);
                preparedStatement.setString(2, comment);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(null, preparedStatement, resultSet);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        AttendanceDaoImpl dao = new AttendanceDaoImpl();
        Connection connection = BaseDao.getConnection();
        List<Attendance> AttendanceList = new ArrayList<Attendance>();
        List<AnhPTSchedule> ScheduleList = new ArrayList<AnhPTSchedule>();
        AttendanceList = dao.findAllAttendance(connection, 1);
        for (Attendance attendance : AttendanceList) {
            System.out.println(attendance.toString());
        }
    }
}
