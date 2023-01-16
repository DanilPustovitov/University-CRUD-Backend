package com.example.laba810.service.department;


import com.example.laba810.entity.Department;
import com.example.laba810.entity.Faculty;
import com.example.laba810.entity.Groupp;

import java.util.List;

public interface DepartmentServiceImpl {
    Department saveDepartment(Department department);

    // Read operation
    List<Department> fetchDepartmentList();

    Department findDepartmentById(Long departmentId);

    // Update operation
    Department updateDepartment(Department department, Long departmentId);

    // Delete operation
    void deleteDepartmentById(Long departmentId);

    Faculty getFacultyByDepartmentId(Long departmentId);
}
