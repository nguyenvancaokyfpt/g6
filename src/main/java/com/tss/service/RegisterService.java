package com.tss.service;

import com.tss.model.User;

public interface RegisterService {

    boolean register(User user);

    boolean registerUserWithGoogle(User user);

}
