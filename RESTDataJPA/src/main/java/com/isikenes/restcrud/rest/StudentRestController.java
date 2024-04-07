package com.isikenes.restcrud.rest;

import com.isikenes.restcrud.entity.Student;
import com.isikenes.restcrud.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student student=studentService.findById(studentId);

        if(student==null) {
            throw new RuntimeException("Student not found: "+studentId);
        }

        return student;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        student.setId(0);
        return studentService.save(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId){
        Student student=studentService.findById(studentId);

        if(student==null) {
            throw new RuntimeException("Student not found: "+studentId);
        }

        studentService.deleteById(studentId);

        return "Student "+ studentId +" deleted!";
    }
}
