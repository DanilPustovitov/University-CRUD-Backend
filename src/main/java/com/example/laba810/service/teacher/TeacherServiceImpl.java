package com.example.laba810.service.teacher;

import com.example.laba810.entity.Student;
import com.example.laba810.entity.Teacher;

import java.util.List;

public interface TeacherServiceImpl {
    Teacher saveTeacher(Teacher teacher);

    // Read operation
    List<Teacher> fetchTeacherList();

    Teacher findTeacherById(Long teacherId);

    // Update operation
    Teacher updateTeacher(Teacher teacher, Long teacherId);

    // Delete operation
    void deleteTeacherById(Long teacherId);
}
