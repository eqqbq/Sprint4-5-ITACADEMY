package cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.dto;

import cat.itacademy.barcelonactiva.Urpina.David.s05.t02.n01.model.domain.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {

    private long id;
    private int diceRoll1;
    private int diceRoll2;
    private Player player;
    private boolean won;
}
