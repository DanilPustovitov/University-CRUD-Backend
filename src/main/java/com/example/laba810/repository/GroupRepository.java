package com.example.laba810.repository;

import com.example.laba810.entity.Groupp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Groupp, Long> {
}
