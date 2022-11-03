/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.model;

/**
 *
 * @author msi
 */
public class Attendance {

    private int class_id;
    private int trainer_id;
    private int schedule_id;
    private int status_id;
    private String comment;
    private String class_code;
    private String full_name;
    private String training_date;
    private int slot_id;
    private String status;

    public Attendance() {
    }

    public Attendance(int class_id, int trainer_id, int schedule_id, int status_id, String comment, String class_code, String full_name, String training_date, int slot_id, String status) {
        this.class_id = class_id;
        this.trainer_id = trainer_id;
        this.schedule_id = schedule_id;
        this.status_id = status_id;
        this.comment = comment;
        this.class_code = class_code;
        this.full_name = full_name;
        this.training_date = training_date;
        this.slot_id = slot_id;
        this.status = status;
    }

    public Attendance(int class_id, int trainer_id, int schedule_id, int status_id, String comment) {
        this.class_id = class_id;
        this.trainer_id = trainer_id;
        this.schedule_id = schedule_id;
        this.status_id = status_id;
        this.comment = comment;
    }

    public Attendance(String comment, String class_code, String full_name, String training_date, int slot_id, String status,int trainer_id) {
        this.comment = comment;
        this.class_code = class_code;
        this.full_name = full_name;
        this.training_date = training_date;
        this.slot_id = slot_id;
        this.status = status;
        this.trainer_id = trainer_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getTraining_date() {
        return training_date;
    }

    public void setTraining_date(String training_date) {
        this.training_date = training_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    @Override
    public String toString() {
        return "Attendance{" + "class_id=" + class_id + ", trainer_id=" + trainer_id + ", schedule_id=" + schedule_id + ", status_id=" + status_id + ", comment=" + comment + ", class_code=" + class_code + ", full_name=" + full_name + ", training_date=" + training_date + ", slot_id=" + slot_id + ", status=" + status + '}';
    }

}
