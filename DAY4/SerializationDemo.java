// import java.io.FileInputStream;
// import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.*;

//Student class
class Student implements Serializable {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}

public class SerializationDemo {
    public static void main(String[] args) {

        //Serialisation method
        try {
            Student s1 = new Student(1, "Raunak");

            ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("student.ser")
            );

            oos.writeObject(s1);
            oos.close();

            System.out.println("File created successfully!");

        } catch (Exception e) {
            System.out.println(e);
        }
    
        // Deseriliasation method
        try {
            //Step 1: Open file
            FileInputStream fis = new FileInputStream("student.ser");

            //Step 2: Create OnjectInputStream
            ObjectInputStream ois = new ObjectInputStream(fis);

            //Step 3: Read Object
            Student s = (Student) ois.readObject();

            //Step 4: Display data
            s.display();

            //Step 5: close stream
            ois.close();
            fis.close();
        } catch (Exception e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}