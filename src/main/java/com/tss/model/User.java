/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.model;

import java.util.Date;

/**
 *
 * @author nguye
 */
public class User {
    
    private int userId;
    private String fullname;
    private String email;
    private String mobile;
    private String avatarUrl;
    private int statusId;
    private String note;
    private Date createdAt;
    private Date updatedAt;
    private Date lastActive;

    public User() {
    }

    public User(int userId, String fullname, String email, String mobile, String avatarUrl, int statusId, String note, Date createdAt, Date updatedAt, Date lastActive) {
        this.userId = userId;
        this.fullname = fullname;
        this.email = email;
        this.mobile = mobile;
        this.avatarUrl = avatarUrl;
        this.statusId = statusId;
        this.note = note;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastActive = lastActive;
    }


    /**
     * @return int return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return String return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return String return the avatarUrl
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * @param avatarUrl the avatarUrl to set
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * @return int return the statusId
     */
    public int getStatusId() {
        return statusId;
    }

    /**
     * @param statusId the statusId to set
     */
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    /**
     * @return String return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return Date return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return Date return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return Date return the lastActive
     */
    public Date getLastActive() {
        return lastActive;
    }

    /**
     * @param lastActive the lastActive to set
     */
    public void setLastActive(Date lastActive) {
        this.lastActive = lastActive;
    }

}
