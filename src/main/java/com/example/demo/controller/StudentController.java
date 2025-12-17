package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentService; // correct import

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service; // inject interface, not impl

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.insertStudent(student); // method name matches interface
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
        Optional<Student> existingStudent = service.getOneStudent(id);
        if (existingStudent.isPresent()) {
            newStudent.setId(id);
            service.insertStudent(newStudent);
            return "Updated successfully";
        }
        return "Id not found";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        Optional<Student> existingStudent = service.getOneStudent(id);
        if (existingStudent.isPresent()) {
            service.deleteStudent(id);
            return "Deleted successfully";
        }
        return "Id not found";
    }
}
