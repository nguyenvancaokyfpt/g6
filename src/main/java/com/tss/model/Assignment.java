package com.tss.model;

public class Assignment {

    private int assId, subjectId;
    private String title, assBody;
    private int evalWeight, isTeamwork, isOngoing, statusId;
    private String subjectName;

    public Assignment() {
    }

    public Assignment(int assId, int subjectId, String title, String assBody, int evalWeight, int isTeamwork, int isOngoing, int statusId, String subjectName) {
        this.assId = assId;
        this.subjectId = subjectId;
        this.title = title;
        this.assBody = assBody;
        this.evalWeight = evalWeight;
        this.isTeamwork = isTeamwork;
        this.isOngoing = isOngoing;
        this.statusId = statusId;
        this.subjectName = subjectName;
    }

    public int getAssId() {
        return assId;
    }

    public void setAssId(int assId) {
        this.assId = assId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssBody() {
        return assBody;
    }

    public void setAssBody(String assBody) {
        this.assBody = assBody;
    }

    public int getEvalWeight() {
        return evalWeight;
    }

    public void setEvalWeight(int evalWeight) {
        this.evalWeight = evalWeight;
    }

    public int getIsTeamwork() {
        return isTeamwork;
    }

    public void setIsTeamwork(int isTeamwork) {
        this.isTeamwork = isTeamwork;
    }

    public int getIsOngoing() {
        return isOngoing;
    }

    public void setIsOngoing(int isOngoing) {
        this.isOngoing = isOngoing;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

}
