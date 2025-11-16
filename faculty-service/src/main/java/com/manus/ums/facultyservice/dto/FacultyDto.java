package com.manus.ums.facultyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto {
    private Long id;
    private String firstName; private String lastName; private String email; private Long departmentId;
    public Object getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }
    public Object getCode() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCode'");
    }
    public Object getStudentId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudentId'");
    }
    public void setStudentId(Object studentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStudentId'");
    }
    public void setCode(Object code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCode'");
    }
    public void setName(Object name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }
}

