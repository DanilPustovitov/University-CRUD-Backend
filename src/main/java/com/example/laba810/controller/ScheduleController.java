package com.example.laba810.controller;


import com.example.laba810.entity.Discipline;
import com.example.laba810.entity.Groupp;
import com.example.laba810.entity.Schedule;
import com.example.laba810.entity.Teacher;
import com.example.laba810.service.groupp.GroupService;
import com.example.laba810.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService service;

    @CrossOrigin
    @GetMapping("/schedules")
    public List<Schedule> getAllSchedule(){
        return service.fetchScheduleList();
    }

    @CrossOrigin
    @GetMapping("/schedules/{id}")
    public Schedule getSchedulesById(@PathVariable("id") Long scheduleId){
        return service.findScheduleById(scheduleId);
    }

    @CrossOrigin
    @PostMapping("/schedules")
    public Schedule saveGroup(
            @RequestBody Schedule schedule)
    {
        return service.saveSchedule(schedule);
    }

    @CrossOrigin
    @PutMapping("/schedules/{id}")
    public Schedule
    updateGroup(@RequestBody Schedule schedule,
                @PathVariable("id") Long scheduleId)
    {
        return service.updateSchedule(
                schedule, scheduleId);
    }

    // Delete operation
    @CrossOrigin
    @DeleteMapping("/schedules/{id}")
    public String deleteSchedule(@PathVariable("id")
                                    Long scheduleId)
    {
        service.deleteScheduleById(
                scheduleId);
        return "Розклад видалений";
    }

    @CrossOrigin
    @GetMapping("/scheduleGroup/{id}")
    public Groupp getGroupByScheduleId(@PathVariable("id") Long scheduleId){
        return service.getGroupByScheduleId(scheduleId);
    }

    @CrossOrigin
    @GetMapping("/scheduleTeacher/{id}")
    public Teacher getTeacherByScheduleId(@PathVariable("id") Long scheduleId){
        return service.getTeacherByScheduleId(scheduleId);
    }

    @CrossOrigin
    @GetMapping("/scheduleDiscipline/{id}")
    public Discipline getDisciplineByScheduleId(@PathVariable("id") Long scheduleId){
        return service.getDisciplineByScheduleId(scheduleId);
    }
}
