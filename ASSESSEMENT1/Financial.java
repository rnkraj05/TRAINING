import java.util.*;

// 🔸 Custom Exception for Invalid Amount
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

// 🔸 Custom Exception for Duplicate Transaction
class DuplicateTransactionException extends Exception {
    public DuplicateTransactionException(String message) {
        super(message);
    }
}

class Transaction {
    int id;
    String type;
    double amount;

    Transaction(int id, String type, double amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
    }

    void display() {
        System.out.println(id + " | " + type + " | " + amount);
    }
}

public class Financial {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Transaction> list = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- Financial Transaction Manager ---");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    try {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        // 🔹 Check Duplicate ID
                        for (Transaction t : list) {
                            if (t.id == id) {
                                throw new DuplicateTransactionException("Duplicate ID not allowed!");
                            }
                        }

                        System.out.print("Enter Type: ");
                        String type = sc.nextLine();

                        System.out.print("Enter Amount: ");
                        double amount = sc.nextDouble();

                        // 🔹 Check Invalid Amount
                        if (amount <= 0) {
                            throw new InvalidAmountException("Amount must be greater than 0!");
                        }

                        list.add(new Transaction(id, type, amount));
                        System.out.println("Transaction Added!");

                    } catch (InvalidAmountException | DuplicateTransactionException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No transactions found.");
                    } else {
                        for (Transaction t : list) {
                            t.display();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);
    }
}