package com.manus.ums.enrollmentservice.service;

import com.manus.ums.enrollmentservice.dto.EnrollmentDto;
import com.manus.ums.enrollmentservice.entity.Enrollment;
import com.manus.ums.enrollmentservice.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.manus.ums.enrollmentservice.feign.*; // Import all feign clients

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository repository;

    
    @Autowired
    private StudentServiceFeignClient studentClient;
    @Autowired
    private CourseServiceFeignClient courseClient;

    public EnrollmentDto enrollStudent(EnrollmentDto dto) {
        // Validate student and course existence via Feign Clients
        studentClient.getStudentById(dto.getStudentId());
        courseClient.getCourseById(dto.getCourseId());

        Enrollment entity = mapToEntity(dto);
        Enrollment savedEntity = repository.save(entity);
        return mapToDto(savedEntity);
    }

    public List<EnrollmentDto> getEnrollmentsByStudentId(Long studentId) {
        // Fetch student details to ensure student exists (or rely on the exception from the client)
        studentClient.getStudentById(studentId);

        return repository.findByStudentId(studentId).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public EnrollmentDto getEnrollmentById(Long id) {
        Enrollment entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));
        return mapToDto(entity);
    }

    public List<EnrollmentDto> getAllEnrollments() {
        return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public void deleteEnrollment(Long id) {
        repository.deleteById(id);
    }


    private Enrollment mapToEntity(EnrollmentDto dto) {
        Enrollment entity = new Enrollment();
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

    private EnrollmentDto mapToDto(Enrollment entity) {
        EnrollmentDto dto = new EnrollmentDto();
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

