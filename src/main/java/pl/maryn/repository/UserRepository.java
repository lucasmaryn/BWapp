package pl.maryn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maryn.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
