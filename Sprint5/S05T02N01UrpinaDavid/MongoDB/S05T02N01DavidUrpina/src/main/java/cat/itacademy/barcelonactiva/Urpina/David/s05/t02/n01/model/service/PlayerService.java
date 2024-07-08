package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.service;

import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.dto.PlayerDTO;
import java.util.List;

public interface PlayerService {
    PlayerDTO createPlayer(String playerName, Long id);
    PlayerDTO updatePlayerName(PlayerDTO dto, String newName);
    PlayerDTO getPlayerById(Long id);
    List<PlayerDTO> getAllPlayers();
    List<PlayerDTO> getAllPlayersWinRate();
    void deletePlayerById(Long id);
    double getPlayersRanking();
    PlayerDTO getLoser();
    PlayerDTO getWinner();
}
