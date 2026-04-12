import java.util.*;

// 🔹 Abstract class
abstract class Transaction {
    int id;
    double amount;

    Transaction(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    // Abstract method (common behavior)
    abstract void processTransaction();

    // Common method
    void display() {
        System.out.println("ID: " + id + ", Amount: " + amount);
    }
}

// 🔹 Income class
class Income extends Transaction {

    Income(int id, double amount) {
        super(id, amount);
    }

    void processTransaction() {
        System.out.println("Income added: +" + amount);
    }
}

// 🔹 Expense class
class Expense extends Transaction {

    Expense(int id, double amount) {
        super(id, amount);
    }

    void processTransaction() {
        System.out.println("Expense deducted: -" + amount);
    }
}

// 🔹 Transfer class
class Transfer extends Transaction {

    Transfer(int id, double amount) {
        super(id, amount);
    }

    void processTransaction() {
        System.out.println("Amount transferred: " + amount);
    }
}

// 🔹 Main class
public class FinancialAbstraction {
    public static void main(String[] args) {

        ArrayList<Transaction> list = new ArrayList<>();

        // Creating objects
        list.add(new Income(1, 5000));
        list.add(new Expense(2, 2000));
        list.add(new Transfer(3, 1500));

        // Processing transactions
        for (Transaction t : list) {
            t.display();
            t.processTransaction();
            System.out.println();
        }
    }
}