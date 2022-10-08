package com.tss.model;

public class Classroom {
    private int classId;
    private String classCode;
    private int comboId;
    private int trainerId;
    private int termId;
    private int statusId;
    private String statusTitle;
    private String description;

    public Classroom() {
    }

    public Classroom(int classId, String classCode, int comboId, int trainerId, int termId, int statusId, String description) {
        this.classId = classId;
        this.classCode = classCode;
        this.comboId = comboId;
        this.trainerId = trainerId;
        this.termId = termId;
        this.statusId = statusId;
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

    /**
     * @return String return the classCode
     */
    public String getClassCode() {
        return classCode;
    }

    /**
     * @param classCode the classCode to set
     */
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    /**
     * @return int return the comboId
     */
    public int getComboId() {
        return comboId;
    }

    /**
     * @param comboId the comboId to set
     */
    public void setComboId(int comboId) {
        this.comboId = comboId;
    }

    /**
     * @return int return the trainerId
     */
    public int getTrainerId() {
        return trainerId;
    }

    /**
     * @param trainerId the trainerId to set
     */
    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    /**
     * @return int return the termId
     */
    public int getTermId() {
        return termId;
    }

    /**
     * @param termId the termId to set
     */
    public void setTermId(int termId) {
        this.termId = termId;
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
     * @return String return the statusTitle
     */
    public String getStatusTitle() {
        return statusTitle;
    }

    /**
     * @param statusTitle the statusTitle to set
     */
    public void setStatusTitle(String statusTitle) {
        this.statusTitle = statusTitle;
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
