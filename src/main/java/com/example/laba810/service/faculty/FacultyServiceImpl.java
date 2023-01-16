package com.example.laba810.service.faculty;

import com.example.laba810.entity.Discipline;
import com.example.laba810.entity.Faculty;

import java.util.List;

public interface FacultyServiceImpl {
    Faculty saveFaculty(Faculty faculty);

    // Read operation
    List<Faculty> fetchFacultyList();

    Faculty findFacultyById(Long facultyId);

    // Update operation
    Faculty updateFaculty(Faculty faculty, Long facultyId);

    // Delete operation
    void deleteFacultyById(Long facultyId);
}
