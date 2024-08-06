package com.nikhilgadiwadd.student_subject_management.controller;

import com.nikhilgadiwadd.student_subject_management.entity.Subject;
import com.nikhilgadiwadd.student_subject_management.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PreAuthorize("hasAnyRole('STUDENT', 'ADMIN')")
    @GetMapping("/get-all")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        try {
            Subject createdSubject = subjectService.createSubject(subject);
            return new ResponseEntity<>(createdSubject, HttpStatus.CREATED);
        } catch (ResponseStatusException e) {
            // Return an error message with the appropriate HTTP status code
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Subject already exists");
        }
    }
}
