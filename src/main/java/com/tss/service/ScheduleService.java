package com.tss.service;

import com.tss.model.Schedule;
import java.util.List;

public interface ScheduleService {

    List<Schedule> getScheduleList(String begin, String end,
            String search, String classFilter);

    boolean update(Schedule schedule);

    boolean add(Schedule schedule);

    Schedule getScheduleById(int id);
    
    boolean checkDupSchedule(Schedule schedule);
    
    boolean checkAttendance(int scheduleId);
}
