package pl.maryn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maryn.entity.training.SingleTrainingDay;

public interface SingleTrainingDayRepository extends JpaRepository<SingleTrainingDay, Long> {
    SingleTrainingDay findById(Long id);


}
