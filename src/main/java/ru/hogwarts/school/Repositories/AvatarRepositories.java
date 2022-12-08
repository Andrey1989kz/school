package ru.hogwarts.school.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Avatar;

import java.util.Optional;

public interface AvatarRepositories extends JpaRepository<Avatar,Long> {

    Optional<Avatar> findByStudent(Long studentId);
}
