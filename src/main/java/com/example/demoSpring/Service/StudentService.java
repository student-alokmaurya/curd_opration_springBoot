package com.example.demoSpring.Service;

import com.example.demoSpring.Entity.Student;
import com.example.demoSpring.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student save(Student student){

        return studentRepo.save(student);
    }

    public List<Student> getAllStudent(){

        return studentRepo.findAll();
    }

    public boolean delete(Long id) {
        studentRepo.deleteById(id);
        return true;
    }

    public Student updateStudent(Student student, Long id) {
        Student student1 = studentRepo.findById(id).get();
        student1.setName(student.getName());
        student1.setCity(student.getCity());
        student1.setPhone(student.getPhone());

        return studentRepo.save(student1);
    }
}
