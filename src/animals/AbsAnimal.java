package animals;

import data.ColorData;

public abstract class AbsAnimal {
    private String name = "";
    private int age = -1;
    private int weight = -1;
    private ColorData color = null;

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color.getColorName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = ColorData.valueOf(color);
    }

    public void  say(){
        System.out.println("Я говорю");
    }

    public void  go(){
        System.out.println("Я иду");
    }

    public void  drink(){
        System.out.println("Я пью");
    }

    public void  eat(){
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        return String.format(
                "Привет! меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s",
                name, age, getYearPrefix(age), weight, color.getColorName()
        );
    }

    private String getYearPrefix(int age) {
        int balance = age % 10;

        if (balance >= 5 || balance == 0 || (age >= 11 && age < 15)) {
            return "лет";
        }

        if (balance == 1) {
            return "год";
        }

        return "года";
    }

}