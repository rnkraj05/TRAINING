import java.util.*;

// 🔹 Transaction Interface (Abstraction)
interface Transaction {
    double getAmount();
    String getType();
    void display();
}

// 🔹 Transaction Implementation
class BasicTransaction implements Transaction {
    int id;
    String type;
    double amount;

    BasicTransaction(int id, String type, double amount) {
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

// 🔹 Service Layer (Business Logic)
class TransactionService {
    private List<Transaction> list = new ArrayList<>();

    public void addTransaction(Transaction t) {
        list.add(t);
    }

    public void showTransactions() {
        if (list.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction t : list) {
                t.display();
            }
        }
    }

    public double calculateBalance() {
        double balance = 0;
        for (Transaction t : list) {
            if (t.getType().equalsIgnoreCase("Income")) {
                balance += t.getAmount();
            } else {
                balance -= t.getAmount();
            }
        }
        return balance;
    }
}

// 🔹 Future API Integration (Mock Service)
class CurrencyConverterService {
    // Placeholder for external API
    public double convertINRtoUSD(double amount) {
        double rate = 0.012; // dummy rate
        return amount * rate;
    }
}

// 🔹 Main Class
public class ScalableApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TransactionService service = new TransactionService();
        CurrencyConverterService converter = new CurrencyConverterService();

        int choice;

        do {
            System.out.println("\n===== Scalable Transaction Manager =====");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Show Balance");
            System.out.println("4. Convert Balance to USD (Future API)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Type (Income/Expense): ");
                    String type = sc.next();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    service.addTransaction(new BasicTransaction(id, type, amount));
                    System.out.println("Transaction Added!");
                    break;

                case 2:
                    service.showTransactions();
                    break;

                case 3:
                    double balance = service.calculateBalance();
                    System.out.println("Total Balance: " + balance);
                    break;

                case 4:
                    double bal = service.calculateBalance();
                    double usd = converter.convertINRtoUSD(bal);
                    System.out.println("Balance in USD: " + usd);
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