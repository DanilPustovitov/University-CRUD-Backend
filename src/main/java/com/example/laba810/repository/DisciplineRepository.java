package com.example.laba810.repository;

import com.example.laba810.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
