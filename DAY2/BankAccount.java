public class BankAccount {
    
    // Make variables private (data hiding)
    private int accountNumber;
    private double balance;

    // Setter methods to assign values
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getter methods to access values
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        
        //Create object
        BankAccount acc = new BankAccount();

        // Set values using setter methods
        acc.setAccountNumber(12345);
        acc.setBalance(25000.50);

        //Access values using getter methods
        System.out.println("Account Number: " + acc.getAccountNumber());
        System.out.println("Banlance: " + acc.getBalance());
    }
}
