package com.tss.service;

import java.util.Date;

import com.tss.model.Trainee;

public interface TraineeService {

    void dropout(int userId, Date dateDropout);

    void active(int userId);

    void deactive(int userId);

    Trainee getTraineeById(int id);

    Trainee getTraineeByTraineeIdAndClassId(int id, int classId);

    void update(Trainee trainee);

    void updateClassUser(Trainee trainee);

}
