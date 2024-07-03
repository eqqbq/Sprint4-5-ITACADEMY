package cat.itacademy.barcelonactiva.Urpina.David.s04.t02.n01.model.service;

import cat.itacademy.barcelonactiva.Urpina.David.s04.t02.n01.model.domain.Fruit;

import java.util.List;
import java.util.Optional;

public interface FruitService {
    Fruit addFruit(Fruit fruit);

    Fruit updateFruit(Fruit fruit, Long id);

    void deleteFruit(Long id);

    Fruit getOneFruitById(Long id);

    List<Fruit> getAllFruit();
}
