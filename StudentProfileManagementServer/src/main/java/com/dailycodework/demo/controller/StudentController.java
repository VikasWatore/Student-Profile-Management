package com.dailycodework.demo.controller;

import com.dailycodework.demo.model.Student;
import com.dailycodework.demo.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.getStudent(), HttpStatus.FOUND);
    }

    @PostMapping
    public Student addStudent(@RequestBody @Valid Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }


}
