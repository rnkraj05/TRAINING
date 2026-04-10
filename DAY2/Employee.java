import java.util.Scanner;

public class Employee {
    
    // Declare employee attributes
    int empID;
    String empName;
    double salary;

    // Create constructor to initialize object values
    Employee(int id, String name, double sal) {
        empID = id;
        empName = name;
        salary = sal;
    }
    
    // Method to display 
    void displayEmployee() {
        System.out.println("Employee ID: " + empID);
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee Salary: " + salary);
    }

    public static void main(String[] args) {
        // // create object and pass values 
        // Employee e1 = new Employee(201,"Raunak",50000);

        // //Display
        // e1.displayEmployee();

        Scanner sc = new Scanner(System.in);
        // Taking input
        System.out.println("Enter Employee ID: ");
        int id = sc.nextInt();
        
        sc.nextLine();

        System.out.println("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Employee Salary: ");
        double sal = sc.nextDouble();

        //Display
        System.out.println(id +" " + name +" "+  sal);
 }
}
    


