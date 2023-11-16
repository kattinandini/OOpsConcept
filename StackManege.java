package com.bridgelab.oops;
import java.util.ArrayList;
import java.util.Scanner;



    class Stock {
        private String name;
        private int numShares;
        private double sharePrice;

        public Stock(String name, int numShares, double sharePrice) {
            this.name = name;
            this.numShares = numShares;
            this.sharePrice = sharePrice;
        }

        public double calculateValue() {
            return numShares * sharePrice;
        }

        public String getName() {
            return name;
        }

        public int getNumShares() {
            return numShares;
        }

        public double getSharePrice() {
            return sharePrice;
        }
    }

    class StockPortfolio {
        private ArrayList<Stock> stocks;

        public StockPortfolio() {
            this.stocks = new ArrayList<>();
        }

        public void addStock(Stock stock) {
            stocks.add(stock);
        }

        public double calculateTotalValue() {
            double totalValue = 0;
            for (Stock stock : stocks) {
                totalValue += stock.calculateValue();
            }
            return totalValue;
        }

        public void generateReport() {
            System.out.println("Stock Report:");
            System.out.printf("%-15s %-15s %-15s %-15s\n", "Stock Name", "Num of Shares", "Share Price", "Stock Value");

            for (Stock stock : stocks) {
                System.out.printf("%-15s %-15d %-15.2f %-15.2f\n", stock.getName(), stock.getNumShares(), stock.getSharePrice(), stock.calculateValue());
            }

            System.out.println("\nTotal Stock Value: " + calculateTotalValue());
        }
    }

public class StackManege {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of stocks: ");
            int n = scanner.nextInt();

            StockPortfolio portfolio = new StockPortfolio();

            for (int i = 0; i < n; i++) {
                System.out.print("Enter stock name: ");
                String name = scanner.next();

                System.out.print("Enter number of shares: ");
                int numShares = scanner.nextInt();

                System.out.print("Enter share price: ");
                double sharePrice = scanner.nextDouble();

                Stock stock = new Stock(name, numShares, sharePrice);
                portfolio.addStock(stock);
            }

            portfolio.generateReport();
        }
    }


