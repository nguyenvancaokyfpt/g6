/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.tss.constants.StatusConstants;
import com.tss.model.system.Role;

/**
 *
 * @author nguye
 */
public class User {

    private int userId;
    private String fullname;
    private String email;
    private String username;
    private String password;
    private String mobile;
    private String avatarUrl;
    private int statusId;
    private String note;
    private Date createdAt;
    private Date updatedAt;
    private Date lastActive;
    private Role role;

    public User() {
    }

    public User(int userId, String fullname, String email, String username, String password, String mobile,
            String avatarUrl, int statusId, String note, Date createdAt, Date updatedAt, Date lastActive, Role role) {
        this.userId = userId;
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.avatarUrl = avatarUrl;
        this.statusId = statusId;
        this.note = note;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastActive = lastActive;
        this.role = role;
    }

    public User(String email, String password, String fullname) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }

    public User(String fullname, String email) {
        this.fullname = fullname;
        this.email = email;
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
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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

    /**
     * @return Role return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    // get first name
    public String getFirstName() {
        List<String> parts = Arrays.asList(fullname.split(" "));
        String firstName = "";
        for (int i = 0; i < parts.size() - 1; i++) {
            firstName += parts.get(i) + " ";
        }
        return firstName.trim();
    }

    // get last name
    public String getLastName() {
        List<String> parts = Arrays.asList(fullname.split(" "));
        return parts.get(parts.size() - 1);
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", fullname=" + fullname + ", email=" + email + ", mobile=" + mobile
                + ", avatarUrl=" + avatarUrl + ", statusId=" + statusId + ", note=" + note + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + ", lastActive=" + lastActive + '}';
    }

    public boolean isActive() {
        if (statusId == StatusConstants.ACTIVE.getId()) {
            return true;
        } else {
            return false;
        }
    }

}
