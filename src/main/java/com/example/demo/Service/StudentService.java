package com.example.demo.Service;

import com.example.demo.Model.Course;
import com.example.demo.Model.Student;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    public void add(Student student){
        courseRepository.findById((long) 97).orElse(null).addStudent(student);
        studentRepository.save(student);
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public List<Student> sortByScore(){
        return getAll().stream()
                .sorted((o1, o2) -> o1.getScore().compareTo(o2.getScore()))
                .collect(Collectors.toList());
    }

    public Student findById(long id){
        List<Student> students = getAll();
        Stream<Student> stuStream = students.stream();
        return stuStream.filter(student -> student.getId()==id).collect(Collectors.toList()).get(0);
    }
    public List<String> getName(){
        return getAll().stream().map(student -> student.getFirstName()+" "+ student.getLastName())
                .collect(Collectors.toList());
    }

    public double average(){
        int size = getAll().size();
        double sum = getAll().stream().map(student -> student.getScore()).reduce((sco1, sco2)->sco1+sco2).get();
        return sum/size;
    }
    public List<Student> getBestStudent(){
        return getAll().stream().filter(student -> student.getScore()>17).collect(Collectors.toList());
    }

    public void addCourseToStudent(long student_id,long course_id) throws Exception {
        try {
            Course course = courseRepository.findById(course_id).orElse(null);
            Student student = studentRepository.findById(student_id).orElse(null);
            course.addStudent(student);
            courseRepository.save(course);

        }catch (Exception e){
            throw new Exception("not found");
        }

    }
    public List<Course> getCourses(long id) throws Exception {
        Student student =  studentRepository.findById(id).orElse(null);
        try {

            return student.getCourses();
        }catch (Exception e){
            throw new Exception("not found");
        }
    }

    public void deleteById(long id){
        studentRepository.deleteById(id);
    }

}
