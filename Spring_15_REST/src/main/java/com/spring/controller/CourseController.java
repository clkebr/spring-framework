package com.spring.controller;

import com.spring.dto.CourseDTO;
import com.spring.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){

        List<CourseDTO> courses = courseService.getCourses();
        return courses;
    }

    @GetMapping("{id}")
    public CourseDTO getAllCoursesById(@PathVariable("id") Long id){

       return courseService.getCourseById(id);

    }

    @GetMapping("/category/{name}")
    public List<CourseDTO> getAllCoursesByCategory(@PathVariable("name") String category){
       return courseService.getCoursesByCategory(category);

    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course){
        return courseService.createCourse(course);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") Long id,@RequestBody CourseDTO course){
        courseService.updateCourse(id,course);
    }

    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourseById(id);
    }

    @DeleteMapping
    public void deleteAllCourses(){
        courseService.deleteCourses();
    }
}
