package com.example.demo.Controller;

import com.example.demo.Model.Instructor;
import com.example.demo.Model.Instructor_detail;
import com.example.demo.Repository.InstructorDetailRepository;
import com.example.demo.Service.InstructorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructorDetail")
public class InstructorDetailController {

    @Autowired
    InstructorDetailService instructorDetailService;

    @GetMapping("/get/{id}")
    public Instructor_detail getInstructorDetail(@PathVariable("id") long id){
        return instructorDetailService.getById(id);
    }

    @GetMapping("/getInstructor/{id}")
    public Instructor getInstructor(@PathVariable("id") long id){
        return instructorDetailService.getInstructorByInstructorDetail(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInstructorDetail(@PathVariable("id") long id){
        Boolean delete = instructorDetailService.delete(id);
        if (delete) return ResponseEntity.ok("deleted");
        return ResponseEntity.notFound().build();
    }

}
