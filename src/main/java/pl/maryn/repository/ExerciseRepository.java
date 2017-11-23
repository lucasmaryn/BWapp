package pl.maryn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maryn.entity.training.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Exercise findById(Long id);

//    @Query(value = "select e from exercise e, singletrainingday_exercise sd_e where e.id = sd_e.training_id AND sd_e.training_id = ?1% ") //używamy nazw encji
//    List<Exercise> findExerciseBySingleTrainingDayIdUsingQuery(long id);
}
