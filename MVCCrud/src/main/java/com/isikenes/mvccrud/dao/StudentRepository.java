package com.isikenes.mvccrud.dao;

import com.isikenes.mvccrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    public List<Student> findAllByOrderByFirstNameAsc();
}
