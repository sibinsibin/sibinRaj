package MySecondProject;

import java.util.Random;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Bank {
    private final Map<Integer, Double> accounts;

    public Bank() {
        accounts = new HashMap<>();

    }

    public void createAccount(Integer accountNumber, double initialBalance) {

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists with account number " + accountNumber);
        } else {
            accounts.put(accountNumber, initialBalance);
            System.out.println("Your Account number is: " + accountNumber + "\n");
            System.out.println("\tAccount created Successfully.");
        }
    }

    public void deposit(Integer accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {

            double currentBalance = accounts.get(accountNumber);
            accounts.put(accountNumber, currentBalance + amount);
            System.out.println("Deposit of ₹" + amount + " successful for account number " + accountNumber);
        } else {
            System.out.println("Account does not exist with account number " + accountNumber);
        }
    }

    public void withdraw(Integer accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                accounts.put(accountNumber, currentBalance - amount);
                System.out.println("Withdrawal of " + amount + " successful for account number " + accountNumber);
            } else {
                System.out.println("Insufficient balance for account number " + accountNumber);
            }
        } else {
            System.out.println("Account does not exist with account number " + accountNumber);
        }
    }

    public void checkBalance(Integer accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            System.out.println("Account number: " + accountNumber + ", Balance: " + currentBalance);
        } else {
            System.out.println("Account does not exist with account number " + accountNumber);
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("===== Banking System =====\n");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit\n");
            System.out.print("Enter your choice? : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n\tCREATING ACCOUNT");
                    System.out.println("\t================\n");
                    System.out.print("Enter User Name: ");
                    String name = scanner.nextLine();
                    //System.out.print("Enter a account number: ");
                    //String accountNumber = scanner.nextLine();

                    Random random = new Random();
                    int accountNumber = random.nextInt(1000000000) + 1;









                    /*if (ACcountNumber < 100000000 || ACcountNumber > 999999999) {

                        // if(AccountNumber!=100000000){
                        System.out.println("\nAccount number is not valid!!!!");

                        System.out.println("\tPlease Enter your Account Number in Nine Digit:-");*/
                    // } else {

                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine();
                    bank.createAccount(accountNumber, initialBalance);
                    //  }


                    break;
                case 2:
                    System.out.println("\n\tDEPOSITING AMOUNT");
                    System.out.println("\t=================\n");
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();


                        System.out.print("Enter deposit amount₹: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine();
                        bank.deposit(accountNumber, depositAmount);

                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    scanner.nextLine();
                    bank.withdraw(accountNumber, withdrawalAmount);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    bank.checkBalance(accountNumber);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for using the banking system!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }

        scanner.close();
    }
}

