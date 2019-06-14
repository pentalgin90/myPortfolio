package by.home.accountservice.repo;

import by.home.accountservice.domain.Usr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsrDetailsRepo extends JpaRepository<Usr, Long> {
}
