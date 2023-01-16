package com.example.laba810.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import com.example.laba810.entity.Faculty;

import java.util.List;


@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference(value="faculty_id")
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty_id;

    @JsonManagedReference(value = "department_id")
    @OneToMany(mappedBy = "department_id")
    private List<Groupp> groupps;

/*

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="group_id")
    private Groupp group_id;
*/


    private String  name;

    private String short_name;


    public Department() {}

    public Department(Integer id, Faculty faculty, String name, String short_name) {
        this.id = id;
        this.faculty_id = faculty;
        this.name = name;
        this.short_name = short_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Faculty getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(Faculty faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }
}
