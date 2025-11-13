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
}

