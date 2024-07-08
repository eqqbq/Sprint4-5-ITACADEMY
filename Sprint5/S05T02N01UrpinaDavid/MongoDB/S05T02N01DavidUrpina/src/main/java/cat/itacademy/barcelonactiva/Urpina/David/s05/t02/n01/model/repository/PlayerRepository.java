package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.repository;


import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, Long> {
   // boolean existsByNameIgnoreCase(String playerName);
}
