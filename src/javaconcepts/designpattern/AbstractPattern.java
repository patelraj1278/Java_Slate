package javaconcepts.designpattern;

public class AbstractPattern {
}

interface Animal {
    String getAnimal();
    String makeSound();
}

//concrete implementation Duck:
class Duck implements Animal {

    @Override
    public String getAnimal() {
        return "Duck";
    }

    @Override
    public String makeSound() {
        return "Squeks";
    }
}

//concrete implementation Dog:
class Dog implements Animal {

    @Override
    public String getAnimal() {
        return "Dog";
    }

    @Override
    public String makeSound() {
        return "Bow Bow";
    }
}

//we can create more concrete implementations of Animal interface
interface AbstractFactory<T> {
    T create(String animalType) ;
}

class AnimalFactory implements AbstractFactory<Animal> {

    @Override
    public Animal create(String animalType) {
        if ("Dog".equalsIgnoreCase(animalType)) {
            return new Dog();
        } else if ("Duck".equalsIgnoreCase(animalType)) {
            return new Duck();
        }

        return null;
    }

}

//Next, we'll implement an AnimalFactory using the Factory Method design pattern
class FactoryProvider {
    public static AbstractFactory getFactory(String choice){

        if("Animal".equalsIgnoreCase(choice)){
            return new AnimalFactory();
        }
        else if("Color".equalsIgnoreCase(choice)){
            //return new ColorFactory();
        }

        return null;
    }
}




