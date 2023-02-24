package com.crud.demo.http.api.v1;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.dto.StudentInputDto;
import com.crud.demo.dto.StudentOutputDto;
import com.crud.demo.entity.Student;
import com.crud.demo.service.StudentService;
import com.crud.demo.transformer.StudentOutputTransformer;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;
    private final StudentOutputTransformer outputTransformer;

    @Autowired
    public StudentController(StudentService studentService, StudentOutputTransformer outputTransformer) {
        this.studentService = studentService;
        this.outputTransformer = outputTransformer;
    }

    @GetMapping
    public List<StudentOutputDto> index() {
        return this.studentService.getAllStudents()
            .stream()
            .map(outputTransformer::transform)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentOutputDto> get(@PathVariable UUID id) {
        Student student = studentService.getStudentById(id);
        StudentOutputDto dto = outputTransformer.transform(student);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<StudentOutputDto> create(@Validated @RequestBody StudentInputDto input) {
        Student student = studentService.createStudent(input);
        StudentOutputDto dto = outputTransformer.transform(student);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentOutputDto> update(@PathVariable UUID id,
            @Validated @RequestBody StudentInputDto input) {
        Student student = studentService.updateStudent(id, input);
        StudentOutputDto dto = outputTransformer.transform(student);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        studentService.deleteStudent(id);

        return ResponseEntity.noContent()
            .build();
    }
}
