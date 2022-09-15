package com.tss.service;

public interface LoginService {

    /**
     * @param username
     * @param password
     * @return boolean
     */
    boolean login(String username, String password);
    
}
