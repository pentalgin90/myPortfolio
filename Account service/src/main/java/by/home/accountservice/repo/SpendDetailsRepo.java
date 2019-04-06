package by.home.accountservice.repo;

import by.home.accountservice.domain.Spend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpendDetailsRepo extends JpaRepository<Spend, Long> {
}
