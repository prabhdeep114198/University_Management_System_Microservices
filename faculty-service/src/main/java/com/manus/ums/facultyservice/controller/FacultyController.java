package com.manus.ums.facultyservice.controller;

import com.manus.ums.facultyservice.dto.FacultyDto;
import com.manus.ums.facultyservice.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService service;

    @PostMapping
    public ResponseEntity<FacultyDto> createFaculty(@RequestBody FacultyDto dto) {
        return new ResponseEntity<>(service.saveFaculty(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultyDto> getFacultyById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getFacultyById(id));
    }

    @GetMapping
    public ResponseEntity<List<FacultyDto>> getAllFacultys() {
        return ResponseEntity.ok(service.getAllFacultys());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacultyDto> updateFaculty(@PathVariable Long id, @RequestBody FacultyDto dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.saveFaculty(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        service.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }
}

