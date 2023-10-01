package ru.hogwarts.shcool.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.shcool.model.Faculty;
import ru.hogwarts.shcool.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty createdFaculty = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(createdFaculty);
    }

    @GetMapping("{idFaculty}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long idFaculty) {
        Faculty faculty = facultyService.getFacultyById(idFaculty);
        if(faculty == null) {
            return ResponseEntity.notFound() .build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping()
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.updateFaculty(faculty.getId(), faculty);
        if(updatedFaculty == null) {
            return ResponseEntity.notFound() .build();
        }
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("{idFaculty}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long idFaculty) {
        Faculty deleteFaculty = facultyService.deleteFaculty(idFaculty);
        if (deleteFaculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleteFaculty);
    }
    @GetMapping("/filterByColor")
    public Collection<Faculty> filterByColor (@RequestParam String color){
        return facultyService.filterByColor(color);
    }
}
