package com.tss.model.sercurity;

public class UserRole {

    private int userId;
    private int settingId;

    public UserRole() {
    }

    public UserRole(int userId, int settingId) {
        this.userId = userId;
        this.settingId = settingId;
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
     * @return int return the settingId
     */
    public int getSettingId() {
        return settingId;
    }

    /**
     * @param settingId the settingId to set
     */
    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

}
