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

    private String name;        // department name
    private String code;        // department/course code
    private Long departmentId;  // student's department
}
