package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findUserByUserName (String userName);
}
