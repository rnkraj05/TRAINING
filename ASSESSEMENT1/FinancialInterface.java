import java.util.*;

// 🔹 Interface
interface Transaction {
    void processTransaction();   // abstract method
    void display();              // abstract method
}

// 🔹 Income class
class Income implements Transaction {
    int id;
    double amount;

    Income(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public void processTransaction() {
        System.out.println("Income added: +" + amount);
    }

    public void display() {
        System.out.println("ID: " + id + ", Amount: " + amount);
    }
}

// 🔹 Expense class
class Expense implements Transaction {
    int id;
    double amount;

    Expense(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public void processTransaction() {
        System.out.println("Expense deducted: -" + amount);
    }

    public void display() {
        System.out.println("ID: " + id + ", Amount: " + amount);
    }
}

// 🔹 Transfer class
class Transfer implements Transaction {
    int id;
    double amount;

    Transfer(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public void processTransaction() {
        System.out.println("Amount transferred: " + amount);
    }

    public void display() {
        System.out.println("ID: " + id + ", Amount: " + amount);
    }
}

// 🔹 Main class
public class FinancialInterface {
    public static void main(String[] args) {

        ArrayList<Transaction> list = new ArrayList<>();

        list.add(new Income(1, 5000));
        list.add(new Expense(2, 2000));
        list.add(new Transfer(3, 1500));

        for (Transaction t : list) {
            t.display();
            t.processTransaction();
            System.out.println();
        }
    }
}