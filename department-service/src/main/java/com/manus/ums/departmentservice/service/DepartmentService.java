package com.manus.ums.departmentservice.service;

import com.manus.ums.departmentservice.dto.DepartmentDto;
import com.manus.ums.departmentservice.entity.Department;
import com.manus.ums.departmentservice.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public DepartmentDto saveDepartment(DepartmentDto dto) {
        Department entity = modelMapper.map(dto, Department.class);
        Department savedEntity = repository.save(entity);
        return modelMapper.map(savedEntity, DepartmentDto.class);
    }

    public DepartmentDto getDepartmentById(Long id) {
        Department entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
        return modelMapper.map(entity, DepartmentDto.class);
    }

    public List<DepartmentDto> getAllDepartments() {
        return repository.findAll().stream()
                .map(entity -> modelMapper.map(entity, DepartmentDto.class))
                .collect(Collectors.toList());
    }

    public void deleteDepartment(Long id) {
        repository.deleteById(id);
    }
}
