package com.example.demo.Service;

import com.example.demo.Model.Instructor;
import com.example.demo.Model.Instructor_detail;
import com.example.demo.Repository.InstructorDetailRepository;
import com.example.demo.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorDetailService {

    @Autowired
    InstructorDetailRepository instructorDetailRepository;

    public void add(Instructor_detail instructor_detail){

        instructorDetailRepository.save(instructor_detail);
    }

    public Instructor_detail getById(long id){
        return instructorDetailRepository.findById(id).orElse(null);
    }

    public Instructor getInstructorByInstructorDetail(long id){
        Instructor_detail instructor_detail = getById(id);
        if (instructor_detail!=null){
            return instructor_detail.getInstructor();
        }
        return null;
    }

    public Boolean delete(long id){
        try {
            getInstructorByInstructorDetail(id).setInstructor_detail(null);
            instructorDetailRepository.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }

    }
}
