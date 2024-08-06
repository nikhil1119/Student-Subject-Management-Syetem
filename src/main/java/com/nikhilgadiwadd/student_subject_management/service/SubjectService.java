package com.nikhilgadiwadd.student_subject_management.service;

import com.nikhilgadiwadd.student_subject_management.entity.Subject;
import com.nikhilgadiwadd.student_subject_management.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject createSubject(Subject subject) {
        // Check if the subject already exists
        Subject existingSubject = subjectRepository.findByName(subject.getName());
        if (existingSubject != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Subject already exists");
        }
        return subjectRepository.save(subject);
    }
}
