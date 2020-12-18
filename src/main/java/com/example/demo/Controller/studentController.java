package com.example.demo.Controller;
import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class studentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        studentService.add(student);
    }
    @RequestMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("student",new Student());
        return "student-form";
    }
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student){

        System.out.println("the Student:" + student.getFirstName()+" " + student.getLastName());
        return "student-confirm";
    }
    @PostMapping("/add/{student_id}/course/{course_id}")
    public ResponseEntity<?> addCourse(@PathVariable("student_id") long student_id,
                                       @PathVariable("course_id") long course_id){
        try {
            studentService.addCourseToStudent(student_id,course_id);
            return ResponseEntity.ok("added");
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{student_id}/courses")
    public ResponseEntity<?> getCourses(@PathVariable("student_id") long id){
        try {
            System.out.println(studentService.getCourses(id));
            return ResponseEntity.ok("");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id){
        studentService.deleteById(id);
    }

}
