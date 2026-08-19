package com.manus.ums.studentservice.service;

import com.manus.ums.studentservice.dto.StudentDto;
import com.manus.ums.studentservice.entity.Student;
import com.manus.ums.studentservice.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public StudentDto saveStudent(StudentDto dto) {
        Student entity = modelMapper.map(dto, Student.class);
        Student saved = repository.save(entity);
        return modelMapper.map(saved, StudentDto.class);
    }

    public StudentDto getStudentById(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return modelMapper.map(student, StudentDto.class);
    }

    public List<StudentDto> getAllStudents() {
        return repository.findAll().stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
