package com.nikhilgadiwadd.student_subject_management.controller;

import com.nikhilgadiwadd.student_subject_management.entity.Student;
import com.nikhilgadiwadd.student_subject_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get-all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

}
