package com.manus.ums.enrollmentservice.feign;

import com.manus.ums.enrollmentservice.dto.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COURSE-SERVICE")
public interface CourseServiceFeignClient {

    @GetMapping("/courses/{id}")
    CourseDto getCourseById(@PathVariable("id") Long id);
}

