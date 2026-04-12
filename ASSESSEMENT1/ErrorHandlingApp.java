import java.util.*;

// 🔹 Custom Exceptions
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}

class UnauthorizedAccessException extends Exception {
    public UnauthorizedAccessException(String msg) {
        super(msg);
    }
}

// 🔹 Transaction Interface
interface Transaction {
    double getAmount();
    String getType();
    void display();
}

// 🔹 Transaction Implementation
class TransactionImpl implements Transaction {
    int id;
    String type;
    double amount;

    TransactionImpl(int id, String type, double amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public void display() {
        System.out.println("ID: " + id + " | " + type + " | " + amount);
    }
}

// 🔹 Main Class
public class ErrorHandlingApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Transaction> list = new ArrayList<>();

        double balance = 0;
        int choice;

        // 🔒 Simple authentication
        try {
            System.out.print("Enter password: ");
            String pass = sc.next();

            if (!pass.equals("admin123")) {
                throw new UnauthorizedAccessException("Access Denied!");
            }

        } catch (UnauthorizedAccessException e) {
            System.out.println(e.getMessage());
            return; // stop program
        }

        do {
            System.out.println("\n===== Transaction Manager =====");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. Show Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter ID: ");
                        int id1 = sc.nextInt();

                        System.out.print("Enter Income Amount: ");
                        double inc = sc.nextDouble();

                        if (inc <= 0) {
                            throw new IllegalArgumentException("Invalid amount!");
                        }

                        list.add(new TransactionImpl(id1, "Income", inc));
                        balance += inc;

                        System.out.println("Income Added!");
                        break;

                    case 2:
                        System.out.print("Enter ID: ");
                        int id2 = sc.nextInt();

                        System.out.print("Enter Expense Amount: ");
                        double exp = sc.nextDouble();

                        if (exp > balance) {
                            throw new InsufficientFundsException("Not enough balance!");
                        }

                        list.add(new TransactionImpl(id2, "Expense", exp));
                        balance -= exp;

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
                        System.out.println("Current Balance: " + balance);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter correct data.");
                sc.nextLine(); // clear buffer
                choice = 0;
            } catch (InsufficientFundsException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                choice = 0;
            }

        } while (choice != 5);
    }
}