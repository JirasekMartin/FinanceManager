package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class FinanceManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Transaction> transactions = new ArrayList<>();

        boolean running = true;
        while (running) {
            System.out.println("Finance Manager");
            System.out.println("1. Přidat transakci");
            System.out.println("2. Zobrazit transakce");
            System.out.println("3. Konec");

            System.out.print("Vyberte možnost: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    String date = "";
                    boolean validDate = false;
                    while (!validDate) {
                        System.out.print("Datum (DD/MM/YYYY): ");
                        date = scanner.nextLine();
                        if (date.matches("(0?[1-9]|[12][0-9]|3[01])[/.](0?[1-9]|1[0-2])[/.]\\d{4}")) {
                            validDate = true;
                        } else {
                            System.out.println("Neplatný formát data. Zadejte prosím ve formátu DD/MM/YYYY nebo DD.MM.YYYY.");
                        }
                    }

                    double amount = 0;
                    boolean validAmount = false;
                    while (!validAmount) {
                        System.out.print("Částka: ");
                        String amountStr = scanner.nextLine();
                        if (amountStr.matches("\\d+(\\.\\d+)?")) {
                            amount = Double.parseDouble(amountStr);
                            validAmount = true;
                        } else {
                            System.out.println("Neplatná částka. Zadejte prosím platné číslo.");
                        }
                    }

                    String category = "";
                    boolean validCategory = false;
                    while (!validCategory) {
                        System.out.print("Kategorie: ");
                        category = scanner.nextLine();
                        if (category.matches("[\\p{L}\\s]+")) {
                            validCategory = true;
                        } else {
                            System.out.println("Neplatná kategorie. Zadejte prosím pouze písmena a mezery.");
                        }
                    }

                    transactions.add(new Transaction(date, amount, category));
                    System.out.println("Transakce přidána.");
                    break;
                case 2:
                    System.out.println("Seznam transakcí:");
                    for (Transaction transaction : transactions) {
                        System.out.println(transaction);
                    }
                    break;
                case 3:
                    System.out.println("Konec programu.");
                    running = false;
                    break;
                default:
                    System.out.println("Neplatná volba.");
            }
        }
        scanner.close();
    }
}