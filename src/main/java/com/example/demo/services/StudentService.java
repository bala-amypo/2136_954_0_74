package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Studentity;

public interface Studentservice {
    
    Studentity insertStudent(Studentity st);
    List<Studentity> getAllStudents();
    Optional<Studentity> getOneStudent(int id);
    void deleteStudent(int id);
}