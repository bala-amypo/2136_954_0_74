package com.example.demo.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

    private final Map<Integer, Student> store = new HashMap<>();
    private int counter = 1;

    @Override
    public Student insertStudent(Student st) {
        st.setId(counter++);
        store.put(st.getId(), st);
        return st;
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Student> getOneStudent(int id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void deleteStudent(int id) {
        store.remove(id);
    }
}
