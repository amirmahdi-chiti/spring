package com.example.demo.Service;

import com.example.demo.Model.Course;
import com.example.demo.Model.Instructor;
import com.example.demo.Model.Review;
import com.example.demo.Model.Staff;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CourseRepository courseRepository;

    public void add(Instructor instructor){
        instructorRepository.save(instructor);
    }

    public void deleteById(long id){instructorRepository.deleteById(id);}

    public void addCourse(long id, Course course) throws Exception {
        try {
            Instructor instructor = instructorRepository.findById(id).orElse(null);
            course.addReview(new Review("yeah , it's great"));
            course.addReview(new Review("amazing, very good"));
            instructor.add(course);
            courseRepository.save(course);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("instructor not found");
        }

    }
    public List<Course> getCourses(long id)  {
        Instructor instructor = instructorRepository.findById(id).orElse(null);

        if (instructor!=null){
            return instructor.getCourses();
        }
        return null;

    }
}
