import java.util.*;

class BankAccount {
    private String accountId;
    private String name;
    private String password;
    private double balance;

    public BankAccount(String accountId, String name, String password, double initialBalance) {
        this.accountId = accountId;
        this.name = name;
        this.password = password;
        this.balance = initialBalance;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public boolean login(String enteredPassword) {
        return this.password.equals(enteredPassword);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        } else {
            System.out.println("Invalid or insufficient balance.");
        }
    }

    public void checkBalance() {
        System.out.println("Balance: ₹" + balance);
    }

    public boolean transferTo(BankAccount receiver, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            receiver.balance += amount;
            return true;
        }
        return false;
    }
}

public class BankSystem {
    private static Map<String, BankAccount> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BankAccount currentUser = null;

        while (true) {
            System.out.println("\n1. Create Account\n2. Login\n3. Exit");
            System.out.print("Choose option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    currentUser = createAccount();
                    break;
                case 2:
                    currentUser = login();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }

            if (currentUser != null) {
                userMenu(currentUser);
                currentUser = null; // logout after session
            }
        }
    }

    private static BankAccount createAccount() {
        System.out.print("Enter Account ID: ");
        String id = scanner.nextLine();

        if (accounts.containsKey(id)) {
            System.out.println("Account ID already exists.");
            return null;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Set Password: ");
        String password = scanner.nextLine();

        BankAccount account = new BankAccount(id, name, password, 0);
        accounts.put(id, account);
        System.out.println("Account created successfully!");
        return account;
    }

    private static BankAccount login() {
        System.out.print("Enter Account ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        BankAccount account = accounts.get(id);
        if (account != null && account.login(password)) {
            System.out.println("Login successful. Welcome " + account.getName());
            return account;
        } else {
            System.out.println("Invalid ID or password.");
            return null;
        }
    }

    private static void userMenu(BankAccount user) {
        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Transfer Money\n5. Logout");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ₹");
                    user.deposit(scanner.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter withdraw amount: ₹");
                    user.withdraw(scanner.nextDouble());
                    break;
                case 3:
                    user.checkBalance();
                    break;
                case 4:
                    System.out.print("Enter receiver Account ID: ");
                    String toId = scanner.nextLine();
                    BankAccount receiver = accounts.get(toId);
                    if (receiver == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    System.out.print("Enter amount to transfer: ₹");
                    double amount = scanner.nextDouble();
                    if (user.transferTo(receiver, amount)) {
                        System.out.println("Transfer successful.");
                    } else {
                        System.out.println("Transfer failed. Insufficient funds.");
                    }
                    break;
                case 5:
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
