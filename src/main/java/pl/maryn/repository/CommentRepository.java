package pl.maryn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maryn.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findById(Long id);

}
