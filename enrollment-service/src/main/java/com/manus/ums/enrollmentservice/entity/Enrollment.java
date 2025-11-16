package com.manus.ums.enrollmentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enrollments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentId; private Long courseId; private String grade;
    public void setTitle(Object title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTitle'");
    }
    public void setCode(Object code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCode'");
    }
    public void setDepartmentId(Object departmentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDepartmentId'");
    }
    public void setFacultyId(Object facultyId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFacultyId'");
    }
    public Object getTitle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTitle'");
    }
    public Object getCode() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCode'");
    }
    public Object getDepartmentId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDepartmentId'");
    }
    public Object getFacultyId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFacultyId'");
    }
}

