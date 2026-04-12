import java.util.*;

interface Transaction {
    void processTransaction();
    void display();
}

// Income
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
        System.out.println("ID: " + id + " | Type: Income | Amount: " + amount);
    }
}

// Expense
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
        System.out.println("ID: " + id + " | Type: Expense | Amount: " + amount);
    }
}

// Main class
public class UserInterfaceDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Transaction> list = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n========== Transaction Manager ==========");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. Exit");
            System.out.println("=========================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id1 = sc.nextInt();

                    System.out.print("Enter Income Amount: ");
                    double inc = sc.nextDouble();

                    Transaction t1 = new Income(id1, inc);
                    list.add(t1);
                    t1.processTransaction();
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int id2 = sc.nextInt();

                    System.out.print("Enter Expense Amount: ");
                    double exp = sc.nextDouble();

                    Transaction t2 = new Expense(id2, exp);
                    list.add(t2);
                    t2.processTransaction();
                    break;

                case 3:
                    if (list.isEmpty()) {
                        System.out.println("No transactions available.");
                    } else {
                        System.out.println("\n--- Transaction List ---");
                        for (Transaction t : list) {
                            t.display();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Thank you! Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);
    }
}