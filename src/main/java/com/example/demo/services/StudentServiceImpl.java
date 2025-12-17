package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo repo;

    public StudentServiceImpl(StudentRepo repo) {
        this.repo = repo;
    }

    @Override
    public Student insertStudent(Student st) {
        return repo.save(st);
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Optional<Student> getOneStudent(Integer id) {
        return repo.findById(id);
    }

    @Override
    public void deleteStudent(Integer id) {
        repo.deleteById(id);
    }
}
