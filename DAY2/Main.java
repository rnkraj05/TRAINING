import java.util.Scanner;

class Student {
    String name;
    int age;
    int marks;
    
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
    }
}
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(); //object creation
        // //Assign the values
        s1.name = "RAUNAK";
        s1.age = 21;
        s1.marks = 60;

        //Display details
        s1.display();
    }
}