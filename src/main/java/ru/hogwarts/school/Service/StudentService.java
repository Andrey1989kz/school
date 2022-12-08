package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.Repositories.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Collection<Student> getStudentsByAge(int age) {
        return studentRepository.findByAge(age);
    }

    public Student createStudent(Student student) {//CREATE
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {//READ
        return studentRepository.findById(id).orElse(null);
    }

    public Student editStudent(Student student) {//UPDATE
        if (studentRepository.findById(student.getId()).orElse(null) == null) {
            return null;
        }
        return studentRepository.save(student);
    }
    public void deleteStudent(long id) {//DELETE
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty getStudentFaculty(long id) {
        Student student = findStudent(id);
        if (student == null) {
            return null;
        }
        return student.getFaculty();
    }
}

