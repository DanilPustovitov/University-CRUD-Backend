package com.example.laba810.service.teacher;

import com.example.laba810.entity.Student;
import com.example.laba810.entity.Teacher;
import com.example.laba810.repository.StudentRepository;
import com.example.laba810.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TeacherService implements TeacherServiceImpl {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> fetchTeacherList() {
        return (List<Teacher>)
                teacherRepository.findAll();
    }

    @Override
    public Teacher findTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId).orElse(null);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher, Long teacherId) {
        Teacher tmp = teacherRepository.findById(teacherId).get();

        if (Objects.nonNull(teacher.getName())){
                tmp.setName(teacher.getName());
        }
        if (Objects.nonNull(teacher.getSurname())){
            tmp.setSurname(teacher.getSurname());
        }

        if (Objects.nonNull(teacher.getEmail())) {
            tmp.setEmail(teacher.getEmail());
        }

        if (Objects.nonNull(teacher.getPhone())){
            tmp.setPhone(teacher.getPhone());
        }

        return teacherRepository.save(tmp);
    }

    @Override
    public void deleteTeacherById(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }
}
