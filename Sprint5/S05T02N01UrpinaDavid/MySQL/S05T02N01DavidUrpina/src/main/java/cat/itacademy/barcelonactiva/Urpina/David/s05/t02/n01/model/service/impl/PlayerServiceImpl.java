package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.service.impl;

import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.exception.PlayerAlreadyExistsException;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.exception.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.domain.User;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.repository.GameRepository;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.service.AuthService;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.service.GameService;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.service.PlayerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private GameServiceImpl gameService;
    @Autowired
    private AuthService authService;

    public PlayerDTO convertToDTO(Player player) {
        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getPlayerId());
        dto.setPlayerName(player.getPlayerName());
        dto.setRegistrationDate(player.getRegistrationDate());
        dto.setWinRatio(player.calculateWinRatio());

        return dto;
    }

    public Player convertToEntity(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setPlayerId(playerDTO.getId());
        player.setPlayerName(playerDTO.getPlayerName());
        player.setRegistrationDate(playerDTO.getRegistrationDate());

        return player;
    }

    public String validateName(String playerName) {
        if (playerName == null || playerName.trim().isEmpty()) {
            playerName = "Anonymous";
        }/*
        if (playerRepository.existsByNameIgnoreCase(playerName) && !playerName.equalsIgnoreCase("Anonymous")) {
            throw new PlayerAlreadyExistsException("Player with that name already exists.");
        }*/
        return playerName;
    }

    @Override
    public PlayerDTO createPlayer(String playerName, Authentication authentication) {
        List<Game> gameList = new ArrayList<>();
        User userAuth = authService.getUserFromAuthentication(authentication);

        Player newPlayer = new Player();

        String validatedName = validateName(playerName);

        newPlayer.setPlayerName(validatedName);
        newPlayer.setRegistrationDate(LocalDateTime.now());
        newPlayer.setUser(userAuth);

        newPlayer.setGameList(gameList);

        return convertToDTO(playerRepository.save(newPlayer));
    }

    @Override
    public PlayerDTO updatePlayerName(Long playerId, String newName) {
        Player playerToUpdate = playerRepository.findById(playerId).orElseThrow(() -> new PlayerNotFoundException("Player not found by ID: " + playerId));

        String validatedName = validateName(newName);
        playerToUpdate.setPlayerName(validatedName);

        return convertToDTO(playerRepository.save(playerToUpdate));
    }

    @Override
    public PlayerDTO getPlayerById(Long id) {
        return convertToDTO(playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException("Player not found by ID: " + id)));
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlayerDTO> getAllPlayersWinRate() {
        List<Player> players = playerRepository.findAll();
        return players.stream()
                .map(player -> new PlayerDTO(
                        player.getPlayerId(),
                        player.getPlayerName(),
                        player.getRegistrationDate(),
                        player.calculateWinRatio()))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePlayerById(Long id) {
        Player playerToDelete = playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException("Player not found by ID: " + id));
    }

    @Override
    public double getPlayersRanking() {
        List<Player> players = playerRepository.findAll();

        if (players.isEmpty()) {
            throw new PlayerNotFoundException("No players were found");
        }

        return players.stream()
                .mapToDouble(Player::calculateWinRatio)
                .average()
                .orElse(0.0);
    }

    @Override
    public PlayerDTO getLoser() {
        List<Player> players = playerRepository.findAll();
        Player loser = players.stream()
                .min(Comparator.comparingDouble(Player::calculateWinRatio))
                .orElseThrow(() -> new PlayerNotFoundException("No players were found"));

        return convertToDTO(playerRepository.save(loser));
    }

    @Override
    public PlayerDTO getWinner() {
        List<Player> players = playerRepository.findAll();
        Player winner = players.stream()
                .max(Comparator.comparingDouble(Player::calculateWinRatio))
                .orElseThrow(() -> new PlayerNotFoundException("No players were found"));

        return convertToDTO(playerRepository.save(winner));
    }
}
