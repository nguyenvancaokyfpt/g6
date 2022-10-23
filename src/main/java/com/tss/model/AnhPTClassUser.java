/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.model;

/**
 *
 * @author msi
 */
public class AnhPTClassUser {
    private int user_id;
    private int class_id;
    private String full_name;
    private String class_code;
    private String subject_code;
    private String term;

    public AnhPTClassUser() {
    }

    public AnhPTClassUser(int user_id, int class_id, String full_name, String class_code, String subject_code, String term) {
        this.user_id = user_id;
        this.class_id = class_id;
        this.full_name = full_name;
        this.class_code = class_code;
        this.subject_code = subject_code;
        this.term = term;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "AnhPTClassUser{" + "user_id=" + user_id + ", class_id=" + class_id + ", full_name=" + full_name + ", class_code=" + class_code + ", subject_code=" + subject_code + ", term=" + term + '}';
    }
    
    
}
