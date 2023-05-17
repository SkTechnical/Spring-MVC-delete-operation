package com.example.spring_web_controller.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_web_controller.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
