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
            File file = new File("ledger.dat");
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(System.lineSeparator());

            // Count of the customers
            int tally = 0;


            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] tokens = line.split("   ");

                String accountNumber = tokens[0];
                Double startingBalance = Double.parseDouble(tokens[1]);
                Double mostRecentPurchase = Double.parseDouble(tokens[2]);
                Double mostRecentPayment = Double.parseDouble(tokens[3]);

                // Compute month's balance for a customer
                Double monthsBalance = computeMonthsBalance(startingBalance, mostRecentPurchase, mostRecentPayment);

            }
            scanner.close();
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

