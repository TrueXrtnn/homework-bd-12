package ru.hogwarts.shcool.service;

import org.springframework.stereotype.Service;

import ru.hogwarts.shcool.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final Map<Long, Faculty> storage = new HashMap<>();
    private Long idFaculty = 0L;

    public Faculty createFaculty(String name, String color) {
        storage.put(idFaculty, new Faculty(idFaculty, name, color));
        idFaculty++;
        return new Faculty(idFaculty, name, color);
    }

    public Faculty createFaculty(Faculty faculty) {
        storage.put(idFaculty, faculty);
        idFaculty++;
        return faculty;
    }

    public Faculty getFacultyById(Long idFaculty) {
        return storage.get(idFaculty);
    }

    public Faculty updateFaculty(Long idFaculty, Faculty faculty) {
        storage.put(idFaculty, faculty);
        return faculty;
    }

    public Faculty deleteFaculty(Long idFaculty) {
        return storage.remove(idFaculty);
    }

    public Collection<Faculty> filterByColor(String color) {
        return storage.values().stream()
                .filter(o -> o.getColor() == color)
                .collect(Collectors.toList());
    }

}
