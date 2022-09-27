package com.tss.helper;

public class DTOHelper {
    // convert userId to user_id
    public static String convertToSnakeCase(String camelCase) {
        String snakeCase = "";
        for (int i = 0; i < camelCase.length(); i++) {
            char c = camelCase.charAt(i);
            if (Character.isUpperCase(c)) {
                snakeCase += "_" + Character.toLowerCase(c);
            } else {
                snakeCase += c;
            }
        }
        return snakeCase;
    }
}
