package com.tss.model;

import com.tss.helper.ScheduleHelper;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

public class Schedule {

    private int scheduleId, classId, slot;
    private String title;
    private Date trainingDate;
    private Time from, to;
    private String room, classCode;
    
    public String fmtDate(String x){
        return ScheduleHelper.getStringFromDate(x);
    }

    public Schedule() {
    }

    public Schedule(int scheduleId, int classId, int slot, String title, Date trainingDate, Time from, Time to, String room, String classCode) {
        this.scheduleId = scheduleId;
        this.classId = classId;
        this.slot = slot;
        this.title = title;
        this.trainingDate = trainingDate;
        this.from = from;
        this.to = to;
        this.room = room;
        this.classCode = classCode;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
    }

    public Time getFrom() {
        return from;
    }

    public void setFrom(Time from) {
        this.from = from;
    }

    public Time getTo() {
        return to;
    }

    public void setTo(Time to) {
        this.to = to;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

}
