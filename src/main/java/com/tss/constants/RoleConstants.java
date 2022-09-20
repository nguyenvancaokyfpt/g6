package com.tss.constants;

public enum RoleConstants {

        ADMIN(21, "ADMIN"),
        MANAGER(22, "MANAGER"),
        EXPERT(23, "EXPERT"),
        TRAINER(24, "TRAINER"),
        SUPPORTER(25, "SUPPORTER"),
        STUDENT(26, "STUDENT");

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
}