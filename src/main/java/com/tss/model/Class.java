/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.model;

/**
 *
 * @author msi
 */
public class Class {

    private int class_id;
    private String class_code;
    private int combo_id;
    private int trainer_id;
    private int term_id;
    private int status_id;
    private String description;
    private String termString;
    private String trainerString;
    private String supporterString;
    private String statusString;

    public Class() {
    }

    public Class(int class_id, String class_code, int combo_id, int trainer_id, int term_id, int status_id, String description, String termString, String trainerString, String supporterString, String statusString) {
        this.class_id = class_id;
        this.class_code = class_code;
        this.combo_id = combo_id;
        this.trainer_id = trainer_id;
        this.term_id = term_id;
        this.status_id = status_id;
        this.description = description;
        this.termString = termString;
        this.trainerString = trainerString;
        this.supporterString = supporterString;
        this.statusString = statusString;
    }

    public Class(int trainer_id, String trainerString) {
        this.trainer_id = trainer_id;
        this.trainerString = trainerString;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public int getCombo_id() {
        return combo_id;
    }

    public void setCombo_id(int combo_id) {
        this.combo_id = combo_id;
    }

    public int getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }

    public int getTerm_id() {
        return term_id;
    }

    public void setTerm_id(int term_id) {
        this.term_id = term_id;
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

    public String getTrainerString() {
        return trainerString;
    }

    public void setTrainerString(String trainerString) {
        this.trainerString = trainerString;
    }

    public String getTermString() {
        return termString;
    }

    public void setTermString(String termString) {
        this.termString = termString;
    }

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }

    public String getSupporterString() {
        return supporterString;
    }

    public void setSupporterString(String supporterString) {
        this.supporterString = supporterString;
    }

    @Override
    public String toString() {
        return "Class{" + "class_id=" + class_id + ", class_code=" + class_code + ", combo_id=" + combo_id + ", trainer_id=" + trainer_id + ", term_id=" + term_id + ", status_id=" + status_id + ", description=" + description + ", trainerString=" + trainerString + ", termString=" + termString + ", statusString=" + statusString + ", supporterString=" + supporterString + '}';
    }

}
