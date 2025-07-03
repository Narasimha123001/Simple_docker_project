package com.student.controller;

import com.student.model.Student;
import com.student.service.StudentServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentService")
public class StudentController {

    StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student){
        return studentServices.saveStudent(student);
    }

    @GetMapping("/getAllStudents")
    public Iterable<Student> getAllStudents(){
        return studentServices.getAllStudents();
    }
    @GetMapping("/StudentById/{id}")
    public Student StudentById(@PathVariable("id") Integer id){
        return studentServices.StudentById(id);
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student){
        return studentServices.updateStudent(student);
    }

    @PostMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable int id){
        studentServices.deleteStudent(id);
    }
}
