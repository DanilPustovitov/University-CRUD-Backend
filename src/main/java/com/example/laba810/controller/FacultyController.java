package com.example.laba810.controller;


import com.example.laba810.entity.Discipline;
import com.example.laba810.entity.Faculty;
import com.example.laba810.service.faculty.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacultyController {

    @Autowired
    private FacultyService service;

    @CrossOrigin
    @GetMapping("/faculties")
    public List<Faculty> getAllFaculties(){
        return service.fetchFacultyList();
    }

    @CrossOrigin
    @GetMapping("/faculties/{id}")
    public Faculty getFacultyById(@PathVariable("id") Long facultyId){
        return service.findFacultyById(facultyId);
    }

    @CrossOrigin
    @PostMapping("/faculties")
    public Faculty saveFaculty(
            @RequestBody Faculty faculty)
    {
        return service.saveFaculty(faculty);
    }

    @CrossOrigin
    @PutMapping("/faculties/{id}")
    public Faculty updateFaculty(@RequestBody Faculty faculty,
                                       @PathVariable("id") Long facultyId)
    {
        return service.updateFaculty(
                faculty, facultyId);
    }

    // Delete operation
    @CrossOrigin
    @DeleteMapping("/faculties/{id}")
    public String deleteFacultyById(@PathVariable("id")
                                       Long facultyId)
    {
        service.deleteFacultyById(
                facultyId);
        return "Факультет видалений";
    }
}
