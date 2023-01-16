package com.example.laba810.controller;

import com.example.laba810.entity.Groupp;
import com.example.laba810.entity.Student;
import com.example.laba810.repository.StudentRepository;
import com.example.laba810.service.groupp.GroupService;
import com.example.laba810.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @CrossOrigin
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.fetchStudentList();
    }

    @CrossOrigin
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") Long studentId){
        return studentService.findStudentById(studentId);
    }

    @CrossOrigin
    @PostMapping("/students")
    public Student saveStudent(
             @RequestBody Student student)
    {
        return studentService.saveStudent(student);
    }

    @CrossOrigin
    @PutMapping("/students/{id}")
    public Student
    updateStudent(@RequestBody Student student,
                     @PathVariable("id") Long studentId)
    {
        return studentService.updateStudent(
                student, studentId);
    }

    // Delete operation
    @CrossOrigin
    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable("id")
                                       Long studentId)
    {
        studentService.deleteStudentById(
                studentId);
        return "Студент видалений";
    }

    @CrossOrigin
    @GetMapping("/studentGroup/{id}")
    public Groupp getGroupByStudentId(@PathVariable("id") Long studentId){
        return studentService.getGroupByStudentId(studentId);
    }
}
