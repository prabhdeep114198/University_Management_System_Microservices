package com.manus.ums.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private Long id;
    private String name;
    private String code;

    private String firstName;
    private String lastName;
    private String email;
    private Long studentId;
    private Long departmentId;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setFirstName(Object firstName) {
        this.firstName = (String) firstName;
    }

    public void setLastName(Object lastName) {
        this.lastName = (String) lastName;
    }

    public void setEmail(Object email) {
        this.email = (String) email;
    }

    public void setStudentId(Object studentId) {
        this.studentId = (Long) studentId;
    }

    public void setDepartmentId(Object departmentId) {
        this.departmentId = (Long) departmentId;
    }
}
