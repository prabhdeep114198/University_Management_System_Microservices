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
        Student saved = repository.save(entity);
        return mapToDto(saved);
    }

    public StudentDto getStudentById(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return mapToDto(student);
    }

    public List<StudentDto> getAllStudents() {
        return repository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    private Student mapToEntity(StudentDto dto) {
        Student entity = new Student();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setStudentId(dto.getStudentId());
        entity.setDepartmentId(dto.getDepartmentId());
        return entity;
    }

    private StudentDto mapToDto(Student entity) {
        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setStudentId(entity.getStudentId());
        dto.setDepartmentId(entity.getDepartmentId());
        return dto;
    }
}
