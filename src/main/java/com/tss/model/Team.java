/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dat Lai
 */
public class Team {

    private int id;
    private Class tClass;
    private String project_code;
    private String topic_code;
    private String topic_name;
    private int status_id;
    private String description;
    private List<Trainee> listTrainee;

    public List<Trainee> getListTrainee() {
        return listTrainee;
    }

    public void setListTrainee(List<Trainee> listTrainee) {
        this.listTrainee = listTrainee;
    }

    public Team() {
        listTrainee = new ArrayList<Trainee>();
    }

    public Team(int id, Class tClass, String project_code, String topic_code, String topic_name, int status_id, String description, List<Trainee> listTrainee) {
        this.id = id;
        this.tClass = tClass;
        this.project_code = project_code;
        this.topic_code = topic_code;
        this.topic_name = topic_name;
        this.status_id = status_id;
        this.description = description;
        this.listTrainee = listTrainee;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Class gettClass() {
        return tClass;
    }

    public void settClass(Class tClass) {
        this.tClass = tClass;
    }

    public String getProject_code() {
        return project_code;
    }

    public void setProject_code(String project_code) {
        this.project_code = project_code;
    }

    public String getTopic_code() {
        return topic_code;
    }

    public void setTopic_code(String topic_code) {
        this.topic_code = topic_code;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
