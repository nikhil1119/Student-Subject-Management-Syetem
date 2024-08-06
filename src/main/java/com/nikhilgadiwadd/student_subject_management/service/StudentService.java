package com.nikhilgadiwadd.student_subject_management.service;

import com.nikhilgadiwadd.student_subject_management.entity.Student;
import com.nikhilgadiwadd.student_subject_management.entity.Subject;
import com.nikhilgadiwadd.student_subject_management.repository.StudentRepository;
import com.nikhilgadiwadd.student_subject_management.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Transactional
    public Student createStudent(Student student) {
        // Handle subjects
        List<Subject> subjects = student.getSubjects().stream()
                .map(subject -> {
                    Subject existingSubject = subjectRepository.findByName(subject.getName());
                    if (existingSubject != null) {
                        return existingSubject;
                    } else {
                        return subjectRepository.save(subject);
                    }
                })
                .collect(Collectors.toList());

        student.setSubjects(subjects);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}
