package com.manus.ums.facultyservice.service;

import com.manus.ums.facultyservice.dto.FacultyDto;
import com.manus.ums.facultyservice.entity.Faculty;
import com.manus.ums.facultyservice.repository.FacultyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public FacultyDto saveFaculty(FacultyDto dto) {
        Faculty entity = modelMapper.map(dto, Faculty.class);
        Faculty savedEntity = repository.save(entity);
        return modelMapper.map(savedEntity, FacultyDto.class);
    }

    public FacultyDto getFacultyById(Long id) {
        Faculty entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found with id: " + id));
        return modelMapper.map(entity, FacultyDto.class);
    }

    public List<FacultyDto> getAllFacultys() {
        return repository.findAll().stream()
                .map(entity -> modelMapper.map(entity, FacultyDto.class))
                .collect(Collectors.toList());
    }

    public void deleteFaculty(Long id) {
        repository.deleteById(id);
    }
}
