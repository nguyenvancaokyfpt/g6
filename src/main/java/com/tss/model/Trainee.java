package com.tss.model;

import java.util.Date;

public class Trainee extends User {

    private int classId;
    private Date dropoutDate;
    private float grade;
    private boolean isLeader;
    private int teamId;

    public Trainee() {
    }

    public Trainee(String fullname, String email) {
        super(fullname, email);
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
     * @return Date return the dropoutDate
     */
    public Date getDropoutDate() {
        return dropoutDate;
    }

    /**
     * @param dropoutDate the dropoutDate to set
     */
    public void setDropoutDate(Date dropoutDate) {
        this.dropoutDate = dropoutDate;
    }

    /**
     * @return float return the grade
     */
    public float getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(float grade) {
        this.grade = grade;
    }

    /**
     * @return int return the teamId
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * @param teamId the teamId to set
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    /**
     * @return boolean return the isLeader
     */
    public boolean isIsLeader() {
        return isLeader;
    }

    /**
     * @param isLeader the isLeader to set
     */
    public void setIsLeader(boolean isLeader) {
        this.isLeader = isLeader;
    }

    @Override
    public String toString() {
        return "Trainee [name " + super.getFullname() + " , isLeader="
                + isLeader + ", teamId=" + teamId + "]";
    }

}
