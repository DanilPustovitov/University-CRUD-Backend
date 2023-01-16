package com.example.laba810.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference(value="group_id")
    @ManyToOne
    @JoinColumn(name="group_id")
    private Groupp group_id;

    private String name;

    private String email;

    private String phone;

    public Student() {}

    public Student(Integer id, Groupp group, String name, String email, String phone) {
        this.id = id;
        this.group_id = group;
        this.name = name;
        this.email = email;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Groupp getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Groupp group_id) {
        this.group_id = group_id;
    }
}

