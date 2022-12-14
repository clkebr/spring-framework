package com.spring.controller;

import com.spring.dto.CourseDTO;
import com.spring.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2")
public class CourseController_ResponseEntity {
    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;

    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses(){

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version","Spring v2")
                .header("Operation", "Get List")
                .body(courseService.getCourses());
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") Long courseId){

        return ResponseEntity.ok(courseService.getCourseById(courseId));

    }
    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course){

        return ResponseEntity .status(201)
                .header("Version","Spring v2")
                .header("Operation", "Get List")
                .body(courseService.createCourse(course));
    }
}
