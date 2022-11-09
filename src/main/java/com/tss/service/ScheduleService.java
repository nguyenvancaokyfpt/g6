package com.tss.service;

import com.tss.model.Schedule;
import java.util.List;

public interface ScheduleService {

    List<Schedule> getScheduleList(int begin, int length,
            String search, String classFilter);

    int getScheduleCount(String search, String classFilter);

    boolean update(Schedule schedule);

    boolean add(Schedule schedule);

    Schedule getScheduleById(int id);

    boolean checkDupSchedule(Schedule schedule);

    boolean checkAttendance(int scheduleId);
}
