package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.domain.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends MongoRepository<Game, Long> {
    List<Game> findByPlayer_PlayerId(Long id);
    int deleteByPlayer_PlayerId(Long id);
}
