package com.tss.service;

import java.util.List;

import com.tss.model.ClassEntity;
import com.tss.model.Classroom;

public interface ClassService {
    List<Classroom> findAllClassroom();

    List<Classroom> findClassroomByStudent(int userId);

    List<Classroom> findClassroomByTeacher(int userId);

    List<ClassEntity> List();
    
    List<ClassEntity> ListCbxa();
}
