/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tss.controller.management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.RoleConstants;
import com.tss.constants.ScreenConstants;
import com.tss.helper.DTOHelper;
import com.tss.helper.DebugHelper;
import com.tss.helper.ExcelHelper;
import com.tss.helper.RequestHelper;
import com.tss.helper.ResponseHelper;
import com.tss.model.Classroom;
import com.tss.model.Trainee;
import com.tss.model.User;
import com.tss.model.payload.DataTablesMessage;
import com.tss.model.payload.ResponseMessage;
import com.tss.model.util.DataTablesColumns;
import com.tss.service.ClassService;
import com.tss.service.RegisterService;
import com.tss.service.TraineeService;
import com.tss.service.UserService;
import com.tss.service.impl.ClassServiceImpl;
import com.tss.service.impl.RegisterServiceImpl;
import com.tss.service.impl.TraineeServiceImpl;
import com.tss.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class TraineeListServlet extends HttpServlet {

    private ClassService classService;
    private UserService userService;
    private TraineeService traineeService;
    private RegisterService registerService;

    @Override
    public void init() throws ServletException {
        classService = new ClassServiceImpl();
        userService = new UserServiceImpl();
        traineeService = new TraineeServiceImpl();
        registerService = new RegisterServiceImpl();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "";
        switch (action) {
            case ActionConstants.LIST:
                list(request, response);
                break;
            case "list2":
                list2(request, response);
                break;
            case "addToClass":
                addToClass(response, request);
                break;
            case "add":
                add(response, request);
                break;
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

    private void get(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        try {
            int userId = jsonObject.getIntValue("userID");
            String action = jsonObject.getString("action");
            Date dateDropout = null;
            if (action.equals("dropout")) {
                dateDropout = jsonObject.getDate("dateDropout");
                if (dateDropout == null) {
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Date dropout is required"));
                    return;
                }
                DebugHelper.print(dateDropout);
                traineeService.dropout(userId, dateDropout);
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.OK, "Dropout " + userId + " success"));
            } else if (action.equals("active")) {
                traineeService.active(userId);
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.OK, "Active " + userId + " success"));
            } else if (action.equals("deactive")) {
                traineeService.deactive(userId);
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.OK, "Deactive " + userId + " success"));
            } else {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Action is not valid"));
                return;
            }
        } catch (Exception e) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Please check your input data"));
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        try {
            String action = jsonObject.getString("action");
            switch (action) {
                case "create":

                    break;
                case "import":
                    createImport(jsonObject, response, request);
                    break;
                default:
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Action is not valid"));
                    break;
            }
        } catch (Exception e) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Action is not valid"));
        }
    }

    private void createImport(JSONObject jsonObject, HttpServletResponse response, HttpServletRequest request)
            throws IOException {
        try {
            int classId = jsonObject.getIntValue("classId");
            String fileUrls = jsonObject.getString("fileUrls");
            String appPath = request.getServletContext().getRealPath("");
            appPath = appPath.replace('\\', '/');

            Classroom classroom = classService.findClassById(classId);

            List<Trainee> trainees = new ArrayList<>();
            try {
                trainees = ExcelHelper.readEcxelFile(appPath + fileUrls);
                if (trainees.size() == 0) {
                    ResponseHelper.sendResponse(response,
                            new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "File is empty"));
                    return;
                }
            } catch (Exception e) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "File is not valid"));
                return;
            }

            // check if trainee is not exist
            List<Trainee> traineesNotExist = new ArrayList<>();
            for (Trainee trainee : trainees) {
                User user = userService.findByEmail(trainee.getEmail());
                if (user == null) {
                    traineesNotExist.add(trainee);
                } else {
                    if ((!trainee.getFullname().equals(user.getFullname())
                            || !trainee.getMobile().equals(user.getMobile()))) {
                        userService.updateUser(user.getUserId(), trainee.getFullname(), trainee.getMobile());
                    }
                }
            }
            // create trainee account
            for (Trainee trainee : traineesNotExist) {
                registerService.registerTraineeFromFile(trainee, classroom.getClassCode());
            }
            // grant trainee to class
            for (Trainee trainee : trainees) {
                try {
                    User user = userService.findByEmail(trainee.getEmail());
                    if (user != null) {
                        classService.grantTraineeToClass(user, classId, trainee.getGrade());
                    }
                } catch (Exception e) {
                    DebugHelper.print(e);
                }
            }
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.OK, "Import success"));
        } catch (Exception e) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Please check your input data"));
        }
    }

    private void add(HttpServletResponse response, HttpServletRequest request) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonData(request);
        String fullname = jsonObject.getString("fullname");
        String email = jsonObject.getString("email");
        String note = jsonObject.getString("note");
        int classId = jsonObject.getIntValue("classId");

        try {
            User user = userService.findByEmail(email);
            if (user != null) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Email is exist"));
                return;
            }

            Trainee trainee = new Trainee();
            trainee.setFullname(fullname);
            trainee.setEmail(email);
            trainee.setNote(note);
            trainee.setClassId(classId);

            Classroom classroom = classService.findClassById(classId);

            registerService.registerTraineeFromFile(trainee, classroom.getClassCode());

            // grant trainee to class
            user = userService.findByEmail(email);
            classService.grantTraineeToClass(user, classId, 0);

            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.OK, "Create success"));
        } catch (Exception e) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Please check your input data"));
        }

    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = RequestHelper.getJsonDataForm(request);
        int start = 0;
        int length = 10;
        String search = "";
        int draw = 1;
        int numberofcolumn = -1;
        int classId = -1;
        int orderColumn = 1;
        String orderDir = "asc";
        String statusFilter = "";
        List<DataTablesColumns> columns = new ArrayList<DataTablesColumns>();
        try {
            if (jsonObject != null) {
                start = jsonObject.getJSONArray("start").getInteger(0);
                length = jsonObject.getJSONArray("length").getInteger(0);
                search = jsonObject.getJSONArray("search[value]").getString(0);
                draw = jsonObject.getJSONArray("draw").getInteger(0);
                numberofcolumn = jsonObject.getJSONArray("numberOfColumns").getInteger(0);
                classId = jsonObject.getJSONArray("classId").getInteger(0);
                orderColumn = jsonObject.getJSONArray("order[0][column]").getInteger(0);
                orderDir = jsonObject.getJSONArray("order[0][dir]").getString(0);
                for (int i = 0; i <= numberofcolumn; i++) {
                    columns.add(new DataTablesColumns(
                            DTOHelper.convertToSnakeCase(
                                    jsonObject.getJSONArray("columns[" + i + "][data]").getString(0)),
                            jsonObject.getJSONArray("columns[" + i + "][name]").getString(0),
                            jsonObject.getJSONArray("columns[" + i + "][searchable]").getBoolean(0),
                            jsonObject.getJSONArray("columns[" + i + "][orderable]").getBoolean(0),
                            jsonObject.getJSONArray("columns[" + i + "][search][value]").getString(0),
                            jsonObject.getJSONArray("columns[" + i + "][search][regex]").getBoolean(0)));
                }
                for (DataTablesColumns dataTablesColumns : columns) {
                    if (dataTablesColumns.getData().equals("status_id")) {
                        statusFilter = dataTablesColumns.getSearchValue();
                    }
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        List<Trainee> list = userService.findAllByClassId(start, length, search, columns, orderColumn, orderDir,
                statusFilter,
                classId);
        int recordsTotal = userService.countAllByClassId(classId);
        int recordsFiltered = userService.countAllByClassId(search, statusFilter, classId);
        ResponseHelper.sendResponse(response, new DataTablesMessage(draw, recordsTotal, recordsFiltered, list));
    }

    private void list2(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int classId = 1;
        String q = "";
        int page = 1;
        try {
            JSONObject jsonObject = RequestHelper.getJsonData(request);
            DebugHelper.print(jsonObject);
            q = jsonObject.getString("q") == null ? "" : jsonObject.getString("q");
            page = jsonObject.getIntValue("page") == 0 ? 1 : jsonObject.getIntValue("page");
        } catch (Exception e) {
            DebugHelper.print(e);
        }
        try {
            int start = (page - 1) * 10;
            int length = 10;

            List<User> list = userService.findAll(start, length, q, null, 1, "asc", "26", "1");
            int recordsTotal = userService.countAll("", "26", "1");
            int recordsFiltered = userService.countAll(q, "26", "1");
            DataTablesMessage dataTablesMessage = new DataTablesMessage(0, recordsTotal, recordsFiltered, list);
            ResponseHelper.sendResponse(response,
                    dataTablesMessage);

        } catch (Exception e) {
            DebugHelper.print(e);
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Please check your input data"));
        }
    }

    private void addToClass(HttpServletResponse response, HttpServletRequest request)
            throws IOException {
        JSONObject data = RequestHelper.getJsonData(request);
        DebugHelper.print(data);
        int classId = data.getIntValue("classId");
        int userId = data.getIntValue("userId");

        User user = userService.findById(userId);
        if (user == null) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "User not found"));
            return;
        }

        Classroom classroom = classService.findClassById(classId);
        if (classroom == null) {
            ResponseHelper.sendResponse(response,
                    new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "Class not found"));
            return;
        }

        List<Trainee> list = userService.findAllByClassId(0, 9999, "", null, 1, "asc", "", classId);
        for (Trainee trainee : list) {
            if (trainee.getUserId() == userId) {
                ResponseHelper.sendResponse(response,
                        new ResponseMessage(HttpStatusCodeConstants.BAD_REQUEST, "User already in class"));
                return;
            }
        }

        classService.grantTraineeToClass(user, classId, 0);
        ResponseHelper.sendResponse(response,
                new ResponseMessage(HttpStatusCodeConstants.OK, "Add success"));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Classroom> myClass = new ArrayList<>();
        RoleConstants role = (RoleConstants) request.getAttribute("ROLE_CONSTANTS");
        User user = (User) request.getAttribute("user");
        if (role == RoleConstants.ADMIN) {
            myClass = classService.findAllClassroom();
        } else if (role == RoleConstants.STUDENT) {
            myClass = classService.findClassroomByStudent(user.getUserId());
        } else {
            myClass = classService.findClassroomByTeacher(user.getUserId());
        }
        request.setAttribute("myClass", myClass);
        request.setAttribute("jspPath", "shared/traineeList.jsp");
        request.setAttribute("customJs", ResponseHelper.customJs(
                "apps/user-management/trainee/table-edited.js",
                "apps/user-management/trainee/create-account.js"));
        request.setAttribute("brecrumbs", ResponseHelper.brecrumbs(
                ScreenConstants.USER_DASHBOARD,
                ScreenConstants.TRAINEE_LIST));
        request.getRequestDispatcher("/jsp/template.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
