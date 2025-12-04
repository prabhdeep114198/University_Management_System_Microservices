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

    private Long studentId;
    private Long courseId;
    private String grade;

    // Additional fields (if required)
    private String title;
    private String code;
    private Long departmentId;
    private Long facultyId;

    public void setTitle(Object title) {
        this.title = title == null ? null : title.toString();
    }

    public void setCode(Object code) {
        this.code = code == null ? null : code.toString();
    }

    public void setDepartmentId(Object departmentId) {
        this.departmentId = departmentId == null ? null : Long.valueOf(departmentId.toString());
    }

    public void setFacultyId(Object facultyId) {
        this.facultyId = facultyId == null ? null : Long.valueOf(facultyId.toString());
    }

    public Object getTitle() {
        return title;
    }

    public Object getCode() {
        return code;
    }

    public Object getDepartmentId() {
        return departmentId;
    }

    public Object getFacultyId() {
        return facultyId;
    }
}
