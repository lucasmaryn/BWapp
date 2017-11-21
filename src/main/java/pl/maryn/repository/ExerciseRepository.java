package pl.maryn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maryn.entity.training.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
