package com.bridgelab.oops;
import java.util.Scanner;



    class Account {
        private double balance;

        public Account(double initialBalance) {
            if (initialBalance >= 0) {
                this.balance = initialBalance;
            } else {
                throw new IllegalArgumentException("Initial balance must be non-negative");
            }
        }

        public void credit(double amount) {
            balance += amount;
        }

        public void debit(double amount) {
            if (amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("Debit amount exceeded account balance.");
            }
        }

        public double getBalance() {
            return balance;
        }
    }

public class AccountTest {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();

            Account account = new Account(initialBalance);

            System.out.print("Enter credit amount: ");
            double creditAmount = scanner.nextDouble();
            account.credit(creditAmount);

            System.out.println("New balance after credit: " + account.getBalance());

            System.out.print("Enter debit amount: ");
            double debitAmount = scanner.nextDouble();
            account.debit(debitAmount);

            System.out.println("New balance after debit: " + account.getBalance());
        }
    }


