package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "game")
public class Game {

    @Id
    private Long gameId;

    private Player player;

    private  int diceRoll1;

    private int diceRoll2;

    private boolean isWon;

    private LocalDateTime gameDate;

    public boolean isWon() {
        return (diceRoll1 + diceRoll2 == 7);
    }
}
