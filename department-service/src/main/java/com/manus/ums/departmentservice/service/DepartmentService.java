package com.manus.ums.departmentservice.service;

import com.manus.ums.departmentservice.dto.DepartmentDto;
import com.manus.ums.departmentservice.entity.Department;
import com.manus.ums.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public DepartmentDto saveDepartment(DepartmentDto dto) {
        Department entity = mapToEntity(dto);
        Department savedEntity = repository.save(entity);
        return mapToDto(savedEntity);
    }

    public DepartmentDto getDepartmentById(Long id) {
        Department entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
        return mapToDto(entity);
    }

    public List<DepartmentDto> getAllDepartments() {
        return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public void deleteDepartment(Long id) {
        repository.deleteById(id);
    }

    private Department mapToEntity(DepartmentDto dto) {
        Department entity = new Department();
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

    private DepartmentDto mapToDto(Department entity) {
        DepartmentDto dto = new DepartmentDto();
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

