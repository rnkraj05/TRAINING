import java.util.*;

interface Transaction {
    double getAmount();   // for balance calculation
    String getType();     // to check type
    void display();
}

// Income Class
class Income implements Transaction {
    int id;
    double amount;

    Income(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return "Income";
    }

    public void display() {
        System.out.println("ID: " + id + " | Income | " + amount);
    }
}

// Expense Class
class Expense implements Transaction {
    int id;
    double amount;

    Expense(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return "Expense";
    }

    public void display() {
        System.out.println("ID: " + id + " | Expense | " + amount);
    }
}

// Main Class
public class BalanceApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Transaction> list = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Transaction Manager =====");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. Show Total Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id1 = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double inc = sc.nextDouble();

                    list.add(new Income(id1, inc));
                    System.out.println("Income Added!");
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int id2 = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double exp = sc.nextDouble();

                    list.add(new Expense(id2, exp));
                    System.out.println("Expense Added!");
                    break;

                case 3:
                    if (list.isEmpty()) {
                        System.out.println("No transactions.");
                    } else {
                        for (Transaction t : list) {
                            t.display();
                        }
                    }
                    break;

                case 4:
                    double balance = 0;

                    for (Transaction t : list) {
                        if (t.getType().equals("Income")) {
                            balance += t.getAmount();
                        } else {
                            balance -= t.getAmount();
                        }
                    }

                    System.out.println("Total Balance: " + balance);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}