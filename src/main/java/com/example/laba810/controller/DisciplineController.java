    package com.example.laba810.controller;


import com.example.laba810.entity.Discipline;
import com.example.laba810.entity.Teacher;
import com.example.laba810.service.discipline.DisciplineService;
import com.example.laba810.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DisciplineController {
    @Autowired
    private DisciplineService service;

    @CrossOrigin
    @GetMapping("/disciplines")
    public List<Discipline> getAllDisciplines(){
        return service.fetchDisciplineList();
    }

    @CrossOrigin
    @GetMapping("/disciplines/{id}")
    public Discipline getDisciplineById(@PathVariable("id") Long disciplineId){
        return service.findDisciplineById(disciplineId);
    }

    @CrossOrigin
    @PostMapping("/disciplines")
    public Discipline saveDiscipline(
            @RequestBody Discipline discipline)
    {
        return service.saveDiscipline(discipline);
    }

    @CrossOrigin
    @PutMapping("/disciplines/{id}")
    public Discipline updateDiscipline(@RequestBody Discipline discipline,
                                 @PathVariable("id") Long disciplineId)
    {
        return service.updateDiscipline(
                discipline, disciplineId);
    }

    // Delete operation
    @CrossOrigin
    @DeleteMapping("/disciplines/{id}")
    public String deleteDisciplineById(@PathVariable("id")
                                    Long disciplineId)
    {
        service.deleteDisciplineById(
                disciplineId);
        return "Дисципліна видалена";
    }
}
