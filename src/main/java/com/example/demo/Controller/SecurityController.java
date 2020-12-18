package com.example.demo.Controller;

import com.example.demo.Doctor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/security")
public class SecurityController {


    public static final List<Doctor> DOCTORS = Arrays.asList(
            new Doctor(1,"james bond"),
            new Doctor(2,"amirmahdi chiti"),
            new Doctor(3,"reza rezaii")
    );

    @GetMapping("/doctor/{id}")
    public Doctor getDoctor(@PathVariable("id") long id){
        return DOCTORS.stream().filter(doctor -> doctor.getId() == id).
                findFirst().orElseThrow(() -> new IllegalStateException("Doctor " + id));
    }

}
