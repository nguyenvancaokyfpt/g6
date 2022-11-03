/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.model;

/**
 *
 * @author msi
 */
public class AnhPTSchedule {
    private int schedule_id;
    private int class_id;
    private int slot_id;
    private String title;
    private String training_date;
    private String from_time;
    private String to_time;
    private String room;

    public AnhPTSchedule() {
    }

    public AnhPTSchedule(int schedule_id, int class_id, int slot_id, String title, String training_date, String from_time, String to_time, String room) {
        this.schedule_id = schedule_id;
        this.class_id = class_id;
        this.slot_id = slot_id;
        this.title = title;
        this.training_date = training_date;
        this.from_time = from_time;
        this.to_time = to_time;
        this.room = room;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTraining_date() {
        return training_date;
    }

    public void setTraining_date(String training_date) {
        this.training_date = training_date;
    }

    public String getFrom_time() {
        return from_time;
    }

    public void setFrom_time(String from_time) {
        this.from_time = from_time;
    }

    public String getTo_time() {
        return to_time;
    }

    public void setTo_time(String to_time) {
        this.to_time = to_time;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "AnhPTSchedule{" + "schedule_id=" + schedule_id + ", class_id=" + class_id + ", slot_id=" + slot_id + ", title=" + title + ", training_date=" + training_date + ", from_time=" + from_time + ", to_time=" + to_time + ", room=" + room + '}';
    }
    
}
