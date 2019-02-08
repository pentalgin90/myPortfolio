package by.home.oauth2.repo;

import by.home.oauth2.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<Users, String> {

}
