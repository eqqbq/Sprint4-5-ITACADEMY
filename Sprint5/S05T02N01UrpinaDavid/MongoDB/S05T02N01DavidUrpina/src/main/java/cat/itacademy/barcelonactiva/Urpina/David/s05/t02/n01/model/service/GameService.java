package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.service;

import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.dto.GameDTO;

import java.util.List;

public interface GameService {
    GameDTO createGame(Long playerID);
    List<GameDTO> getAllGamesByPlayer(Long playerId);
    void deleteAllGamesByPlayer(Long playerId);
}
