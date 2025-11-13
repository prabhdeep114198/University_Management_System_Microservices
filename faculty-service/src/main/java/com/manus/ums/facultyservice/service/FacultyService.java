package com.manus.ums.facultyservice.service;

import com.manus.ums.facultyservice.dto.FacultyDto;
import com.manus.ums.facultyservice.entity.Faculty;
import com.manus.ums.facultyservice.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository repository;

    public FacultyDto saveFaculty(FacultyDto dto) {
        Faculty entity = mapToEntity(dto);
        Faculty savedEntity = repository.save(entity);
        return mapToDto(savedEntity);
    }

    public FacultyDto getFacultyById(Long id) {
        Faculty entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found with id: " + id));
        return mapToDto(entity);
    }

    public List<FacultyDto> getAllFacultys() {
        return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public void deleteFaculty(Long id) {
        repository.deleteById(id);
    }

    private Faculty mapToEntity(FacultyDto dto) {
        Faculty entity = new Faculty();
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

    private FacultyDto mapToDto(Faculty entity) {
        FacultyDto dto = new FacultyDto();
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

