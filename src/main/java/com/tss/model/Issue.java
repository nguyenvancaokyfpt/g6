/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.model;

/**
 *
 * @author Dat Lai
 */
public class Issue {
    private int issueId;
    private String title;
    private Team team;
    private Milestone milestone;
    private Assignment assign;
    private ClassEntity myClass;
    private Trainee assignee;
    private Status status;
    private int isClose;
    private int type;
    private String extra_labels;
    private String decription;
    private int link_id;
    private String gitlab_url;
    

    public Issue() {
    }

    public String getExtra_labels() {
        return extra_labels;
    }

    public void setExtra_labels(String extra_labels) {
        this.extra_labels = extra_labels;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getLink_id() {
        return link_id;
    }

    public void setLink_id(int link_id) {
        this.link_id = link_id;
    }

    public String getGitlab_url() {
        return gitlab_url;
    }

    public void setGitlab_url(String gitlab_url) {
        this.gitlab_url = gitlab_url;
    }

    
    
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    
    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Milestone getMilestone() {
        return milestone;
    }

    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

    public Assignment getAssign() {
        return assign;
    }

    public void setAssign(Assignment assign) {
        this.assign = assign;
    }

    public ClassEntity getMyClass() {
        return myClass;
    }

    public void setMyClass(ClassEntity myClass) {
        this.myClass = myClass;
    }

    public Trainee getAssignee() {
        return assignee;
    }

    public void setAssignee(Trainee assignee) {
        this.assignee = assignee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getIsClose() {
        return isClose;
    }

    public void setIsClose(int isClose) {
        this.isClose = isClose;
    }
    
    
    
    
}
