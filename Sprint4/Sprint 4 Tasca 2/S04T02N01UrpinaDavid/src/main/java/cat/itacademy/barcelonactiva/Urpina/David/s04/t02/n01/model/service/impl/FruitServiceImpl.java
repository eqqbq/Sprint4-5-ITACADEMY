package cat.itacademy.barcelonactiva.Urpina.David.s04.t02.n01.model.service.impl;

import cat.itacademy.barcelonactiva.Urpina.David.s04.t02.n01.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonactiva.Urpina.David.s04.t02.n01.model.repository.FruitRepository;
import cat.itacademy.barcelonactiva.Urpina.David.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Urpina.David.s04.t02.n01.model.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public Fruit addFruit(Fruit fruit){
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit getOneFruitById(Long id){
        return fruitRepository.findById(id)
                .orElseThrow(() -> new FruitNotFoundException("Fruit not found with ID: " + id));
    }

    @Override
    public Fruit updateFruit (Fruit fruit, Long id){

        Fruit fruitToUpdate = fruitRepository.findById(id).orElseThrow(() -> new FruitNotFoundException("Fruit not found with ID: " + id));

        fruitToUpdate.setName(fruit.getName());
        fruitToUpdate.setQuantityKilo(fruit.getQuantityKilo());

        return fruitRepository.save(fruit);
    }

    @Override
    public void deleteFruit(Long id){

        Fruit fruitToDelete = fruitRepository.findById(id).orElseThrow(() -> new FruitNotFoundException("Fruit not found with ID: " + id));

        fruitRepository.deleteById(id);
    }

    @Override
    public List<Fruit> getAllFruit(){
        return fruitRepository.findAll();
    }
}
