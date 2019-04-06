package by.home.accountservice.repo;

import by.home.accountservice.domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalDetailsRepo extends JpaRepository<Goal, Long> {
}
