package ru.hogwarts.shcool.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.shcool.model.Student;
import ru.hogwarts.shcool.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping("{idStudent}")
    public ResponseEntity<Student> getStudent(@PathVariable Long idStudent) {
        Student student = studentService.getStudentById(idStudent);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping()
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student.getId(), student);
        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("{idStudent}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long idStudent) {
        Student deleteStudent = studentService.deleteStudent(idStudent);
        if (deleteStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleteStudent);
    }
    @GetMapping("/filterByAge")
    public Collection<Student> filterByAge(@RequestParam int age){
        return studentService.filterByAge(age);
    }
}

