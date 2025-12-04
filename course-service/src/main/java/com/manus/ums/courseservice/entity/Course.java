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

    private String title;
    private String code;
    private Long departmentId;
    private Long facultyId;

    private Long studentId;
    private Long courseId;
    private String grade;

    public void setGrade(Object grade) {
        this.grade = grade != null ? grade.toString() : null;
    }

    public void setCourseId(Object courseId) {
        this.courseId = (courseId instanceof Number)
                ? ((Number) courseId).longValue()
                : courseId != null ? Long.valueOf(courseId.toString()) : null;
    }

    public void setStudentId(Object studentId) {
        this.studentId = (studentId instanceof Number)
                ? ((Number) studentId).longValue()
                : studentId != null ? Long.valueOf(studentId.toString()) : null;
    }

    public Object getStudentId() {
        return this.studentId;
    }

    public Object getCourseId() {
        return this.courseId;
    }

    public Object getGrade() {
        return this.grade;
    }
}
