package com.example.demo.Service;

import com.example.demo.Model.Course;
import com.example.demo.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public void deleteById(long id){
        courseRepository.deleteById(id);
    }

    public Course getCourse(long id){
        return courseRepository.findById(id).orElse(null);
    }

}
