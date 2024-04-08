package com.isikenes.mvccrud.service;

import com.isikenes.mvccrud.dao.StudentRepository;
import com.isikenes.mvccrud.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAllByOrderByFirstNameAsc();
    }

    @Override
    public Student findById(int id) {
        Optional<Student> result=studentRepository.findById(id);

        Student s=null;
        if(result.isPresent()) {
            s=result.get();
        } else{
            throw new RuntimeException("Did not find student id - " + id);

        }
        return s;
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
