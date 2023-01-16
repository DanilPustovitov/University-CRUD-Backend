package com.example.laba810.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Groupp {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;


    private String name;

    private int course;

    @JsonBackReference(value = "department_id")
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department_id;


    @JsonManagedReference(value="group_id")
    @OneToMany(mappedBy = "group_id")
    private List<Student> students;

    @JsonManagedReference(value="group_id")
    @OneToMany(mappedBy = "group_id")
    private List<Schedule> schedules;

    public Groupp() {}

    public Groupp(String name, int course, Department department_id) {
        this.name = name;
        this.course = course;
        this.department_id = department_id;
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

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Department getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Department department_id) {
        this.department_id = department_id;
    }
}
