class Animal{
    String name;
    int age;
    Animal(String name){
        this.name=name;
    }
    void makeSound(){
        System.out.println("Animal makes a sound");
    }
}
class Dog extends Animal{
    Dog(String name){
        super(name);
    }
    @Override
    void makeSound(){
        System.out.println("Dog barks");
    }
}
class Cat extends Animal{
    Cat(String name){
        super(name);
    }
    @Override
    void makeSound(){
        System.out.println("Cat meows");
    }
}
class Bird extends Animal{
    Bird(String name){
        super(name);
    }
    @Override
    void makeSound(){
        System.out.println("Bird chirps");
    }
}
public class AnimalTest{
    public static void main(String[] args){
        Animal[] animals={new Dog("Buddy"),new Cat("Kitty"),new Bird("Parrot")};
        for(Animal a:animals){
            a.makeSound();
        }
    }
}
