package com.manus.ums.enrollmentservice.service;

import com.manus.ums.enrollmentservice.dto.EnrollmentDto;
import com.manus.ums.enrollmentservice.entity.Enrollment;
import com.manus.ums.enrollmentservice.feign.CourseServiceFeignClient;
import com.manus.ums.enrollmentservice.feign.StudentServiceFeignClient;
import com.manus.ums.enrollmentservice.repository.EnrollmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository repository;

    @Autowired
    private StudentServiceFeignClient studentClient;

    @Autowired
    private CourseServiceFeignClient courseClient;

    @Autowired
    private ModelMapper modelMapper;

    public EnrollmentDto enrollStudent(EnrollmentDto dto) {
        // Validate student and course existence via Feign Clients
        studentClient.getStudentById(dto.getStudentId());
        courseClient.getCourseById(dto.getCourseId());

        Enrollment entity = modelMapper.map(dto, Enrollment.class);
        Enrollment savedEntity = repository.save(entity);
        return modelMapper.map(savedEntity, EnrollmentDto.class);
    }

    public List<EnrollmentDto> getEnrollmentsByStudentId(Long studentId) {
        // Fetch student details to ensure student exists (or rely on the exception from the client)
        studentClient.getStudentById(studentId);

        return repository.findByStudentId(studentId).stream()
                .map(entity -> modelMapper.map(entity, EnrollmentDto.class))
                .collect(Collectors.toList());
    }

    public EnrollmentDto getEnrollmentById(Long id) {
        Enrollment entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));
        return modelMapper.map(entity, EnrollmentDto.class);
    }

    public List<EnrollmentDto> getAllEnrollments() {
        return repository.findAll().stream()
                .map(entity -> modelMapper.map(entity, EnrollmentDto.class))
                .collect(Collectors.toList());
    }

    public void deleteEnrollment(Long id) {
        repository.deleteById(id);
    }
}
