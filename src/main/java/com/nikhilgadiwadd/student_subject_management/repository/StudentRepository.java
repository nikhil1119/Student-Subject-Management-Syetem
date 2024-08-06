package com.nikhilgadiwadd.student_subject_management.repository;

import com.nikhilgadiwadd.student_subject_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
