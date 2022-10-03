package com.tss.constants;

public enum StatusConstants {

    ACTIVE(1, "Active"),
    INACTIVE(0, "Inactive");

    private int id;
    private String title;

    StatusConstants(int id, String title) {
        this.id = id;
        this.title = title;
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

}
