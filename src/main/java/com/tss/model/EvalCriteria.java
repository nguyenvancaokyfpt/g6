/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tss.model;

/**
 *
 * @author Dat Lai
 */
public class EvalCriteria {

    private int id;
    private int assign;
    private int mile;
    private String name;
    private int isTeam;
    private int weight;
    private int maxLoc;
    private int status;
    private String description;
    private String assignName;
    private String subjectName;

    public String getAssignName() {
        return assignName;
    }

    public void setAssignName(String assignName) {
        this.assignName = assignName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public EvalCriteria() {
    }

    public EvalCriteria(int id, int assign, int mile, String name, int isTeam, int weight, int maxLoc, int status,
            String description) {
        this.id = id;
        this.assign = assign;
        this.mile = mile;
        this.name = name;
        this.isTeam = isTeam;
        this.weight = weight;
        this.maxLoc = maxLoc;
        this.status = status;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssign() {
        return assign;
    }

    public void setAssign(int assign) {
        this.assign = assign;
    }

    public int getMile() {
        return mile;
    }

    public void setMile(int mile) {
        this.mile = mile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsTeam() {
        return isTeam;
    }

    public void setIsTeam(int isTeam) {
        this.isTeam = isTeam;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxLoc() {
        return maxLoc;
    }

    public void setMaxLoc(int maxLoc) {
        this.maxLoc = maxLoc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
