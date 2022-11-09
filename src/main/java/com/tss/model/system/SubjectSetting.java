package com.tss.model.system;

public class SubjectSetting {

    private int settingId;
    private int typeId;
    private String title;
    private int value;
    private String displayOrder;
    private int statusId;
    private String description;
    private int subjectId;
    private String subjectName;
    private String typeTitle;

    public SubjectSetting() {
    }

    public SubjectSetting(int settingId, int typeId, String title, int value, String displayOrder, int statusId,
            String description, int subjectId, String subjectName, String typeTitle) {
        this.settingId = settingId;
        this.typeId = typeId;
        this.title = title;
        this.value = value;
        this.displayOrder = displayOrder;
        this.statusId = statusId;
        this.description = description;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.typeTitle = typeTitle;
    }

    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
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

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

}
