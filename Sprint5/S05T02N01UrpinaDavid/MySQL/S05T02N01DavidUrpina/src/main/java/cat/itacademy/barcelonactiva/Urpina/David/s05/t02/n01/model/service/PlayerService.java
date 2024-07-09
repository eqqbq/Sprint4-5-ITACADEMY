package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.service;

import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.dto.PlayerDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface PlayerService {
    PlayerDTO createPlayer(String playerName, Authentication authentication);
    PlayerDTO updatePlayerName(Long playerId, String newName);
    PlayerDTO getPlayerById(Long id);
    List<PlayerDTO> getAllPlayers();
    List<PlayerDTO> getAllPlayersWinRate();
    void deletePlayerById(Long id);
    double getPlayersRanking();
    PlayerDTO getLoser();
    PlayerDTO getWinner();
}
