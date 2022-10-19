package com.tss.service;

public interface LoginService {

    /**
     * @param email
     * @param password
     * @return boolean
     */
    boolean login(String email, String password);

}
