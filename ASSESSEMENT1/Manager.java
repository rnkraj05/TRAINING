import java.util.*;

class Transaction {
    int id;
    String type;
    double amount;

    // Constructor
    Transaction(int id, String type, double amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
    }

    void display() {
        System.out.println(id + " | " + type + " | " + amount);
    }
}

public class Manager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Using Collection (ArrayList)
        ArrayList<Transaction> transactions = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- Financial Transaction Manager ---");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Delete Transaction");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Type (Income/Expense): ");
                    String type = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    transactions.add(new Transaction(id, type, amount));
                    System.out.println("Transaction Added!");
                    break;

                case 2:
                    if (transactions.isEmpty()) {
                        System.out.println("No transactions available.");
                    } else {
                        for (Transaction t : transactions) {
                            t.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();

                    boolean found = false;

                    Iterator<Transaction> it = transactions.iterator();
                    while (it.hasNext()) {
                        Transaction t = it.next();
                        if (t.id == delId) {
                            it.remove();
                            found = true;
                            System.out.println("Transaction Deleted!");
                        }
                    }

                    if (!found) {
                        System.out.println("Transaction not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }
}