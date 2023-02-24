package com.crud.demo.transformer;

import org.springframework.stereotype.Service;

import com.crud.demo.dto.StudentOutputDto;
import com.crud.demo.entity.Student;

@Service
public class StudentOutputTransformer {
    public StudentOutputDto transform(Student student) {
        return new StudentOutputDto(student.getId(), student.getFirstName(), student.getLastName(),
                student.getMiddleName());
    }
}
