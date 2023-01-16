package com.example.laba810.service.schedule;

import com.example.laba810.entity.*;
import com.example.laba810.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class ScheduleService implements ScheduleServiceImpl{

    @Autowired
    public ScheduleRepository repository;

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        return repository.save(schedule);
    }

    @Override
    public List<Schedule> fetchScheduleList() {
        return (List<Schedule>) repository.findAll();
    }

    @Override
    public Schedule findScheduleById(Long scheduleId) {
        return repository.findById(scheduleId).orElse(null);
    }

    @Override
    public Schedule updateSchedule(Schedule schedule, Long scheduleId) {
        Schedule tmp = repository.findById(scheduleId).get();


        if (Objects.nonNull(schedule.getName())){
            tmp.setName(schedule.getName());
        }
        if (Objects.nonNull(schedule.getClassroom())){
            tmp.setClassroom(schedule.getClassroom());
        }
        if (Objects.nonNull(schedule.getDiscipline_id())){
            tmp.setDiscipline_id(schedule.getDiscipline_id());
        }
        if (Objects.nonNull(schedule.getGroup_id())){
            tmp.setGroup_id(schedule.getGroup_id());
        }

        if (Objects.nonNull(schedule.getTeacher_id())){
            tmp.setTeacher_id(schedule.getTeacher_id());
        }

        return repository.save(tmp);
    }

    @Override
    public void deleteScheduleById(Long scheduleId) {
        repository.deleteById(scheduleId);
    }

    @Override
    public Groupp getGroupByScheduleId(Long scheduleId) {
        Schedule needed = repository.findById(scheduleId).orElse(null);
        if (needed != null){
            return needed.getGroup_id();
        }
        return null;
    }

    @Override
    public Teacher getTeacherByScheduleId(Long scheduleId) {
        Schedule needed = repository.findById(scheduleId).orElse(null);
        if (needed != null){
            return needed.getTeacher_id();
        }
        return null;
    }

    @Override
    public Discipline getDisciplineByScheduleId(Long scheduleId) {
        Schedule needed = repository.findById(scheduleId).orElse(null);
        if (needed != null){
            return needed.getDiscipline_id();
        }
        return null;
    }
}
