package com.example.demo.Controller;

import com.example.demo.Model.Instructor;
import com.example.demo.Model.Instructor_detail;
import com.example.demo.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    InstructorService instructorService;


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Instructor instructor){
        Instructor_detail instructor_detail = new Instructor_detail("youtube.com", "video games");
        instructor.setInstructor_detail(instructor_detail);
        System.out.println("///////////////////////");
        instructorService.add(instructor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id ){
        instructorService.deleteById(id);
        return ResponseEntity.ok("deleted");
    }


}
