import java.util.Scanner;

public class Method {
    //Method 1: Addition
    public static int add(int a, int b) {
           return a + b;
        }
    
    //Method 2: Subtraction
    public static int sub(int a, int b) {
            return a - b;
    }

    //Method 3: Multiplication
    public static int mul(int a, int b) {
            return a * b;
    }

    //Method 4: Division
    public static int div(int a, int b) {
    if (b != 0) {
        return a / b;
    } else {
        return 0;   // default value
    }
}

    public static void main(String[] args) {
        //Scanner object to take input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int m = sc.nextInt();
        System.out.print("Enter second number: ");
        int n = sc.nextInt();

        //Call methods and print results
        System.out.println("Addition: " + add(m,n));
        System.out.println("Subtraction: " + sub(m,n));
        System.out.println("Multiplication: " + mul(m,n));
        System.out.println("Division: " + div(m,n));
    }
}

