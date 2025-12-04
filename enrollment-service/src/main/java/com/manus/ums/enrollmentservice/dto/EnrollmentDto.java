package com.manus.ums.enrollmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDto {
    private Long id;
    private Long studentId;
    private Long courseId;
    private String grade;

    private String title;
    private String code;
    private Long departmentId;
    private Long facultyId;

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setTitle(Object title) {
        this.title = (String) title;
    }

    public void setDepartmentId(Object departmentId) {
        this.departmentId = (Long) departmentId;
    }

    public void setFacultyId(Object facultyId) {
        this.facultyId = (Long) facultyId;
    }

    public void setCode(Object code) {
        this.code = (String) code;
    }
}
