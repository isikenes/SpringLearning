package com.isikenes.restcrud.service;

import com.isikenes.restcrud.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student findById(int id);

    Student save(Student student);

    void deleteById(int id);
}
