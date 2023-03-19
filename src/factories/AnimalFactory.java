package factories;

import animals.AbsAnimal;
import birds.Duck;
import data.AnimalTypeData;
import pets.Cat;
import pets.Dog;

public class AnimalFactory {
    public AbsAnimal create(AnimalTypeData animalTypeData) {
        switch (animalTypeData) {
            case CAT -> {
                return new Cat();
            }
            case DOG -> {
                return new Dog();
            }
            case DUCK -> {
                return new Duck();
            }
        }

        return null;
    }
}
