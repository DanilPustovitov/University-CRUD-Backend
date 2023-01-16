package com.example.laba810.service.student;

import com.example.laba810.entity.Groupp;
import com.example.laba810.entity.Student;
import com.example.laba810.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService implements StudentServiceImplementation {
    @Autowired
    private StudentRepository studentRepository;

    // Save operation
    @Override
    public Student saveStudent(Student student)
    {
        return studentRepository.save(student);
    }

    // Read operation
    @Override
    public List<Student> fetchStudentList()
    {
        return (List<Student>)
                studentRepository.findAll();
    }

    @Override
    public Student findStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    // Update operation
    @Override
    public Student updateStudent(Student student, Long studentId)
    {
        Student studDB
                = studentRepository.findById(studentId)
                .get();

        if (Objects.nonNull(student.getName())
                && !"".equalsIgnoreCase(
                student.getName())) {
            studDB.setName(
                    student.getName());
        }

        if (Objects.nonNull(
                student.getEmail())
                && !"".equalsIgnoreCase(
                student.getEmail())) {
            studDB.setEmail(
                    student.getEmail());
        }

        if (Objects.nonNull(student.getPhone())
                && !"".equalsIgnoreCase(
                student.getPhone())) {
            studDB.setPhone(
                    student.getPhone());
        }

        studDB.setGroup_id(student.getGroup_id());

        return studentRepository.save(studDB);
    }

    // Delete operation
    @Override
    public void deleteStudentById(Long studentId)
    {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Groupp getGroupByStudentId(Long studentId) {
        Student needed = studentRepository.findById(studentId).orElse(null);
        if (needed != null){
            return needed.getGroup_id();
        }
        return null;
    }


}
