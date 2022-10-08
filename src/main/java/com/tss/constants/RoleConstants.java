package com.tss.constants;

import java.util.ArrayList;
import java.util.List;

public enum RoleConstants {
        ROLE(1, "ROLE"),

        ADMIN(21, "ADMIN"),
        MANAGER(22, "MANAGER"),
        // EXPERT(23, "EXPERT"),
        TRAINER(24, "TRAINER"),
        SUPPORTER(25, "SUPPORTER"),
        STUDENT(26, "TRAINEE");

        private int id;
        private String title;

        RoleConstants(int id, String title) {
                this.id = id;
                this.title = title;
        }

        public int getId() {
                return id;
        }

        public String getTitle() {
                return title;
        }

        public static RoleConstants getRoleById(int id) {
                for (RoleConstants role : RoleConstants.values()) {
                        if (role.getId() == id) {
                                return role;
                        }
                }
                return null;
        }

        public static String getRoleTitle(int id) {
                for (RoleConstants role : RoleConstants.values()) {
                        if (role.getId() == id) {
                                return role.getTitle();
                        }
                }
                return null;
        }

        public static List<RoleConstants> getAllRole() {
                List<RoleConstants> roleList = new ArrayList<>();
                for (RoleConstants role : RoleConstants.values()) {
                        if (role.getId() != 1) {
                                roleList.add(role);
                        }
                }
                return roleList;
        }
}