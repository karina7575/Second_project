package homework6.zoo;

public class Runner {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Dog dog = new Dog();
        Bird bird = new Bird();
        Zoo<Tiger, Dog, Bird> zoo = new Zoo(tiger, dog, bird);
        Tiger tiger1 = zoo.getAnimal1();
        tiger1.growl();
        Dog dog1 = zoo.getAnimal2();
        dog1.bark();
        Bird bird1 = zoo.getAnimal3();
        bird1.fly();
    }
}
