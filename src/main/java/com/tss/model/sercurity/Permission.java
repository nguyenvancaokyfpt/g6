package com.tss.model.sercurity;

import com.tss.constants.ScreenConstants;

public class Permission {
    private int screenId;
    private int settingId;
    private boolean canGet;
    private boolean canDelete;
    private boolean canCreate;
    private boolean canUpdate;

    public Permission() {
    }

    public Permission(int screenId, int settingId, boolean canGet, boolean canDelete, boolean canCreate, boolean canUpdate) {
        this.screenId = screenId;
        this.settingId = settingId;
        this.canGet = canGet;
        this.canDelete = canDelete;
        this.canCreate = canCreate;
        this.canUpdate = canUpdate;
    }

    /**
     * @return int return the screenId
     */
    public int getScreenId() {
        return screenId;
    }

    /**
     * @param screenId the screenId to set
     */
    public void setScreenId(int screenId) {
        this.screenId = screenId;
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

    /**
     * @return boolean return the canGet
     */
    public boolean isCanGet() {
        return canGet;
    }

    /**
     * @param canGet the canGet to set
     */
    public void setCanGet(boolean canGet) {
        this.canGet = canGet;
    }

    /**
     * @return boolean return the canDelete
     */
    public boolean isCanDelete() {
        return canDelete;
    }

    /**
     * @param canDelete the canDelete to set
     */
    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    /**
     * @return boolean return the canCreate
     */
    public boolean isCanCreate() {
        return canCreate;
    }

    /**
     * @param canCreate the canCreate to set
     */
    public void setCanCreate(boolean canCreate) {
        this.canCreate = canCreate;
    }

    /**
     * @return boolean return the canUpdate
     */
    public boolean isCanUpdate() {
        return canUpdate;
    }

    /**
     * @param canUpdate the canUpdate to set
     */
    public void setCanUpdate(boolean canUpdate) {
        this.canUpdate = canUpdate;
    }

    public ScreenConstants getScreen() {
        return ScreenConstants.getScreenById(screenId);
    }

}
