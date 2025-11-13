package com.manus.ums.facultyservice.repository;

import com.manus.ums.facultyservice.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}

