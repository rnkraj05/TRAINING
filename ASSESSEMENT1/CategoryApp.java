import java.util.*;

interface Transaction {
    String getCategory();
    void display();
}

// Transaction class
class TransactionImpl implements Transaction {
    int id;
    String type;
    double amount;
    String category;

    TransactionImpl(int id, String type, double amount, String category) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void display() {
        System.out.println("ID: " + id + 
                           " | " + type + 
                           " | " + amount + 
                           " | Category: " + category);
    }
}

// Main class
public class CategoryApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Transaction> list = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Transaction Manager =====");
            System.out.println("1. Add Transaction");
            System.out.println("2. View All Transactions");
            System.out.println("3. Filter by Category");
            System.out.println("4. Exit");
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

                    System.out.print("Enter Category (Food/Entertainment/Bills): ");
                    String category = sc.next();

                    list.add(new TransactionImpl(id, type, amount, category));
                    System.out.println("Transaction Added!");
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
                    System.out.print("Enter category to filter: ");
                    String filterCat = sc.next();

                    boolean found = false;

                    for (Transaction t : list) {
                        if (t.getCategory().equalsIgnoreCase(filterCat)) {
                            t.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No transactions found in this category.");
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