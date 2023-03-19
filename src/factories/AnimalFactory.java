package factories;

import animals.AbsAnimals;
import birds.Duck;
import data.AnimalTypeData;
import pets.Cat;
import pets.Dog;

public class AnimalFactory {
    public AbsAnimals create(AnimalTypeData animalTypeData) {
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
    }
}
