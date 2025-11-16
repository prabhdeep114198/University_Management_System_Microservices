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
    private String name; private String code;
    public void setDepartmentId(Object departmentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDepartmentId'");
    }
    public void setStudentId(Object studentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStudentId'");
    }
    public void setLastName(Object lastName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLastName'");
    }
    public void setEmail(Object email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEmail'");
    }
    public void setFirstName(Object firstName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFirstName'");
    }
    public Object getFirstName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFirstName'");
    }
    public Object getLastName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLastName'");
    }
    public Object getEmail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
    }
    public Object getStudentId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudentId'");
    }
    public Object getDepartmentId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDepartmentId'");
    }
}

