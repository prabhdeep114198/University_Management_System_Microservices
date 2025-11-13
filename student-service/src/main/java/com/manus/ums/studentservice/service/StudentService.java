package com.manus.ums.studentservice.service;

import com.manus.ums.studentservice.dto.StudentDto;
import com.manus.ums.studentservice.entity.Student;
import com.manus.ums.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public StudentDto saveStudent(StudentDto dto) {
        Student entity = mapToEntity(dto);
        Student savedEntity = repository.save(entity);
        return mapToDto(savedEntity);
    }

    public StudentDto getStudentById(Long id) {
        Student entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return mapToDto(entity);
    }

    public List<StudentDto> getAllStudents() {
        return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    private Student mapToEntity(StudentDto dto) {
        Student entity = new Student();
        entity.setId(dto.getId());
        // Map fields
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getCode() != null) entity.setCode(dto.getCode());
        if (dto.getFirstName() != null) entity.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null) entity.setLastName(dto.getLastName());
        if (dto.getEmail() != null) entity.setEmail(dto.getEmail());
        if (dto.getStudentId() != null) entity.setStudentId(dto.getStudentId());
        if (dto.getDepartmentId() != null) entity.setDepartmentId(dto.getDepartmentId());
        return entity;
    }

    private StudentDto mapToDto(Student entity) {
        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        // Map fields
        if (entity.getName() != null) dto.setName(entity.getName());
        if (entity.getCode() != null) dto.setCode(entity.getCode());
        if (entity.getFirstName() != null) dto.setFirstName(entity.getFirstName());
        if (entity.getLastName() != null) dto.setLastName(entity.getLastName());
        if (entity.getEmail() != null) dto.setEmail(entity.getEmail());
        if (entity.getStudentId() != null) dto.setStudentId(entity.getStudentId());
        if (entity.getDepartmentId() != null) dto.setDepartmentId(entity.getDepartmentId());
        return dto;
    }
}

