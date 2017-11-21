package pl.maryn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maryn.entity.training.Training;

public interface TrainingRepository extends JpaRepository<Training,Long> {
}
