package com.tss.service;

import com.tss.model.Trainee;
import com.tss.model.User;

public interface RegisterService {

    boolean register(User user);

    boolean registerUserWithGoogle(User user);

    boolean registerTraineeFromFile(Trainee user, String classroom);

    boolean registerUser(User user);
}
