package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.service.impl;

import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.exception.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.repository.GameRepository;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public int diceRoll(){
        Random diceRoll = new Random();
        return diceRoll.nextInt(6) + 1;
    }
    public GameDTO convertToDto(Game game){
        GameDTO dto = new GameDTO();
        dto.setId(game.getGameId());
        dto.setDiceRoll1(game.getDiceRoll1());
        dto.setDiceRoll2(game.getDiceRoll2());
        dto.setWon(game.isWon());

        return dto;
    }

    public Game convertToEntity(GameDTO dto){
        Game game = new Game();
        game.setGameId(dto.getId());
        game.setDiceRoll1(dto.getDiceRoll1());
        game.setDiceRoll2(dto.getDiceRoll2());
        game.setWon(dto.isWon());

        return game;
    }

    @Override
    public GameDTO createGame(Long playerID) {
        Game newGame = new Game();
        Player player = playerRepository.findById(playerID).orElseThrow(() -> new PlayerNotFoundException("Player not found by ID: " +  playerID));

        int diceRoll1 = diceRoll();
        int diceRoll2 = diceRoll();

        newGame.setDiceRoll1(diceRoll1);
        newGame.setDiceRoll2(diceRoll2);

        newGame.setWon(newGame.isWon());

        player.addGame(newGame);

        return convertToDto(gameRepository.save(newGame));
    }

    @Override
    public List<GameDTO> getAllGamesByPlayer(Long playerId) {

        Player player = playerRepository.findById(playerId).orElseThrow(() -> new PlayerNotFoundException("Player not found by ID: " +playerId));

        List<Game> playerGames = gameRepository.findByPlayer_PlayerId(playerId);

        return playerGames.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public void deleteAllGamesByPlayer(Long playerId) {
        int deletedGames = gameRepository.deleteByPlayer_PlayerId(playerId);
    }
}
