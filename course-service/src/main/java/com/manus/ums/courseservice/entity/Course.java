package com.manus.ums.courseservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title; private String code; private Long departmentId; private Long facultyId;
    public void setGrade(Object grade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setGrade'");
    }
    public void setCourseId(Object courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCourseId'");
    }
    public void setStudentId(Object studentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStudentId'");
    }
    public Object getStudentId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudentId'");
    }
    public Object getCourseId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCourseId'");
    }
    public Object getGrade() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGrade'");
    }
}

