package com.manus.ums.facultyservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "facultys")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;

    // Extra fields for unwanted methods
    private String name;
    private String code;
    private Long studentId;

    public void setName(Object name) {
        this.name = name == null ? null : name.toString();
    }

    public void setCode(Object code) {
        this.code = code == null ? null : code.toString();
    }

    public void setStudentId(Object studentId) {
        this.studentId = studentId == null ? null : Long.valueOf(studentId.toString());
    }

    public Object getName() {
        return name;
    }

    public Object getCode() {
        return code;
    }

    public Object getStudentId() {
        return studentId;
    }
}
