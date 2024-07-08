package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserName (String userName);
}
