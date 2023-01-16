package com.example.laba810.controller;

import com.example.laba810.entity.Department;
import com.example.laba810.entity.Discipline;
import com.example.laba810.entity.Faculty;
import com.example.laba810.entity.Groupp;
import com.example.laba810.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService service;


    @CrossOrigin
    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return service.fetchDepartmentList();
    }

    @CrossOrigin
    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId){
        return service.findDepartmentById(departmentId);
    }

    @CrossOrigin
    @PostMapping("/departments")
    public Department saveDepartment(
            @RequestBody Department department)
    {
        return service.saveDepartment(department);
    }

    @CrossOrigin
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@RequestBody Department department,
                                       @PathVariable("id") Long departmentId)
    {
        return service.updateDepartment(
                department, departmentId);
    }

    // Delete operation
    @CrossOrigin
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentsById(@PathVariable("id")
                                       Long departmentId)
    {
        service.deleteDepartmentById(
                departmentId);
        return "Відділ видалений";
    }

    @CrossOrigin
    @GetMapping("/departmentFaculty/{id}")
    public Faculty getFacultyByDepartmentId(@PathVariable("id") Long departmentId){
        return service.getFacultyByDepartmentId(departmentId);
    }
}
