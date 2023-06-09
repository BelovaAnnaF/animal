import animals.AbsAnimal;
import birds.Duck;
import data.AnimalTypeData;
import data.ColorData;
import data.CommandsData;
import factories.AnimalFactory;
import pets.Cat;
import pets.Dog;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<AbsAnimal> animals = new ArrayList();

        while (true) {
            String commandStr = "";
            do {
                System.out.println("Выберите команду add/list/exit");
                commandStr = scanner.next().toUpperCase().trim();

            } while (!commandStr.equals("ADD") && !commandStr.equals("LIST") && !commandStr.equals("EXIT"));

            CommandsData commandsData = CommandsData.valueOf(commandStr);
            switch (commandsData) {
                case ADD -> {
                    String animalTypeStr = "";
                    do {
                        System.out.println("Выберите животное cat/dog/duck");
                        animalTypeStr = scanner.next().toUpperCase().trim();

                    } while (!animalTypeStr.equals("CAT") && !animalTypeStr.equals("DOG") && !animalTypeStr.equals("DUCK"));

                    AnimalTypeData animalTypeData = AnimalTypeData.valueOf(animalTypeStr);
                    AnimalFactory animalFactory = new AnimalFactory();

                    AbsAnimal animal = fillAnimalsData(animalFactory.create(animalTypeData));

                    animals.add(animal);

                    if (animal instanceof Cat){
                        Cat cat = new Cat();
                        cat.say();
                    } else if (animal instanceof Dog){
                        Dog dog = new Dog();
                        dog.say();
                    }else if (animal instanceof Duck){
                        Duck duck = new Duck();
                        duck.say();
                        duck.fly();
                    }
                }
                case LIST -> animals.forEach((AbsAnimal animal) ->
                        System.out.println(animal.toString()));
                case EXIT -> System.exit(0);

            }
        }
    }

    private static AbsAnimal fillAnimalsData(AbsAnimal animal) {
        System.out.println("Введите имя животного");
        String name = scanner.next();
        animal.setName(name);


        System.out.println("Введите возраст животного");
        String age = scanner.next();
        while (!IntAge(age)){
            System.out.println("Возраст введен не верно, возраст должен содержать цифры от 1 до 25");
            System.out.println("Введите возраст животного");
            age = scanner.next();
        }
        animal.setAge(Integer.parseInt(age));


        System.out.println("Введите вес животного");
        String weight = scanner.next();
        while (!IntWeight(weight)){
            System.out.println("Вес введен не верно, вес должен содержать цифры от 1 до 100");
            System.out.println("Введите вес животного");
            weight = scanner.next();
        }
        animal.setWeight(Integer.parseInt(weight));

        String color = "";
    do {
        System.out.println("Введите цвет животного white/black/foxy");
        color = scanner.next().toUpperCase().trim();
    }while (!color.equals("WHITE") && !color.equals("BLACK") && !color.equals("FOXY"));
        ColorData colorData = ColorData.valueOf(color);
        animal.setColor(color);


        return animal;
    }

    private static boolean IntAge(String age){

        try {
            int ageStr = Integer.parseInt(age);
            return ageStr > 0 & ageStr < 26;

        } catch (NumberFormatException ex) {
            return false;
        }
    }
    private static boolean IntWeight(String weight){

        try {
            int weightStr = Integer.parseInt(weight);
            return weightStr > 0 & weightStr < 101;

        } catch (NumberFormatException ex) {
            return false;
        }
    }
}