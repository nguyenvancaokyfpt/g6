package com.tss.service;

import java.util.List;

import com.tss.model.ClassEntity;
import com.tss.model.Classroom;
import com.tss.model.User;

public interface ClassService {
    List<Classroom> findAllClassroom();

    List<Classroom> findClassroomByStudent(int userId);

    List<Classroom> findClassroomByTeacher(int userId);

    List<ClassEntity> List();

    void grantTraineeToClass(User user, int classId, float f);

    Classroom findClassById(int classId);

    List<ClassEntity> ListCbxa();
}
