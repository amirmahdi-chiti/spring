package com.example.demo.Controller;

import com.example.demo.Model.Course;
import com.example.demo.Model.Instructor;
import com.example.demo.Service.CourseService;
import com.example.demo.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    InstructorService instructorService;

    @Autowired
    CourseService courseService;

    @PostMapping("/add/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> add(@RequestBody Course course, @PathVariable("id") long id){
        try {
            instructorService.addCourse(id,course);
            return ResponseEntity.ok("added");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/get/{id}")
    public void getCourses(@PathVariable("id") long id){
            System.out.println(instructorService.getCourses(id));
            System.out.println();
           // return instructorService.getCourses(id);

    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id){
        courseService.deleteById(id);
    }

    @GetMapping("/{id}/get")
    public void getCourse(@PathVariable("id") long id){
        Course course = courseService.getCourse(id);
        if (course!=null) {
            System.out.println(course);
            System.out.println(course.getReviews());
        }

    }



}
