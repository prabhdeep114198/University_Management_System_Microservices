package com.manus.ums.courseservice.service;

import com.manus.ums.courseservice.dto.CourseDto;
import com.manus.ums.courseservice.entity.Course;
import com.manus.ums.courseservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.manus.ums.courseservice.feign.*; // Import all feign clients

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    
    public CourseDto saveCourse(CourseDto dto) {
        Course entity = mapToEntity(dto);
        Course savedEntity = repository.save(entity);
        return mapToDto(savedEntity);
    }

    public CourseDto getCourseById(Long id) {
        Course entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        return mapToDto(entity);
    }

    public List<CourseDto> getAllCourses() {
        return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }


    private Course mapToEntity(CourseDto dto) {
        Course entity = new Course();
        entity.setId(dto.getId());
        // Map fields
        if (dto.getTitle() != null) entity.setTitle(dto.getTitle());
        if (dto.getCode() != null) entity.setCode(dto.getCode());
        if (dto.getDepartmentId() != null) entity.setDepartmentId(dto.getDepartmentId());
        if (dto.getFacultyId() != null) entity.setFacultyId(dto.getFacultyId());
        if (dto.getStudentId() != null) entity.setStudentId(dto.getStudentId());
        if (dto.getCourseId() != null) entity.setCourseId(dto.getCourseId());
        if (dto.getGrade() != null) entity.setGrade(dto.getGrade());
        return entity;
    }

    private CourseDto mapToDto(Course entity) {
        CourseDto dto = new CourseDto();
        dto.setId(entity.getId());
        // Map fields
        if (entity.getTitle() != null) dto.setTitle(entity.getTitle());
        if (entity.getCode() != null) dto.setCode(entity.getCode());
        if (entity.getDepartmentId() != null) dto.setDepartmentId(entity.getDepartmentId());
        if (entity.getFacultyId() != null) dto.setFacultyId(entity.getFacultyId());
        if (entity.getStudentId() != null) dto.setStudentId(entity.getStudentId());
        if (entity.getCourseId() != null) dto.setCourseId(entity.getCourseId());
        if (entity.getGrade() != null) dto.setGrade(entity.getGrade());
        return dto;
    }
}

