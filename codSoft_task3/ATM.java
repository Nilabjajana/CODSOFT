import java.util.Scanner;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {     
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check balance");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                withdraw(scanner);
            } else if (choice == 2) {
                deposit(scanner);
            } else if (choice == 3) {
                checkBalance();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the ATM!");
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        int amount = scanner.nextInt();

        if (amount % 10 != 0) {
            System.out.println("The amount must be a multiple of 10. Please try again.");
            return;
        }

        if (amount > account.getBalance()) {
            System.out.println("Insufficient balance. Please try a smaller amount.");
            return;
        }

        account.withdraw(amount);
        System.out.println("You have successfully withdrawn " + amount);
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        int amount = scanner.nextInt();

        if (amount % 10 != 0) {
            System.out.println("The amount must be a multiple of 10. Please try again.");
            return;
        }

        account.deposit(amount);
        System.out.println("You have successfully deposited " + amount);
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        atm.start();
    }
}

class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }
}
