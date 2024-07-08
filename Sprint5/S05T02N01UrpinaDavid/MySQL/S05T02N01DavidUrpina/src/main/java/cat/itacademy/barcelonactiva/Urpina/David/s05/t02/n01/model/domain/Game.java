package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long gameId;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    @Column(name = "diceRoll1")
    private  int diceRoll1;
    @Column(name = "diceRoll2")
    private int diceRoll2;
    @Column(name = "is_won")
    private boolean isWon;
    @Column(name = "game_date")
    private LocalDateTime gameDate;

    public boolean isWon() {
        return (diceRoll1 + diceRoll2 == 7);
    }
}
