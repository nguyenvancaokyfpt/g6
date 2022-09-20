package com.tss.model.system;

public class Setting {
    private int id;
    private int type_id;
    private String title;
    private String value;
    private String display_order;
    private int status_id;
    private String description;

    public Setting() {
    }

    public Setting(int id, int type_id, String title, String value, String display_order, int status_id, String description) {
        this.id = id;
        this.type_id = type_id;
        this.title = title;
        this.value = value;
        this.display_order = display_order;
        this.status_id = status_id;
        this.description = description;
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
     * @return int return the type_id
     */
    public int getType_id() {
        return type_id;
    }

    /**
     * @param type_id the type_id to set
     */
    public void setType_id(int type_id) {
        this.type_id = type_id;
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
     * @return String return the display_order
     */
    public String getDisplay_order() {
        return display_order;
    }

    /**
     * @param display_order the display_order to set
     */
    public void setDisplay_order(String display_order) {
        this.display_order = display_order;
    }

    /**
     * @return int return the status_id
     */
    public int getStatus_id() {
        return status_id;
    }

    /**
     * @param status_id the status_id to set
     */
    public void setStatus_id(int status_id) {
        this.status_id = status_id;
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

}
