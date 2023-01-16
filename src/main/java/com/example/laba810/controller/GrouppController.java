package com.example.laba810.controller;

import com.example.laba810.entity.Department;
import com.example.laba810.entity.Faculty;
import com.example.laba810.entity.Groupp;
import com.example.laba810.entity.Student;
import com.example.laba810.service.groupp.GroupService;
import com.example.laba810.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GrouppController {

    @Autowired
    private GroupService service;

    @CrossOrigin
    @GetMapping("/groups")
    public List<Groupp> getAllGroups(){
        return service.fetchGrouppList();
    }


    @CrossOrigin
    @GetMapping("/groups/{id}")
    public Groupp getGroupById(@PathVariable("id") Long grouppId){
        return service.findGrouppById(grouppId);
    }

    @CrossOrigin
    @PostMapping("/groups")
    public Groupp saveGroup(
            @RequestBody Groupp groupp)
    {
        return service.saveGroup(groupp);
    }


    @CrossOrigin
    @PutMapping("/groups/{id}")
    public Groupp
    updateGroup(@RequestBody Groupp groupp,
                  @PathVariable("id") Long grouppId)
    {
        return service.updateGroupp(
                groupp, grouppId);
    }

    // Delete operation
    @CrossOrigin
    @DeleteMapping("/groups/{id}")
    public String deleteStudentById(@PathVariable("id")
                                    Long groupId)
    {
        service.deleteGrouppById(
                groupId);
        return "Група видалена";
    }

    @CrossOrigin
    @GetMapping("/groupDepartment/{id}")
    public Department getDepartmentByGroupId(@PathVariable("id") Long groupId){
        return service.getDepartmentByGroupId(groupId);
    }

}
