package com.example.laba810.service.schedule;

import com.example.laba810.entity.Discipline;
import com.example.laba810.entity.Groupp;
import com.example.laba810.entity.Schedule;
import com.example.laba810.entity.Teacher;

import java.util.List;

public interface ScheduleServiceImpl {
    Schedule saveSchedule(Schedule schedule);

    // Read operation
    List<Schedule> fetchScheduleList();

    Schedule findScheduleById(Long scheduleId);

    // Update operation
    Schedule updateSchedule(Schedule schedule, Long scheduleId);

    // Delete operation
    void deleteScheduleById(Long scheduleId);

    Groupp getGroupByScheduleId(Long scheduleId);

    Teacher getTeacherByScheduleId(Long scheduleId);

    Discipline getDisciplineByScheduleId(Long scheduleId);
}
