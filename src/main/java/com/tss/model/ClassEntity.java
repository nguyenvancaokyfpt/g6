/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ClassEntity {

    private int id;
    private String classCode;
    private int comboId;
    private int tranierId;
    private int termId;
    private int statusId;
    private String description;

    //DatLT Add
    private User trainer;
    private List<Team> listTeam;
    private List<Trainee> listTrainee;
    private List<Trainee> listWaiting;

    public ClassEntity() {
        listTeam = new ArrayList<>();     
        listTrainee = new ArrayList<>();
        listWaiting = new ArrayList<>();

    }

    public ClassEntity(int id, String classCode, int comboId, int tranierId, int termId, int statusId, String description, User trainer, List<Team> listTeam, List<Trainee> listTrainee, List<Trainee> listWaiting) {
        this.id = id;
        this.classCode = classCode;
        this.comboId = comboId;
        this.tranierId = tranierId;
        this.termId = termId;
        this.statusId = statusId;
        this.description = description;
        this.trainer = trainer;
        this.listTeam = listTeam;
        this.listTrainee = listTrainee;
        this.listWaiting = listWaiting;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public int getComboId() {
        return comboId;
    }

    public void setComboId(int comboId) {
        this.comboId = comboId;
    }

    public int getTranierId() {
        return tranierId;
    }

    public void setTranierId(int tranierId) {
        this.tranierId = tranierId;
    }

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getTrainer() {
        return trainer;
    }

    public void setTrainer(User trainer) {
        this.trainer = trainer;
    }

    public List<Team> getListTeam() {
        return listTeam;
    }

    public void setListTeam(List<Team> listTeam) {
        this.listTeam = listTeam;
    }

    public List<Trainee> getListTrainee() {
        return listTrainee;
    }

    public void setListTrainee(List<Trainee> listTrainee) {
        this.listTrainee = listTrainee;
    }

    public List<Trainee> getListWaiting() {
        return listWaiting;
    }

    public void setListWaiting(List<Trainee> listWaiting) {
        this.listWaiting = listWaiting;
    }

    
}
