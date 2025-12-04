package com.manus.ums.studentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String studentId;

    private String name;        // department name?
    private String code;        // course or dep code?
    private Long departmentId;  // student's department

    public Object getName() {
        return name;
    }

    public Object getCode() {
        return code;
    }

    public Object getDepartmentId() {
        return departmentId;
    }

    public void setName(Object name) {
        this.name = (String) name;
    }

    public void setCode(Object code) {
        this.code = (String) code;
    }

    public void setDepartmentId(Object departmentId) {
        this.departmentId = (Long) departmentId;
    }
}
