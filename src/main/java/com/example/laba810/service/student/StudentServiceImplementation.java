package com.example.laba810.service.student;

import com.example.laba810.entity.Groupp;
import com.example.laba810.entity.Student;

import java.util.List;

public interface StudentServiceImplementation {
    // Save operation
    Student saveStudent(Student teacher);

    // Read operation
    List<Student> fetchStudentList();

    Student findStudentById(Long studentId);

    // Update operation
    Student updateStudent(Student student, Long studentId);

    // Delete operation
    void deleteStudentById(Long studentId);

    Groupp getGroupByStudentId(Long studentId);
}
