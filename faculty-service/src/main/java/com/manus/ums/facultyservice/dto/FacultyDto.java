package com.manus.ums.facultyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;

    private String name;
    private String code;
    private Long studentId;

    public Object getName() {
        return name;
    }

    public Object getCode() {
        return code;
    }

    public Object getStudentId() {
        return studentId;
    }

    public void setStudentId(Object studentId) {
        this.studentId = (Long) studentId;
    }

    public void setCode(Object code) {
        this.code = (String) code;
    }

    public void setName(Object name) {
        this.name = (String) name;
    }
}
