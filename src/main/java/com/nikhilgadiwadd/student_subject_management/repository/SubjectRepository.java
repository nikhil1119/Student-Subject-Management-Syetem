package com.nikhilgadiwadd.student_subject_management.repository;

import com.nikhilgadiwadd.student_subject_management.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Subject findByName(String name);

}
