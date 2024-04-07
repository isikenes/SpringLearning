package com.isikenes.hibernate;

import com.isikenes.hibernate.dao.StudentDAO;
import com.isikenes.hibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);
            //readStudent(studentDAO);
            //queryForStudentName(studentDAO);
            //updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            createRandomStudent(studentDAO);
            queryForStudents(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        Student student1 = new Student("Ali", "Aga", "aa@gmail.com");

        studentDAO.save(student1);
    }

    private void readStudent(StudentDAO studentDAO) {
        Student student1 = studentDAO.findById(2);
        System.out.println(student1);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> allStudents = studentDAO.findAll();

        for (Student s : allStudents) {
            System.out.println(s);
        }
    }

    private void queryForStudentName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByName("Enes");

        for (Student s : students) {
            System.out.println(s);
        }
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findById(2);
        student.setLastName("Akman");
        studentDAO.update(student);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        studentDAO.delete(3);
    }

    private void createRandomStudent(StudentDAO studentDAO) {
        Random random = new Random();
        int firstNameLength = random.nextInt(3, 6);
        int lastNameLength = random.nextInt(3, 6);

        StringBuilder firstName = new StringBuilder();
        StringBuilder lastName = new StringBuilder();

        for (int i = 0; i < firstNameLength; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            firstName.append(c);
        }

        for (int i = 0; i < lastNameLength; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            lastName.append(c);
        }

        String first= firstName.toString();
        String last=lastName.toString();
        String email=String.valueOf(first.charAt(0)) + String.valueOf(last.charAt(0)) + "@gmail.com";

        first=StringUtils.capitalize(first);
        last=StringUtils.capitalize(last);


        Student student = new Student(first, last, email);
        studentDAO.save(student);
    }

}
