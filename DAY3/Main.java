interface Vehicle {
    void start();     // abstract method
    void stop();      // abstract method
    void fuelType();  // abstract method
}

// Implementing class
class Car implements Vehicle {
    
    public void start() {
        System.out.println("Car starts with key");
    }

    public void stop() {
        System.out.println("Car stops with brake");
    }

    public void fuelType() {
        System.out.println("Car uses Petrol");
    }
}

// Another implementing class
class Bike implements Vehicle {
    
    public void start() {
        System.out.println("Bike starts with self-start");
    }

    public void stop() {
        System.out.println("Bike stops with brake");
    }

    public void fuelType() {
        System.out.println("Bike uses Petrol");
    }
}

public class Main {
    public static void main(String[] args) {
        
        Vehicle v1 = new Car();
        Vehicle v2 = new Bike();

        v1.start();
        v1.stop();
        v1.fuelType();

        System.out.println();

        v2.start();
        v2.stop();
        v2.fuelType();
    }
}