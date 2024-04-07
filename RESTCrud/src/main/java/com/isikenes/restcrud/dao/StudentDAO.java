package com.isikenes.restcrud.dao;

import com.isikenes.restcrud.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();

    Student findById(int id);

    Student save(Student student);

    void deleteById(int id);
}
