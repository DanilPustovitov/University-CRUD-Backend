package com.example.laba810.service.discipline;

import com.example.laba810.entity.Discipline;
import com.example.laba810.entity.Teacher;

import java.util.List;

public interface DisciplineServiceImpl {

    Discipline saveDiscipline(Discipline discipline);

    // Read operation
    List<Discipline> fetchDisciplineList();

    Discipline findDisciplineById(Long disciplineId);

    // Update operation
    Discipline updateDiscipline(Discipline discipline, Long disciplineId);

    // Delete operation
    void deleteDisciplineById(Long disciplineId);
}
