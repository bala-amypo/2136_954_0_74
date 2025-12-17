package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Studentity;

public interface StudentService {
    
    Student insertStudent(Student st);
    List<Student> getAllStudents();
    Optional<Student> getOneStudent(int id);
    void deleteStudent(int id);
}