package com.tss.constants;

public enum ScreenConstants {
    // Public screen and api
    ASSETS(1000, "assets", "/assets"),
    INDEX(1001, "index", "/"),
    LOGIN(1002, "login", "/login"),
    LOGOUT(1003, "logout", "/logout"),
    REGISTER(1004, "register", "/register"),
    // Private screen
    USER_MANAGEMENT(1, "User Management", "/management/user"),
    USER_PROFILE(2, "Profile", "/profile"),
    USER_DASHBOARD(3, "Dashboard", "/dashboard"),
    
    USER_DETAIL(6, "User Detail", "/management/userdetails"),
    WEB_CONTACT(7, "Web Contact", "/webcontact/webcontactlist");

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
        return path.substring(0, path.lastIndexOf("/"));
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

}
