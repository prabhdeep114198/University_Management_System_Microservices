package com.manus.ums.studentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String studentId;

    // Additional fields (if required)
    private String name;
    private String code;
    private Long departmentId;

    public void setName(Object name) {
        this.name = name == null ? null : name.toString();
    }

    public void setCode(Object code) {
        this.code = code == null ? null : code.toString();
    }

    public void setDepartmentId(Object departmentId) {
        this.departmentId = departmentId == null ? null : Long.valueOf(departmentId.toString());
    }

    public Object getName() {
        return name;
    }

    public Object getCode() {
        return code;
    }

    public Object getDepartmentId() {
        return departmentId;
    }
}
