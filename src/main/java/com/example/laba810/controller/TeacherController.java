package com.example.laba810.controller;


import com.example.laba810.entity.Student;
import com.example.laba810.entity.Teacher;
import com.example.laba810.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService service;

    @CrossOrigin
    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers(){
        return service.fetchTeacherList();
    }


    @CrossOrigin
    @GetMapping("/teachers/{id}")
    public Teacher getTeacherById(@PathVariable("id") Long teacherId){
        return service.findTeacherById(teacherId);
    }

    @CrossOrigin
    @PostMapping("/teachers")
    public Teacher saveTeacher(
            @RequestBody Teacher teacher)
    {
        return service.saveTeacher(teacher);
    }

    @CrossOrigin
    @PutMapping("/teachers/{id}")
    public Teacher updateTeacher(@RequestBody Teacher teacher,
                  @PathVariable("id") Long teacherId)
    {
        return service.updateTeacher(
                teacher, teacherId);
    }

    // Delete operation
    @CrossOrigin
    @DeleteMapping("/teachers/{id}")
    public String deleteTeacherById(@PathVariable("id")
                                    Long teacherId)
    {
        service.deleteTeacherById(
                teacherId);
        return "Викладач видалений";
    }
}
