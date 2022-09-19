package com.tss.constants;

public class RequestURIConstants {
    
    // Index servlet
    public static final String INDEX = "/";

    // Login servlet
    public static final String LOGIN = "/login";

    // Logout servlet
    public static final String LOGOUT = "/logout";

    // User servlet
    public static final String USER = "/user";

    // User profile
    public static final String USER_PROFILE = "/profile";

    // dashboard
    public static final String DASHBOARD = "/dashboard";

    // Assets
    public static final String ASSETS = "/assets";

    // List puclic access
    public static final String[] PUBLIC_ACCESS = {
        INDEX,
        LOGIN,
        ASSETS
    };

    // List all servlets
    public static final String[] ALL = {
        INDEX,
        LOGIN,
        LOGOUT,
        USER,
        USER_PROFILE,
        DASHBOARD,
        ASSETS
    };

}
