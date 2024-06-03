package cat.itacademy.barcelonactiva.Urpina.David.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.Urpina.David.s04.t02.n01.model.repository.FruitRepository;
import cat.itacademy.barcelonactiva.Urpina.David.s04.t02.n01.model.domain.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public Fruit addFruit(Fruit fruit){
        return fruitRepository.save(fruit);
    }

    public Fruit updateFruit (Fruit fruit){
        return fruitRepository.save(fruit);
    }

    public void deleteFruit(Long id){
        fruitRepository.deleteById(id);
    }

    public Optional<Fruit> getOneFruitById(Long id){
        return fruitRepository.findById(id);
    }

    public List<Fruit> getAllFruit(){
        return fruitRepository.findAll();
    }
}
