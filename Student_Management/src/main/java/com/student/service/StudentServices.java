package com.student.service;

import com.student.model.Student;
import com.student.repo.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {

    StudentRepository studentRepository;

    public StudentServices(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student StudentById(int id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }
}
