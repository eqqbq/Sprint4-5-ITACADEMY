package cat.itacademy.barcelonactiva.Urpina.David.s04.t02.n01.controllers;


import cat.itacademy.barcelonactiva.Urpina.David.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Urpina.David.s04.t02.n01.model.service.impl.FruitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    private FruitServiceImpl fruitService;

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit){
        Fruit savedFruit = fruitService.addFruit(fruit);
        return ResponseEntity.ok(savedFruit);
    }

    @PutMapping("/updateFruit/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable(value = "id") Long id, @RequestBody Fruit fruit){
        Fruit updatedFruit = fruitService.updateFruit(fruit, id);
        return ResponseEntity.ok(updatedFruit);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable Long id){
        fruitService.deleteFruit(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOneFruit(@PathVariable Long id){
        Fruit selectedFruit = fruitService.getOneFruitById(id);
        return ResponseEntity.ok(selectedFruit);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruit(){
        List<Fruit> fruitList = fruitService.getAllFruit();
        return ResponseEntity.ok(fruitList);
    }
}
