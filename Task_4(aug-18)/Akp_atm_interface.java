import java.util.Scanner;

class Akp_BankAccount {
     private double balance;

     public Akp_BankAccount(double initialBalance) {
          balance = initialBalance;
     }

     public boolean deposit(double amount) {
          if (amount > 0) {
               balance += amount;
               return true;
          }
          return false;
     }

     public boolean withdraw(double amount) {
          if (amount > 0 && amount <= balance) {
               balance -= amount;
               return true;
          }
          return false;
     }

     public double checkBalance() {
          return balance;
     }
}

class ATM {
     private Akp_BankAccount bankAccount;
     private Scanner scanner;

     public ATM(Akp_BankAccount account) {
          bankAccount = account;
          scanner = new Scanner(System.in);
     }

     public void displayOptions() {
          System.out.println("ATM Options:");
          System.out.println("1. Withdraw");
          System.out.println("2. Deposit");
          System.out.println("3. Check Balance");
          System.out.println("4. Exit");
     }

     public void run() {
          while (true) {
               displayOptions();
               System.out.print("Select an option: ");
               int choice = scanner.nextInt();

               switch (choice) {
                    case 1:
                         System.out.print("Enter the amount to withdraw: ");
                         double withdrawAmount = scanner.nextDouble();
                         if (bankAccount.withdraw(withdrawAmount)) {
                              System.out.println("Withdrawal successful.");
                         } else {
                              System.out.println("Withdrawal failed. Insufficient balance.");
                         }
                         break;

                    case 2:
                         System.out.print("Enter the amount to deposit: ");
                         double depositAmount = scanner.nextDouble();
                         if (bankAccount.deposit(depositAmount)) {
                              System.out.println("Deposit successful.");
                         } else {
                              System.out.println("Deposit failed. Invalid amount.");
                         }
                         break;

                    case 3:
                         System.out.println("Your balance: " + bankAccount.checkBalance());
                         break;

                    case 4:
                         System.out.println("Thank you for using the Akp_Banks_ATM!");
                         scanner.close();
                         return;

                    default:
                         System.out.println("Invalid choice. Please select a valid option.");
                         break;
               }
          }
     }
}

public class Akp_atm_interface {
     public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          System.out.print("Enter initial account balance: ");
          double initialBalance = scanner.nextDouble();

          Akp_BankAccount userAccount = new Akp_BankAccount(initialBalance);
          ATM atm = new ATM(userAccount);
          atm.run();
          scanner.close();
     }
}
