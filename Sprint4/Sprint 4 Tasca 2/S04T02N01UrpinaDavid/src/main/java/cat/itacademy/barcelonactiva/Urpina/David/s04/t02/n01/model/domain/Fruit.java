package cat.itacademy.barcelonactiva.Urpina.David.s04.t02.n01.model.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int quantityKilo;

    public Fruit() {
    }

    public Fruit(long id, String name, int quantityKilo) {
        this.id = id;
        this.name = name;
        this.quantityKilo = quantityKilo;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityKilo() {
        return quantityKilo;
    }

    public void setQuantityKilo(int quantityKilo) {
        this.quantityKilo = quantityKilo;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantityKilo=" + quantityKilo +
                '}';
    }
}
