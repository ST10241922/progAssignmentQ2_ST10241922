/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankaccount;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + formatCurrency(balance));
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + formatCurrency(balance));
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Holder: " + getAccountHolder());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Current Balance: " + formatCurrency(getBalance()));
    }

    private String formatCurrency(double amount) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        return currencyFormatter.format(amount);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Banking System!");

        // Create a bank account for the user
        Account userAccount = new Account("123456", "John Doe", 1000.0);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Exiting Banking System. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    double depositAmount;
                    if (scanner.hasNextDouble()) {
                        depositAmount = scanner.nextDouble();
                        userAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid input for deposit amount.");
                    }
                    break;

                case 2:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawalAmount;
                    if (scanner.hasNextDouble()) {
                        withdrawalAmount = scanner.nextDouble();
                        userAccount.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("Invalid input for withdrawal amount.");
                    }
                    break;

                case 3:
                    userAccount.displayAccountInfo();
                    break;

                case 4:
                    System.out.println("Exiting Banking System. Goodbye!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }
}
