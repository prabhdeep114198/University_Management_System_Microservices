package com.manus.ums.departmentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    // Add missing fields
    private Long departmentId;
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;

    // Object-based setters (implemented properly)

    public void setDepartmentId(Object departmentId) {
        this.departmentId = departmentId == null ? null : Long.valueOf(departmentId.toString());
    }

    public void setStudentId(Object studentId) {
        this.studentId = studentId == null ? null : Long.valueOf(studentId.toString());
    }

    public void setFirstName(Object firstName) {
        this.firstName = firstName == null ? null : firstName.toString();
    }

    public void setLastName(Object lastName) {
        this.lastName = lastName == null ? null : lastName.toString();
    }

    public void setEmail(Object email) {
        this.email = email == null ? null : email.toString();
    }

    // Object-based getters (just return the fields)

    public Object getDepartmentId() {
        return departmentId;
    }

    public Object getStudentId() {
        return studentId;
    }

    public Object getFirstName() {
        return firstName;
    }

    public Object getLastName() {
        return lastName;
    }

    public Object getEmail() {
        return email;
    }
}
