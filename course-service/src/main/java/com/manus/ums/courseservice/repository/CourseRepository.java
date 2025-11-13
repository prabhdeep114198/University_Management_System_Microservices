package com.manus.ums.courseservice.repository;

import com.manus.ums.courseservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
}

