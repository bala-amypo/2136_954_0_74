package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.service.Studentservice;

@RestController
public class StudentController {

    @Autowired
    Studentservice service;

    @PostMapping("/add")
    public Student post(@RequestBody Student st){
        return service.savedata(st);
    }

    @GetMapping("/getAll")
    public List<Student> getAll(){
        return service.getAllStudents();
    }

    @GetMapping("/get/{id}")
    public Optional<Student> get(@PathVariable int id){
        return service.getOneStudent(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody Student newStudent){
        Optional<Student> student = service.getOneStudent(id);
        if(student.isPresent()){
            newStudent.setId(id);
            service.insertStudent(newStudent);
            return "Updated successfully";
        }
        return "Id not found";
    }

    @DeleteMapping("/del/{id}")
    public String deleteStudent(@PathVariable int id){
        Optional<Student> student = service.getOneStudent(id);
        if(student.isPresent()){
            service.deleteStudent(id);
            return "Deleted successfully";
        }
        return "Id not found";
    }
}