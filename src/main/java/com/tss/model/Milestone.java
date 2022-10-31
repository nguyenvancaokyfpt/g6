/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Milestone {
    private int milestoneId;
    private int assId;
    private String assTitle;
    private int subjectId;
    private String subject;
    private int classId;
    private String classCode;
    private Date fromDate;
    private Date toDate;
    private String title;
    private String assBody;
    private String description;
    private int statusId;

    public Milestone() {
    }

    public Milestone(int milestoneId, int assId, String assTitle, int subjectId, String subject, int classId,
            String classCode, Date fromDate, Date toDate, String title, String assBody, String description,
            int statusId) {
        this.milestoneId = milestoneId;
        this.assId = assId;
        this.assTitle = assTitle;
        this.subjectId = subjectId;
        this.subject = subject;
        this.classId = classId;
        this.classCode = classCode;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.title = title;
        this.assBody = assBody;
        this.description = description;
        this.statusId = statusId;
    }

    public String getAssTitle() {
        return assTitle;
    }

    public void setAssTitle(String assTitle) {
        this.assTitle = assTitle;
    }

    public int getMilestoneId() {
        return milestoneId;
    }

    public void setMilestoneId(int milestoneId) {
        this.milestoneId = milestoneId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
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

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

}
