package com.manus.ums.enrollmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDto {
    private Long id;
    private Long studentId; private Long courseId; private String grade;
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
    public void setTitle(Object title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTitle'");
    }
    public void setDepartmentId(Object departmentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDepartmentId'");
    }
    public void setFacultyId(Object facultyId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFacultyId'");
    }
    public void setCode(Object code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCode'");
    }
}

