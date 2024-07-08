package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "player")
public class Player {

    @Id
    private Long playerId;

    private String playerName;

    private LocalDateTime registrationDate;

    private List<Game> gameList;

    public void addGame(Game game) {
        if (gameList == null) {
            gameList = new ArrayList<>();
        }
        gameList.add(game);
        game.setPlayer(this);
    }

    public double calculateWinRatio() {
        if (gameList.isEmpty()) {
            return 0.0;
        }
        double wins = gameList.stream().filter(Game::isWon).count();
        return (wins / gameList.size() * 100);
    }
}
