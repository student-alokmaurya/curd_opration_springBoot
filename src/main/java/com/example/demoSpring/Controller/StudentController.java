package com.example.demoSpring.Controller;

import com.example.demoSpring.Entity.Student;
import com.example.demoSpring.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Student save(@RequestBody Student student){
        return studentService.save(student);
//        return "save student";
    }

    @GetMapping("/students")
    public List<Student> retrieveStudent(){
        return studentService.getAllStudent();
    }

    @DeleteMapping("/students/{id}")
    public boolean deleteStudent(@PathVariable Long id){
        studentService.delete(id);
        return true;
    }

    @PutMapping("/students/{id}")
    public Student deleteStudent(@RequestBody Student student,@PathVariable Long id){
        return studentService.updateStudent(student, id);
    }

}
