package com.manus.ums.courseservice.service;

import com.manus.ums.courseservice.dto.CourseDto;
import com.manus.ums.courseservice.entity.Course;
import com.manus.ums.courseservice.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public CourseDto saveCourse(CourseDto dto) {
        Course entity = modelMapper.map(dto, Course.class);
        Course savedEntity = repository.save(entity);
        return modelMapper.map(savedEntity, CourseDto.class);
    }

    public CourseDto getCourseById(Long id) {
        Course entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        return modelMapper.map(entity, CourseDto.class);
    }

    public List<CourseDto> getAllCourses() {
        return repository.findAll().stream()
                .map(entity -> modelMapper.map(entity, CourseDto.class))
                .collect(Collectors.toList());
    }

    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }
}
