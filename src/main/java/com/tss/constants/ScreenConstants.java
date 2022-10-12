package com.tss.constants;

public enum ScreenConstants {
    // Public screen and api
    ASSETS(1000, "assets", "/assets"),
    INDEX(1001, "index", "/"),
    LOGIN(1002, "login", "/login"),
    LOGOUT(1003, "logout", "/logout"),
    REGISTER(1004, "register", "/register"),
    LOGIN_WITH_GOOGLE(1005, "loginWithGoogle", "/loginWithGoogle"),
    RESET_PASSWORD(1006, "resetPassword", "/resetPassword"),
    CAPTCHA_GENERATOR(1007, "Captcha generate", "/captchaGenerator"),
    UPLOAD_FILE(1008, "Upload file", "/upload"),


    // Private screen
    USER_MANAGEMENT(1, "User Management", "/management/user"),
    USER_PROFILE(2, "User Profile", "/profile"),
    USER_DASHBOARD(3, "Dashboard", "/dashboard"),
    SETTING_SYSTEM_LIST(4, "Setting System", "/setting/system"),
    SETTING_SYSTEM_DETAIL(5, "Setting Detail", "/setting/system/detail"),
    USER_DETAILS_MANAGEMENT(6, "User Detail", "/management/user/detail"),
    WEB_CONTACT_LIST(7, "Web Contact List", "/webcontact/list"),
    SUBJECT_LIST(10, "Subject List", "/subject/list"),
    SUBJECT_DETAILS(11, "Subject Details", "/subject/detail"),
    SETTING_ROLE_PERMISSIONS(12, "Setting Role Permissions", "/setting/role/permissions"),
    SETTING_CLASS(13, "Setting Class", "/setting/class"),
    SETTING_CLASS_DETAIL(14, "Setting Class Detail", "/setting/class/detail"),
    SUBJECT_SETTING(20, "Subject Setting", "/subject/setting"),
    ASSIGNNMENT_LIST(22, "Assignment List", "/assignment/list"),
    EVALCRITERIA_LIST(16, "Eval Criteria List", "/evalCriteria/evalCriteriaList"),
    EVALCRITERIA_DETAIL(17, "Eval Criteria Detail", "/evalCriteria/evalCriteriaDetails");



    private int id;
    private String title;
    private String path;

    ScreenConstants(int id, String title, String path) {
        this.id = id;
        this.title = title;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }

    public String getParentPath() {
        String[] paths = path.split("/");
        return "/" + paths[1];
    }

    public static ScreenConstants getScreenById(int id) {
        for (ScreenConstants screen : ScreenConstants.values()) {
            if (screen.getId() == id) {
                return screen;
            }
        }
        return null;
    }

    // all screen
    public static ScreenConstants[] allScreen() {
        return ScreenConstants.values();
    }

    // all public screen
    public static ScreenConstants[] publicScreen() {
        int count = 0;
        for (ScreenConstants screen : ScreenConstants.values()) {
            if (screen.getId() >= 1000) {
                count++;
            }
        }
        ScreenConstants[] publicScreen = new ScreenConstants[count];
        int index = 0;
        for (ScreenConstants screen : ScreenConstants.values()) {
            if (screen.getId() >= 1000) {
                publicScreen[index] = screen;
                index++;
            }
        }
        return publicScreen;
    }

    // all private screen
    public static ScreenConstants[] privateScreen() {
        int count = 0;
        for (ScreenConstants screen : ScreenConstants.values()) {
            if (screen.getId() < 1000) {
                count++;
            }
        }
        ScreenConstants[] privateScreen = new ScreenConstants[count];
        int index = 0;
        for (ScreenConstants screen : ScreenConstants.values()) {
            if (screen.getId() < 1000) {
                privateScreen[index] = screen;
                index++;
            }
        }
        return privateScreen;
    }

    // find screen by path
    public static ScreenConstants findScreenByPath(String path) {
        for (ScreenConstants screen : ScreenConstants.values()) {
            if (screen.getPath().equals(path)) {
                return screen;
            }
        }
        return null;
    }

}
