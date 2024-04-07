package com.isikenes.hibernate.dao;

import com.isikenes.hibernate.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByName(String name);

    void update(Student student);

    void delete(int id);
}
