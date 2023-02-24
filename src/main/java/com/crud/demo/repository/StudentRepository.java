package com.crud.demo.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {

}
