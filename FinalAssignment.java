/*
Student: Aasia 780273
Date: January 9th, 2024
Course: ICD 2O0
Assignment: Assignment 4, Credit River Credit Cards
Description: A code that calculates the final balance of a customer
Variable Dictoniary:
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FinalAssignment {
    public static void main(String[] args) {

        try {
            // Open the file to read data
            File file = new File("ledger.dat");
            // Read input from file
            Scanner scanner = new Scanner(file);
            // Set line ending character
            scanner.useDelimiter(System.lineSeparator());

            // Count of the customers
            int tally = 0;
            // Sum of all the account balances in the file
            double sumOfBalances = 0.0;
            // The average balance (sumofbalances/total number of customers)
            double averageBalance = 0.0;
            // The account with lowest balance
            double lowestBalance = Double.MAX_VALUE;
            // The account number of the lowest balance
            String lowestBalanceAccountNumber = "";
            // The account with highest balance
            double highestBalance = Double.MIN_VALUE;
            // The account number of the highest balance
            String highestBalanceAccountNumber = "";

            System.out.println("ACCOUNT #\tMONTHLY BALANCE");
            System.out.println("===========================");

            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] tokens = line.split("   ");

                String accountNumber = tokens[0];
                Double startingBalance = Double.parseDouble(tokens[1].trim());
                Double mostRecentPurchase = Double.parseDouble(tokens[2].trim());
                Double mostRecentPayment = Double.parseDouble(tokens[3].trim());

                // Compute month's balance for a customer
                Double monthsBalance = computeMonthsBalance(startingBalance, mostRecentPurchase, mostRecentPayment);

                // Find the account with the lowest balance
                if (monthsBalance < lowestBalance) {
                    lowestBalanceAccountNumber = accountNumber;
                    lowestBalance = monthsBalance;
                }

                // Find the account with highest balance
                if (monthsBalance > highestBalance) {
                    highestBalanceAccountNumber = accountNumber;
                    highestBalance = monthsBalance;
                }

                // Sum of total balances
                sumOfBalances = sumOfBalances + monthsBalance;
                // Count of the number of customers in the file
                tally = tally + 1;

                // Print account number and monthly balance
                System.out.printf("%s\t\t\t%.2f\n", accountNumber, monthsBalance);
            }

            scanner.close();

            // Calculate average balance of all customers
            averageBalance = sumOfBalances / tally;

            System.out.println("===========================");
            System.out.printf("Average Balance: %.2f\n", averageBalance);
            System.out.println("===========================");

            System.out.printf("Highest final Balance: %s, %.2f\n", highestBalanceAccountNumber, highestBalance);
            System.out.printf("Lowest final Balance: %s, %.2f\n", lowestBalanceAccountNumber, lowestBalance);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // A function which computes the month's balance for a given customer
    public static Double computeMonthsBalance(Double balance, Double purchase, Double payment) {
        Double monthsBalance = (1 + 0.28/12) * balance - payment + purchase;
        return monthsBalance;
    }
}

