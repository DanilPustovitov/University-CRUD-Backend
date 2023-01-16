package com.example.laba810.service.discipline;


import com.example.laba810.entity.Discipline;
import com.example.laba810.entity.Teacher;
import com.example.laba810.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DisciplineService implements DisciplineServiceImpl {
    @Autowired
    private DisciplineRepository repository;

    @Override
    public Discipline saveDiscipline(Discipline discipline) {
        return repository.save(discipline);
    }

    @Override
    public List<Discipline> fetchDisciplineList() {
        return (List<Discipline>) repository.findAll();
    }

    @Override
    public Discipline findDisciplineById(Long disciplineId) {
        return repository.findById(disciplineId).orElse(null);
    }

    @Override
    public Discipline updateDiscipline(Discipline discipline, Long disciplineId) {
        Discipline tmp = repository.findById(disciplineId).get();

        if (Objects.nonNull(discipline.getName())){
            tmp.setName(discipline.getName());
        }

        return repository.save(tmp);
    }

    @Override
    public void deleteDisciplineById(Long disciplineId) {
        repository.deleteById(disciplineId);
    }
}
