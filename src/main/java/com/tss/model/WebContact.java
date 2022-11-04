/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.model;

import java.util.Date;

/**
 *
 * @author Dat Lai
 */
public class WebContact {

    private int id;
    private int category_id;
    private int supporter_id;
    private String full_name;
    private String email;
    private String mobile;
    private String message;
    private String response;
    private String suporter;
    private Date date;
    private int status;
    public WebContact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
    
    public String getSuporter() {
        return suporter;
    }

    public void setSuporter(String suporter) {
        this.suporter = suporter;
    }

    
    
    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getSupporter_id() {
        return supporter_id;
    }

    public void setSupporter_id(int supporter_id) {
        this.supporter_id = supporter_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
