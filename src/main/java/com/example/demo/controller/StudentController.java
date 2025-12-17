package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.insertStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable int id) {
        return service.getOneStudent(id);
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student newStudent) {
        Optional<Student> existing = service.getOneStudent(id);
        if (existing.isPresent()) {
            newStudent.setId(id);
            service.insertStudent(newStudent);
            return "Updated successfully";
        }
        return "Id not found";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        Optional<Student> existing = service.getOneStudent(id);
        if (existing.isPresent()) {
            service.deleteStudent(id);
            return "Deleted successfully";
        }
        return "Id not found";
    }
}
