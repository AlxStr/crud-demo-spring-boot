package com.crud.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.crud.demo.dto.StudentInputDto;
import com.crud.demo.entity.Student;
import com.crud.demo.exception.StudentNotFoundException;
import com.crud.demo.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(UUID id) {
        return studentRepository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException());
    }

    public Student createStudent(StudentInputDto input) {
        Student student = new Student();

        student.setFirstName(input.getFirstName());
        student.setLastName(input.getLastName());
        student.setMiddleName(input.getMiddleName());

        return studentRepository.save(student);
    }

    public Student updateStudent(UUID id, StudentInputDto input) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException());

        student.setFirstName(input.getFirstName());
        student.setLastName(input.getLastName());
        student.setMiddleName(input.getMiddleName());

        return studentRepository.save(student);
    }

    public void deleteStudent(UUID id) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException());

        studentRepository.delete(student);
    }
}