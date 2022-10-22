package com.tss.service;

import java.util.Date;

public interface TraineeService {

    void dropout(int userId, Date dateDropout);

    void active(int userId);

    void deactive(int userId);

}
