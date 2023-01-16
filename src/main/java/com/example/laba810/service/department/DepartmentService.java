package com.example.laba810.service.department;


import com.example.laba810.entity.Department;
import com.example.laba810.entity.Faculty;
import com.example.laba810.entity.Student;
import com.example.laba810.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentService implements DepartmentServiceImpl{

    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return (List<Department>) repository.findAll();
    }

    @Override
    public Department findDepartmentById(Long departmentId) {
        return repository.findById(departmentId).orElse(null);
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId) {
        Department tmp = repository.findById(departmentId).get();


        if (Objects.nonNull(department.getName())){
            tmp.setName(department.getName());
        }
        if (Objects.nonNull(department.getShort_name())){
            tmp.setShort_name(department.getShort_name());
        }
        tmp.setFaculty_id(department.getFaculty_id());

        return repository.save(tmp);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        repository.deleteById(departmentId);
    }

    @Override
    public Faculty getFacultyByDepartmentId(Long departmentId) {
        Department needed = repository.findById(departmentId).orElse(null);
        if (needed != null){
            return needed.getFaculty_id();
        }
        return null;
    }
}
