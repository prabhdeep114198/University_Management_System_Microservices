package com.manus.ums.enrollmentservice.controller;

import com.manus.ums.enrollmentservice.dto.EnrollmentDto;
import com.manus.ums.enrollmentservice.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService service;

    
    @PostMapping
    public ResponseEntity<EnrollmentDto> enrollStudent(@RequestBody EnrollmentDto dto) {
        return new ResponseEntity<>(service.enrollStudent(dto), HttpStatus.CREATED);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<EnrollmentDto>> getEnrollmentsByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.getEnrollmentsByStudentId(studentId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDto> getEnrollmentById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEnrollmentById(id));
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentDto>> getAllEnrollments() {
        return ResponseEntity.ok(service.getAllEnrollments());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        service.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }

}

