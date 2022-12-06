package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty editFaculty(Faculty faculty) {
        if (facultyRepository.findById(faculty.getId()).orElse(null) == null) {
            return null;
        }
        return facultyRepository.save(faculty);
    }
    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getFacultyByColor(String color) {
        return facultyRepository.findByColor(color);
    }

    public Collection<Faculty> findByNameIgnoreCaseOrColorIgnoreCase(String name, String color) {
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(name, color);
    }
}

