package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.controller;

import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.service.impl.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/players")
public class GameController {

    @Autowired
    private GameServiceImpl gameService;

    @PostMapping("/{id}/games")
    public ResponseEntity<GameDTO> startGame(@PathVariable Long id) {
        GameDTO startedGame = gameService.createGame(id);
        return ResponseEntity.ok(startedGame);
    }

    @DeleteMapping("/{id}/games")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id){
        gameService.deleteAllGamesByPlayer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/games")
    public ResponseEntity<List<GameDTO>> getAllGamesByPlayer(@PathVariable Long id){
        List<GameDTO> gamesList =  gameService.getAllGamesByPlayer(id);
        return ResponseEntity.ok(gamesList);
    }
}
