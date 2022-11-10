/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.tss.controller.team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.ScreenConstants;
import com.tss.constants.SessionConstants;
import com.tss.helper.DebugHelper;
import com.tss.helper.ExcelHelper;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.Classroom;
import com.tss.model.Milestone;
import com.tss.model.Team;
import com.tss.model.Trainee;
import com.tss.model.User;
import com.tss.model.Excel.TeamImportModel;
import com.tss.model.payload.ResponseMessage;
import com.tss.service.ClassService;
import com.tss.service.MilestoneService;
import com.tss.service.TeamService;
import com.tss.service.UserService;
import com.tss.service.impl.ClassServiceImpl;
import com.tss.service.impl.MilestoneServiceImpl;
import com.tss.service.impl.TeamServiceImpl;
import com.tss.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class TeamNewServlet extends HttpServlet {

    private ClassService classService;
    private TeamService teamService;
    private UserService userService;
    private MilestoneService milestoneService;

    @Override
    public void init() throws ServletException {
        classService = new ClassServiceImpl();
        teamService = new TeamServiceImpl();
        userService = new UserServiceImpl();
        milestoneService = new MilestoneServiceImpl();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * 
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "";
        switch (action) {
            case ActionConstants.CREATE:
                create(request, response);
                break;
            case ActionConstants.UPDATE:
                update(request, response);
                break;
            case ActionConstants.DELETE:
                delete(request, response);
                break;
            case ActionConstants.GET:
                get(request, response);
                break;
            default:
                list(request, response);
                break;
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) {
    }

    private void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        try {
            String action = jsonObject.getString("action");
            switch (action) {
                case "readTeamImportFile":
                    readTeamImportFile(jsonObject, request, response);
                    break;
                case "teamMember":
                    getTeamMember(jsonObject, request, response);
                    break;
                default:
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Action is not valid"));
                    break;
            }
        } catch (Exception e) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Please check your input data"));
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        try {
            String action = jsonObject.getString("action");
            switch (action) {
                case "resetTeam":
                    resetTeam(jsonObject, request, response);
                    break;
                default:
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Action is not valid"));
                    break;
            }
        } catch (Exception e) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Please check your input data"));
        }
    }

    private void resetTeam(JSONObject jsonObject, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int classId = jsonObject.getIntValue("classId");
            int milestoneId = jsonObject.getIntValue("milestoneId");
            Classroom classroom = classService.findClassById(classId);
            if (classroom == null) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Classroom is not valid"));
                return;
            }

            teamService.resetTeam(classId, milestoneId);

            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.OK, "Reset team success"));
        } catch (Exception e) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Please check your input data"));
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        try {
            String action = jsonObject.getString("action");
            switch (action) {
                case "import":
                    importTeam(jsonObject, request, response);
                    break;
                case "random":
                    randomTeam(jsonObject, request, response);
                    break;
                case "reuse":
                    reuseTeam(jsonObject, request, response);
                    break;
                case "clone":
                    cloneTeam(jsonObject, request, response);
                    break;
                default:
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Action is not valid"));
                    break;
            }
        } catch (Exception e) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Please check your input data"));
        }
    }

    private void importTeam(JSONObject jsonObject, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            int classId = jsonObject.getIntValue("classId");
            String fileUrl = jsonObject.getString("fileUrl");
            int milestoneId = 0;
            try {
                milestoneId = jsonObject.getIntValue("milestoneId");
            } catch (Exception e) {
                milestoneId = 0;
            }
            String appPath = request.getServletContext().getRealPath("");
            appPath = appPath.replace('\\', '/');
            String filePath = appPath + fileUrl;

            Classroom classroom = classService.findClassById(classId);
            if (classroom == null) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Class is not exist"));
                return;
            }

            TeamImportModel teamImportModel = ExcelHelper.readTeamImportFile(filePath);
            if (teamImportModel == null) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "File is not valid"));
                return;
            }

            if (milestoneId == 0) {
                // Remove all student link to team of this class
                teamService.removeStudentLinkToTeam(classId);

                // remove all team in class
                teamService.resetTeam(classId);

                // set class id for all team
                for (Team team : teamImportModel.getListTeam()) {
                    team.setClassId(classId);
                }
                // set class id for all student
                for (Integer key : teamImportModel.getTraineeTeamMap().keySet()) {
                    List<Trainee> traineeList = teamImportModel.getTraineeTeamMap().get(key);
                    for (Trainee trainee : traineeList) {
                        trainee.setClassId(classId);
                    }
                }
                // import team
                List<Integer> listTeamId = teamService.importTeam(teamImportModel.getListTeam());
                if (listTeamId == null) {
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Import team failed"));
                    return;
                }

                // import student
                List<Integer> listStudentId = teamService.importStudent(teamImportModel.getTraineeTeamMap(),
                        listTeamId);
                if (listStudentId.size() == 0) {
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Import student failed"));
                    return;
                }
                // import team_members
                listStudentId = teamService.importTeamMembers(teamImportModel.getTraineeTeamMap(),
                        listTeamId);
                if (listStudentId.size() == 0) {
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Import student failed"));
                    return;
                }

            } else {
                // remove team-milestone
                teamService.removeTeamMilestone(classId, milestoneId);

                // set class id for all team
                for (Team team : teamImportModel.getListTeam()) {
                    team.setClassId(classId);
                }

                // set class id for all student
                for (Integer key : teamImportModel.getTraineeTeamMap().keySet()) {
                    List<Trainee> traineeList = teamImportModel.getTraineeTeamMap().get(key);
                    for (Trainee trainee : traineeList) {
                        trainee.setClassId(classId);
                    }
                }

                // import team
                List<Integer> listTeamId = teamService.importTeam(teamImportModel.getListTeam());
                if (listTeamId == null) {
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Import team failed"));
                    return;
                }

                // set team-milestone
                teamService.setTeamMilestone(classId, milestoneId, listTeamId);

                // import team_members
                List<Integer> listStudentId = teamService.importTeamMembers(teamImportModel.getTraineeTeamMap(),
                        listTeamId);

                if (listStudentId.size() == 0 || listStudentId == null) {
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Import student failed"));
                    return;
                }
            }

            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.OK, "Import team successfully"));
        } catch (Exception e) {
            DebugHelper.print(e);
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Please check your input data"));
        }

    }

    private void readTeamImportFile(JSONObject jsonObject, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String fileUrl = jsonObject.getString("fileUrl");
            String appPath = request.getServletContext().getRealPath("");
            appPath = appPath.replace('\\', '/');
            String filePath = appPath + fileUrl;
            TeamImportModel teamImportModel = ExcelHelper.readTeamImportFile(filePath);
            if (teamImportModel == null) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "File is not valid"));
                return;
            }
            for (Integer id : teamImportModel.getTraineeTeamMap().keySet()) {
                List<Trainee> traineeList = teamImportModel.getTraineeTeamMap().get(id);
                for (Trainee trainee : traineeList) {
                    User user = userService.findByEmail(trainee.getEmail());
                    if (user != null) {
                        trainee.setUserId(user.getUserId());
                        trainee.setAvatarUrl(user.getAvatarUrl());
                    }
                }
            }

            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.OK, "Read file successfully", teamImportModel));
        } catch (Exception e) {
            DebugHelper.print(e);
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Please check your input data"));
        }
    }

    private void randomTeam(JSONObject jsonObject, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            int classId = jsonObject.getIntValue("classId");
            int milestoneId = 0;
            try {
                milestoneId = jsonObject.getIntValue("milestoneId");
            } catch (Exception e) {
                milestoneId = 0;
            }
            int teamNumber = jsonObject.getIntValue("teamNumber");

            Classroom classroom = classService.findClassById(classId);
            if (classroom == null) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Class is not exist"));
                return;
            }

            List<Trainee> traineeList = userService.findAllByClassId(0, 999, "", null, 0, "ASC", "", classId);
            if (traineeList.size() == 0) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Class is empty"));
                return;
            }

            if (milestoneId == 0) {
                // Remove all student link to team of this class
                teamService.removeStudentLinkToTeam(classId);

                // remove all team in class
                teamService.resetTeam(classId);

                // random team
                List<Team> listTeam = new ArrayList<Team>();
                for (int i = 1; i <= teamNumber; i++) {
                    Team team = new Team();
                    team.setClassId(classId);
                    team.setName("Team " + i);
                    team.setProject_code("Project " + i);
                    team.setTopic_code("Topic " + i);
                    team.setTopic_name("Topic " + i);
                    team.setDescription("Description " + i);
                    listTeam.add(team);
                }
                // Import random team
                List<Integer> listTeamId = teamService.importTeam(listTeam);

                // Calculate number of student in each team
                if (traineeList.size() < teamNumber) {
                    teamNumber = traineeList.size();
                }
                int teamSize = traineeList.size() / teamNumber;

                // random student
                HashMap<Integer, List<Trainee>> traineeTeamMap = new HashMap<Integer, List<Trainee>>();
                for (int i = 1; i <= teamNumber; i++) {
                    List<Trainee> listTrainee = new ArrayList<Trainee>();
                    for (int j = 0; j < teamSize; j++) {
                        int index = (int) (Math.random() * traineeList.size());
                        Trainee trainee = traineeList.get(index);
                        trainee.setClassId(classId);
                        listTrainee.add(trainee);
                        traineeList.remove(index);
                    }
                    traineeTeamMap.put(i, listTrainee);
                }
                // add remain student to each team
                for (int i = 0; i < traineeList.size(); i++) {
                    Trainee trainee = traineeList.get(i);
                    trainee.setClassId(classId);
                    traineeTeamMap.get(i + 1).add(trainee);
                }
                // only one leader in each team
                for (Integer id : traineeTeamMap.keySet()) {
                    List<Trainee> listTrainee = traineeTeamMap.get(id);
                    for (Trainee trainee : listTrainee) {
                        trainee.setIsLeader(false);
                    }
                    listTrainee.get(0).setIsLeader(true);
                }

                // import student
                List<Integer> listStudentId = teamService.importStudent(traineeTeamMap,
                        listTeamId);
                if (listStudentId.size() == 0) {
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Import student failed"));
                    return;
                }
                // import team_members
                listStudentId = teamService.importTeamMembers(traineeTeamMap,
                        listTeamId);
                if (listStudentId.size() == 0) {
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Import student failed"));
                    return;
                }

                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.OK, "Random team successfully", traineeTeamMap));

            } else {
                // remove team-milestone
                teamService.removeTeamMilestone(classId, milestoneId);

                // random team
                List<Team> listTeam = new ArrayList<Team>();
                for (int i = 1; i <= teamNumber; i++) {
                    Team team = new Team();
                    team.setClassId(classId);
                    team.setName("Team " + i);
                    team.setProject_code("Project " + i);
                    team.setTopic_code("Topic " + i);
                    team.setTopic_name("Topic " + i);
                    team.setDescription("Description " + i);
                    listTeam.add(team);
                }
                // Import random team
                List<Integer> listTeamId = teamService.importTeam(listTeam);

                // Calculate number of student in each team
                if (traineeList.size() < teamNumber) {
                    teamNumber = traineeList.size();
                }
                int teamSize = traineeList.size() / teamNumber;

                // set team-milestone
                teamService.setTeamMilestone(classId, milestoneId, listTeamId);

                // random student
                HashMap<Integer, List<Trainee>> traineeTeamMap = new HashMap<Integer, List<Trainee>>();
                for (int i = 1; i <= teamNumber; i++) {
                    List<Trainee> listTrainee = new ArrayList<Trainee>();
                    for (int j = 0; j < teamSize; j++) {
                        int index = (int) (Math.random() * traineeList.size());
                        Trainee trainee = traineeList.get(index);
                        trainee.setClassId(classId);
                        listTrainee.add(trainee);
                        traineeList.remove(index);
                    }
                    traineeTeamMap.put(i, listTrainee);
                }
                // add remain student to each team
                for (int i = 0; i < traineeList.size(); i++) {
                    Trainee trainee = traineeList.get(i);
                    trainee.setClassId(classId);
                    traineeTeamMap.get(i + 1).add(trainee);
                }

                // only one leader in each team
                for (Integer id : traineeTeamMap.keySet()) {
                    List<Trainee> listTrainee = traineeTeamMap.get(id);
                    for (Trainee trainee : listTrainee) {
                        trainee.setIsLeader(false);
                    }
                    listTrainee.get(0).setIsLeader(true);
                }

                // import team_members
                List<Integer> listStudentId = teamService.importTeamMembers(traineeTeamMap,
                        listTeamId);

                if (listStudentId.size() == 0 || listStudentId == null) {
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Import student failed"));
                    return;
                }

                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.OK, "Random team successfully", traineeTeamMap));

            }

        } catch (Exception e) {
            DebugHelper.print(e);
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Please check your input data"));
        }
    }

    private void reuseTeam(JSONObject jsonObject, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            int classId = jsonObject.getIntValue("classId");
            int milestoneId = 0;
            try {
                milestoneId = jsonObject.getIntValue("milestoneId");
            } catch (Exception e) {
                milestoneId = 0;
            }
            int newMilestoneId = jsonObject.getIntValue("newMilestoneId");

            Classroom classroom = classService.findClassById(classId);
            if (classroom == null) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Class is empty"));
                return;
            }

            if (milestoneId == 0) {
                // Get default team of class
                List<Team> listTeam = teamService.FindByClassUser(classId);
                if (listTeam.size() == 0) {
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Class is not have default team"));
                    return;
                }
                // List team id
                List<Integer> listTeamId = new ArrayList<Integer>();
                for (Team team : listTeam) {
                    listTeamId.add(team.getId());
                }

                // set team-milestone
                teamService.setTeamMilestone(classId, newMilestoneId, listTeamId);

                // HashMap team-student
                HashMap<Integer, List<Trainee>> traineeTeamMap = new HashMap<Integer, List<Trainee>>();
                int teamIndex = 1;
                for (Team team : listTeam) {
                    List<Trainee> listTrainee = teamService.getTraineeByTeamId(team.getId());
                    DebugHelper.print("Get trainee by team id: " + team.getId());
                    traineeTeamMap.put(teamIndex, listTrainee);
                    teamIndex++;
                }

                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.OK, "Reuse team successfully", traineeTeamMap));

            } else {
                // get team id of class and milestone
                List<Integer> listTeamId = teamService.getTeamIdByClassIdAndMilestoneId(classId, milestoneId);

                // set team-milestone
                teamService.setTeamMilestone(classId, newMilestoneId, listTeamId);

                // get team member of each team
                HashMap<Integer, List<Trainee>> traineeTeamMap = new HashMap<Integer, List<Trainee>>();
                int teamIndex = 1;
                for (Integer teamId : listTeamId) {
                    List<Trainee> listTrainee = teamService.getTraineeByTeamId(teamId);
                    traineeTeamMap.put(teamIndex, listTrainee);
                    teamIndex++;
                }

                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.OK, "Reuse team successfully", traineeTeamMap));
            }

        } catch (Exception e) {
            DebugHelper.print(e);
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Please check your input data"));
        }
    }

    private void cloneTeam(JSONObject jsonObject, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            int classId = jsonObject.getIntValue("classId");
            int milestoneId = 0;
            try {
                milestoneId = jsonObject.getIntValue("milestoneId");
            } catch (Exception e) {
                milestoneId = 0;
            }
            int newMilestoneId = jsonObject.getIntValue("newMilestoneId");

            if (milestoneId == newMilestoneId) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Milestone is same"));
                return;
            }

            // check class team milestone is exist
            if (teamService.checkClassTeamMilestone(classId, newMilestoneId)) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Class team milestone is exist"));
                return;
            }

            Classroom classroom = classService.findClassById(classId);
            if (classroom == null) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Class is empty"));
                return;
            }

            if (milestoneId == 0) {
                // Get default team of class
                List<Team> listTeam = teamService.FindByClassUser(classId);
                if (listTeam.size() == 0) {
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Class is not have default team"));
                    return;
                }
                // List team id
                List<Integer> listTeamId = new ArrayList<Integer>();
                for (Team team : listTeam) {
                    listTeamId.add(team.getId());
                }

                // clone team
                List<Integer> listNewTeamId = new ArrayList<Integer>();
                for (Integer id : listTeamId) {
                    int newTeamId = teamService.cloneTeam(id);
                    listNewTeamId.add(newTeamId);
                }
                // team member clone
                teamService.cloneTeamMember(listTeamId, listNewTeamId);

                // set team-milestone
                teamService.setTeamMilestone(classId, newMilestoneId, listNewTeamId);

                // HashMap team-student
                HashMap<Integer, List<Trainee>> traineeTeamMap = new HashMap<Integer, List<Trainee>>();
                int teamIndex = 1;
                for (Team team : listTeam) {
                    List<Trainee> listTrainee = teamService.getTraineeByTeamId(team.getId());
                    traineeTeamMap.put(teamIndex, listTrainee);
                    teamIndex++;
                }

                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.OK, "Clone team successfully", traineeTeamMap));

            } else {
                // get team id of class and milestone
                List<Integer> listTeamId = teamService.getTeamIdByClassIdAndMilestoneId(classId, milestoneId);

                // clone team
                List<Integer> listNewTeamId = new ArrayList<Integer>();
                for (Integer id : listTeamId) {
                    int newTeamId = teamService.cloneTeam(id);
                    listNewTeamId.add(newTeamId);
                }

                // team member clone
                teamService.cloneTeamMember(listTeamId, listNewTeamId);

                // set team-milestone
                teamService.setTeamMilestone(classId, newMilestoneId, listNewTeamId);

                // get team member of each team
                HashMap<Integer, List<Trainee>> traineeTeamMap = new HashMap<Integer, List<Trainee>>();
                int teamIndex = 1;
                for (Integer teamId : listTeamId) {
                    List<Trainee> listTrainee = teamService.getTraineeByTeamId(teamId);
                    traineeTeamMap.put(teamIndex, listTrainee);
                    teamIndex++;
                }

                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.OK, "Clone team successfully", traineeTeamMap));
            }

        } catch (Exception e) {
            DebugHelper.print(e);
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Please check your input data"));
        }
    }

    private void getTeamMember(JSONObject jsonObject, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            int classId = jsonObject.getIntValue("classId");
            int milestoneId = 0;
            try {
                milestoneId = jsonObject.getIntValue("milestoneId");
            } catch (Exception e) {
                milestoneId = 0;
            }
            HashMap<Integer, List<Trainee>> traineeTeamMap = new HashMap<Integer, List<Trainee>>();
            if (milestoneId == 0) {
                // Get default team of class
                List<Team> listTeam = teamService.FindByClassUser(classId);
                if (listTeam.size() == 0) {
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Class is not have default team"));
                    return;
                }
                // HashMap team-student
                traineeTeamMap = new HashMap<Integer, List<Trainee>>();
                int teamIndex = 1;
                for (Team team : listTeam) {
                    List<Trainee> listTrainee = teamService.getTraineeByTeamId(team.getId());
                    traineeTeamMap.put(teamIndex, listTrainee);
                    teamIndex++;
                }
            } else {
                // List team
                List<Integer> listTeamId = teamService.getTeamIdByClassIdAndMilestoneId(classId, milestoneId);

                // HashMap team-student
                traineeTeamMap = new HashMap<Integer, List<Trainee>>();
                int teamIndex = 1;
                for (Integer teamId : listTeamId) {
                    List<Trainee> listTrainee = teamService.getTraineeByTeamId(teamId);
                    traineeTeamMap.put(teamIndex, listTrainee);
                    teamIndex++;
                }
            }

            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.OK, "Get team member successfully", traineeTeamMap));
        } catch (Exception e) {
            DebugHelper.print(e);
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Please check your input data"));
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * 
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "upload";
        int milestoneId = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id"))
                : 100;
        switch (action) {
            case ActionConstants.GET:
                getFile(request, response);
                break;
            case "random":
                randomTeam(request, response, action, milestoneId);
                break;
            case "reuse":
                reuseTeam(request, response, action, milestoneId);
                break;
            case "clone":
                cloneTeam(request, response, action, milestoneId);
                break;
            default:
                view(request, response, action, milestoneId);
                break;
        }
    }

    private void view(HttpServletRequest request, HttpServletResponse response, String action, int milestoneId)
            throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/teamnew.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "Team/new/upload.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.TEAM_LIST,
                ScreenConstants.TEAM_NEW));
        request.setAttribute("nav_action", action);
        request.setAttribute("milestoneId", milestoneId);
        Classroom classroom = new Classroom();
        List<Milestone> listMilestone = new ArrayList<Milestone>();

        int classroomId = request.getAttribute("globalClass") != null
                ? Integer.parseInt(request.getAttribute("globalClass").toString())
                : 0;

        if (classroomId == 0 || classroomId == -1) {
            request.setAttribute("globalClass", 1);
            request.getSession().setAttribute(SessionConstants.GLOBAL_CLASS_ID, 1);
            classroomId = 1;
        }
        // get classroom
        try {
            classroom = classService
                    .findClassById(classroomId);
            request.setAttribute("classroom", classroom);
        } catch (Exception e) {
            classroom = null;
        }

        // get milestone
        try {
            listMilestone = milestoneService.findByClassId(classroomId);
            DebugHelper.print(listMilestone);
            request.setAttribute("listMilestone", listMilestone);
        } catch (Exception e) {
            listMilestone = null;
        }
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void randomTeam(HttpServletRequest request, HttpServletResponse response, String action, int milestoneId)
            throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/teamnew-random.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "Team/new/random.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.TEAM_LIST,
                ScreenConstants.TEAM_NEW));
        request.setAttribute("nav_action", action);
        request.setAttribute("milestoneId", milestoneId);
        Classroom classroom = new Classroom();
        List<Milestone> listMilestone = new ArrayList<Milestone>();

        int classroomId = request.getAttribute("globalClass") != null
                ? Integer.parseInt(request.getAttribute("globalClass").toString())
                : 0;

        if (classroomId == 0 || classroomId == -1) {
            request.setAttribute("globalClass", 1);
            request.getSession().setAttribute(SessionConstants.GLOBAL_CLASS_ID, 1);
            classroomId = 1;
        }
        // get classroom
        try {
            classroom = classService
                    .findClassById(classroomId);
            request.setAttribute("classroom", classroom);
        } catch (Exception e) {
            classroom = null;
        }

        // get milestone
        try {
            listMilestone = milestoneService.findByClassId(classroomId);
            DebugHelper.print(listMilestone);
            request.setAttribute("listMilestone", listMilestone);
        } catch (Exception e) {
            listMilestone = null;
        }
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void reuseTeam(HttpServletRequest request, HttpServletResponse response, String action, int milestoneId)
            throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/teamnew-reuse.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "Team/new/reuse.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.TEAM_LIST,
                ScreenConstants.TEAM_NEW));
        request.setAttribute("nav_action", action);
        request.setAttribute("milestoneId", milestoneId);
        Classroom classroom = new Classroom();
        List<Milestone> listMilestone = new ArrayList<Milestone>();

        int classroomId = request.getAttribute("globalClass") != null
                ? Integer.parseInt(request.getAttribute("globalClass").toString())
                : 0;

        if (classroomId == 0 || classroomId == -1) {
            request.setAttribute("globalClass", 1);
            request.getSession().setAttribute(SessionConstants.GLOBAL_CLASS_ID, 1);
            classroomId = 1;
        }
        // get classroom
        try {
            classroom = classService
                    .findClassById(classroomId);
            request.setAttribute("classroom", classroom);
        } catch (Exception e) {
            classroom = null;
        }

        // get milestone
        try {
            listMilestone = milestoneService.findByClassId(classroomId);
            DebugHelper.print(listMilestone);
            request.setAttribute("listMilestone", listMilestone);
        } catch (Exception e) {
            listMilestone = null;
        }
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void cloneTeam(HttpServletRequest request, HttpServletResponse response, String action, int milestoneId)
            throws ServletException, IOException {
        request.setAttribute("jspPath", "shared/teamnew-clone.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "Team/new/clone.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.TEAM_LIST,
                ScreenConstants.TEAM_NEW));
        request.setAttribute("nav_action", action);
        request.setAttribute("milestoneId", milestoneId);
        Classroom classroom = new Classroom();
        List<Milestone> listMilestone = new ArrayList<Milestone>();

        int classroomId = request.getAttribute("globalClass") != null
                ? Integer.parseInt(request.getAttribute("globalClass").toString())
                : 0;

        if (classroomId == 0 || classroomId == -1) {
            request.setAttribute("globalClass", 1);
            request.getSession().setAttribute(SessionConstants.GLOBAL_CLASS_ID, 1);
            classroomId = 1;
        }
        // get classroom
        try {
            classroom = classService
                    .findClassById(classroomId);
            request.setAttribute("classroom", classroom);
        } catch (Exception e) {
            classroom = null;
        }

        // get milestone
        try {
            listMilestone = milestoneService.findByClassId(classroomId);
            DebugHelper.print(listMilestone);
            request.setAttribute("listMilestone", listMilestone);
        } catch (Exception e) {
            listMilestone = null;
        }
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    private void getFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String param = request.getParameter("classId") == null ? "" : request.getParameter("classId");
        int classId = 0;
        try {
            classId = Integer.parseInt(param);
        } catch (Exception e) {
            ResponseHelper.sendResponse(response, new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST,
                    "Invalid class id"));
            return;
        }
        UserService userService = new UserServiceImpl();
        List<Trainee> traineeList = userService.findAllByClassId(0, 999, "", null, 0, "ASC", "", classId);
        String appPath = request.getServletContext().getRealPath("");
        appPath = appPath.replace('\\', '/');
        ExcelHelper.exportUserForTeamImport(traineeList,
                appPath + "assets/media/file/TeamImportTemplateClass" + classId + ".xlsx");
        response.sendRedirect(request.getContextPath() + "/assets/media/file/TeamImportTemplateClass" + classId
                + ".xlsx");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * 
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * 
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
