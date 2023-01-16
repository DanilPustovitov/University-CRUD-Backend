package com.example.laba810.service.groupp;

import com.example.laba810.entity.Department;
import com.example.laba810.entity.Faculty;
import com.example.laba810.entity.Groupp;
import com.example.laba810.entity.Student;

import java.util.List;

public interface GrouppServiceImpl {
    Groupp saveGroup(Groupp groupp);

    // Read operation
    List<Groupp> fetchGrouppList();

    Groupp findGrouppById(Long grouppId);

    // Update operation
    Groupp updateGroupp(Groupp groupp, Long grouppId);

    // Delete operation
    void deleteGrouppById(Long grouppId);

    Department getDepartmentByGroupId(Long groupId);
}
