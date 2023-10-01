package ru.hogwarts.shcool.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.shcool.model.Faculty;
import ru.hogwarts.shcool.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final Map<Long, Student> storage = new HashMap<>();
    private Long idStudent = 0L;

    public Student createStudent(String name, int age) {
        storage.put(idStudent, new Student(idStudent, name, age));
        idStudent++;
        return new Student(idStudent, name, age);
    }

    public Student createStudent(Student student) {
        storage.put(idStudent, student);
        idStudent++;
        return student;
    }

    public Student getStudentById(Long idStudent) {
        return storage.get(idStudent);
    }

    public Student updateStudent(Long idStudent, Student student) {
        storage.put(idStudent, student);
        return student;
    }

    public Student deleteStudent(Long idStudent) {
        return storage.remove(idStudent);
    }
    public Collection<Student> filterByAge(int age) {
        return storage.values().stream()
                .filter(o -> o.getAge() == age)
                .collect(Collectors.toList());
    }
}

