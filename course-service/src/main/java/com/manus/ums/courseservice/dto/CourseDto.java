package com.manus.ums.courseservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private Long id;
    private String title;
    private String code;
    private Long departmentId;
    private Long facultyId;
    private Long studentId;
    private Long courseId;
    private String grade;

    // Overloaded setters that accept Object:

    public void setStudentId(Object studentId) {
        if (studentId == null) {
            this.studentId = null;
            return;
        }
        this.studentId = Long.valueOf(studentId.toString());
    }

    public void setCourseId(Object courseId) {
        if (courseId == null) {
            this.courseId = null;
            return;
        }
        this.courseId = Long.valueOf(courseId.toString());
    }

    public void setGrade(Object grade) {
        if (grade == null) {
            this.grade = null;
            return;
        }
        this.grade = grade.toString();
    }
}
