import java.util.*;

// Custom Exception
class InvalidAmountException extends Exception {
    public InvalidAmountException(String msg) {
        super(msg);
    }
}

class Transaction {
    Integer id;      // Wrapper class
    String type;
    Double amount;   // Wrapper class

    Transaction(Integer id, String type, Double amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
    }

    void display() {
        System.out.println(id + " | " + type + " | " + amount);
    }
}

public class FinancialWrapper {
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
                        String idInput = sc.next();

                        // Wrapper conversion
                        Integer id = Integer.parseInt(idInput);

                        System.out.print("Enter Type: ");
                        String type = sc.next();

                        System.out.print("Enter Amount: ");
                        String amtInput = sc.next();

                        Double amount = Double.parseDouble(amtInput);

                        if (amount <= 0) {
                            throw new InvalidAmountException("Amount must be greater than 0");
                        }

                        list.add(new Transaction(id, type, amount));
                        System.out.println("Transaction Added!");

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format!");
                    } catch (InvalidAmountException e) {
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