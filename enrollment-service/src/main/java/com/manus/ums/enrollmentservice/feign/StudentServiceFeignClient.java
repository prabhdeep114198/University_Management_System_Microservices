package com.manus.ums.enrollmentservice.feign;

import com.manus.ums.enrollmentservice.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STUDENT-SERVICE")
public interface StudentServiceFeignClient {

    @GetMapping("/students/{id}")
    StudentDto getStudentById(@PathVariable("id") Long id);
}

