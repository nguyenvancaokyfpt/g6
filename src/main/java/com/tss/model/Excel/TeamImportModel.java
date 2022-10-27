package com.tss.model.Excel;

import java.util.HashMap;
import java.util.List;

import com.tss.model.Team;
import com.tss.model.Trainee;

public class TeamImportModel {
    private List<Team> listTeam;
    private HashMap<Integer, List<Trainee>> traineeTeamMap;

    public TeamImportModel() {
    }

    public TeamImportModel(List<Team> listTeam, HashMap<Integer, List<Trainee>> traineeTeamMap) {
        this.listTeam = listTeam;
        this.traineeTeamMap = traineeTeamMap;
    }

    /**
     * @return List<Team> return the listTeam
     */
    public List<Team> getListTeam() {
        return listTeam;
    }

    /**
     * @param listTeam the listTeam to set
     */
    public void setListTeam(List<Team> listTeam) {
        this.listTeam = listTeam;
    }

    /**
     * @return HashMap<Integer, List<Trainee>> return the traineeTeamMap
     */
    public HashMap<Integer, List<Trainee>> getTraineeTeamMap() {
        return traineeTeamMap;
    }

    /**
     * @param traineeTeamMap the traineeTeamMap to set
     */
    public void setTraineeTeamMap(HashMap<Integer, List<Trainee>> traineeTeamMap) {
        this.traineeTeamMap = traineeTeamMap;
    }

}
