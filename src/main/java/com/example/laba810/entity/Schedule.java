package com.example.laba810.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JsonBackReference(value="teacher_id")
    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher_id;

    @JsonBackReference(value="discipline_id")
    @ManyToOne
    @JoinColumn(name="discipline_id")
    private Discipline discipline_id;

    @JsonBackReference(value="group_id")
    @ManyToOne
    @JoinColumn(name="group_id")
    private Groupp group_id;

    private String time;

    private String classroom;

    public Schedule() {}

    public Schedule(Integer id, String name, Teacher teacher, Discipline discipline, Groupp group, String time, String classroom) {
        this.id = id;
        this.name = name;
        this.teacher_id = teacher;
        this.discipline_id = discipline;
        this.group_id = group;
        this.time = time;
        this.classroom = classroom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Teacher teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Discipline getDiscipline_id() {
        return discipline_id;
    }

    public void setDiscipline_id(Discipline discipline_id) {
        this.discipline_id = discipline_id;
    }

    public Groupp getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Groupp group_id) {
        this.group_id = group_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
