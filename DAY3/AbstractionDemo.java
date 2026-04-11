/*
In java Abstraction can be done in two ways
1. Abstract Class
here we will define a class with some abstract methods and concrete methods
    Steo 1: Creating a class using abstract keyword 
    Step 2: Define abstract methods(methods without a body) and concrete methods (methods with a  body) in the abstract class.
    Step 3: Create a subclass that extends the abstract class and provides implementations for the abstraction methods. 
    Step 4: Create an object of the subclass and call the methods to demonstrate abstractions.
    Step 5: Run the program to see how abstraction works in JAVA.

2. Interface

 */

abstract class Animal {
    // Abstract method (does not have a body)
    public abstract void makeSound();

    //Regular method
    public void sleep() {
        System.out.println("Zzz...");
    }
}

class Dog extends Animal {
    // Providing implementations for the abstract method
    public void makeSound() {
        System.out.println("Woof!");
    }
}
class Bird extends Animal {
    //Providing implementations for the abstract method
    public void makeSound() {
        System.out.println("Tweet!");
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        // statement before = is object of the class and
        // after = is constructor of the class
        Bird bird = new Bird();
        
        dog.makeSound(); //Output: Woof! coming from child class method
        dog.sleep(); //Output: Zzz... coming from parent class method

        bird.makeSound(); //Output: Tweet!
        bird.sleep(); //Output: Zzz...
    }
}

/*
Observations: 
1. Abstraction allows us to hide the implementations details and show only the functionality to the user.
2. In the above example, the Animal class is an abstract class that defines 
3. The Dog and Bird
*/