package com.example.laba810.service.groupp;

import com.example.laba810.entity.Department;
import com.example.laba810.entity.Faculty;
import com.example.laba810.entity.Groupp;
import com.example.laba810.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GroupService implements GrouppServiceImpl{

    @Autowired
    private GroupRepository repository;

    @Override
    public Groupp saveGroup(Groupp groupp) {
        return repository.save(groupp);
    }

    @Override
    public List<Groupp> fetchGrouppList() {
        return (List<Groupp>) repository.findAll();
    }

    @Override
    public Groupp findGrouppById(Long grouppId) {
        return repository.findById(grouppId).orElse(null);
    }

    @Override
    public Groupp updateGroupp(Groupp groupp, Long grouppId) {

        Groupp tmp = repository.findById(grouppId).get();

        if (Objects.nonNull(groupp.getName())){
            tmp.setName(groupp.getName());
        }
        if (Objects.nonNull(groupp.getCourse())){
            tmp.setCourse(groupp.getCourse());
        }
        if (Objects.nonNull(groupp.getDepartment_id())){
            tmp.setDepartment_id(groupp.getDepartment_id());
        }

        return repository.save(tmp);
    }

    @Override
    public void deleteGrouppById(Long grouppId) {
        repository.deleteById(grouppId);
    }

    @Override
    public Department getDepartmentByGroupId(Long groupId) {
        Groupp needed = repository.findById(groupId).orElse(null);
        if (needed != null){
            return needed.getDepartment_id();
        }
        return null;
    }


}
