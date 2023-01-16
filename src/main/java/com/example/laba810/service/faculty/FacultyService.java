package com.example.laba810.service.faculty;


import com.example.laba810.entity.Discipline;
import com.example.laba810.entity.Faculty;
import com.example.laba810.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FacultyService implements FacultyServiceImpl{

    @Autowired
    private FacultyRepository repository;

    @Override
    public Faculty saveFaculty(Faculty faculty) {
        return repository.save(faculty);
    }

    @Override
    public List<Faculty> fetchFacultyList() {
        return (List<Faculty>) repository.findAll();
    }

    @Override
    public Faculty findFacultyById(Long facultyId) {
        return repository.findById(facultyId).orElse(null);
    }

    @Override
    public Faculty updateFaculty(Faculty faculty, Long facultyId) {
        Faculty tmp = repository.findById(facultyId).get();

        if (Objects.nonNull(faculty.getName())){
            tmp.setName(faculty.getName());
        }

        if (Objects.nonNull(faculty.getShort_name())) {
            tmp.setShort_name(faculty.getShort_name());
        }
        return repository.save(tmp);
    }

    @Override
    public void deleteFacultyById(Long facultyId) {
        repository.deleteById(facultyId);
    }
}
