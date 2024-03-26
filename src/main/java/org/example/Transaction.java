package org.example;

public class Transaction {
    private String date;
    private double amount;
    private String category;

    public Transaction(String date, double amount, String category) {
        this.date = date;
        this.amount = amount;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Datum: " + date + ", Částka: " + amount + ", Kategorie: " + category;
    }
}
