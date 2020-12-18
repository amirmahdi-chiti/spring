package com.example.demo.Controller;

import com.example.demo.Doctor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/managment/security")
public class ManagementSecurity {

    public static final List<Doctor> DOCTORS = Arrays.asList(
            new Doctor(1,"james bond"),
            new Doctor(2,"amirmahdi chiti"),
            new Doctor(3,"reza rezaii")
    );
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public List<Doctor> getAllDoctors(){
        return DOCTORS;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('doctor:write')")
    public void insertDoctor(@RequestBody Doctor doctor){
        System.out.println(doctor);
    }

    @DeleteMapping(path = "{doctorId}")
    @PreAuthorize("hasAuthority('doctor:write')")
    public void deleteDoctor(@PathVariable("doctorId") long id){
        System.out.println("doctor_id: " + id);
    }

    @PutMapping(path = "{doctorId}")
    @PreAuthorize("hasAuthority('doctor:write')")
    public void updateDoctor(@RequestBody Doctor doctor,@PathVariable("doctorId") long id){
        System.out.println("doctor_id: "+id);
        System.out.println(doctor);
    }

    


}
