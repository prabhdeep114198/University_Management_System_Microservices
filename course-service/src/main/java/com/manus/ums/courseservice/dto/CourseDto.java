package com.manus.ums.courseservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Long id;
    private String title; private String code; private Long departmentId; private Long facultyId;
    public Object getGrade() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGrade'");
    }
    public Object getCourseId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCourseId'");
    }
    public Object getStudentId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudentId'");
    }
    public void setStudentId(Object studentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStudentId'");
    }
    public void setGrade(Object grade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setGrade'");
    }
    public void setCourseId(Object courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCourseId'");
    }
}

