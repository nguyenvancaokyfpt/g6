package com.tss.model.system;

public class ClassSetting {

    private int id;
    private int typeId;
    private String title;
    private String value;
    private String displayOrder;
    private int statusId;
    private String description;
    private int classId;

    public ClassSetting() {
    }

    public ClassSetting(int id, int typeId, String title, String value, String displayOrder, int statusId,
            String description, int classId) {
        this.id = id;
        this.typeId = typeId;
        this.title = title;
        this.value = value;
        this.displayOrder = displayOrder;
        this.statusId = statusId;
        this.description = description;
        this.classId = classId;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return int return the typeId
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * @param typeId the typeId to set
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return String return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return String return the displayOrder
     */
    public String getDisplayOrder() {
        return displayOrder;
    }

    /**
     * @param displayOrder the displayOrder to set
     */
    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
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
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return int return the classId
     */
    public int getClassId() {
        return classId;
    }

    /**
     * @param classId the classId to set
     */
    public void setClassId(int classId) {
        this.classId = classId;
    }

}
