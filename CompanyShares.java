package com.bridgelab.oops;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



    class Companyshares {
        private String stockSymbol;
        private int numberOfShares;
        private Date dateTime;

        public Companyshares(String stockSymbol, int numberOfShares, Date dateTime) {
            this.stockSymbol = stockSymbol;
            this.numberOfShares = numberOfShares;
            this.dateTime = dateTime;
        }

        public String getStockSymbol() {
            return stockSymbol;
        }

        public int getNumberOfShares() {
            return numberOfShares;
        }

        public Date getDateTime() {
            return dateTime;
        }
    }

    class StockAccount {
        private List<Companyshares> companySharesList;

        public StockAccount() {
            this.companySharesList = new ArrayList<>();
        }

        public void buy(String stockSymbol, int numberOfShares) {
            // Assuming you have a method to check if the stock is available or not
            // and to get the current date and time
            if (isStockAvailable(stockSymbol, numberOfShares)) {
                Companyshares shares = new Companyshares(stockSymbol, numberOfShares, getCurrentDateTime());
                companySharesList.add(shares);
                System.out.println(numberOfShares + " shares of " + stockSymbol + " bought successfully.");
            } else {
                System.out.println("Not enough shares of " + stockSymbol + " available for purchase.");
            }
        }

        public void sell(String stockSymbol, int numberOfShares) {
            // Assuming you have a method to check if the user has enough shares to sell
            // and to get the current date and time
            if (isSufficientShares(stockSymbol, numberOfShares)) {
                Companyshares shares = new Companyshares(stockSymbol, -numberOfShares, getCurrentDateTime());
                companySharesList.add(shares);
                System.out.println(numberOfShares + " shares of " + stockSymbol + " sold successfully.");
            } else {
                System.out.println("Not enough shares of " + stockSymbol + " to sell.");
            }
        }

        private boolean isStockAvailable(String stockSymbol, int numberOfShares) {
            // Implement logic to check if the stock is available for purchase
            // For example, you may check with an external data source or database
            return true;
        }

        private boolean isSufficientShares(String stockSymbol, int numberOfShares) {
            // Implement logic to check if the user has enough shares to sell
            // For example, you may check the existing shares in the companySharesList
            return true;
        }

        private Date getCurrentDateTime() {
            // Implement logic to get the current date and time
            return new Date();
        }

        public void displayCompanyShares() {
            System.out.println("Company Shares:");
            System.out.printf("%-15s %-15s %-15s\n", "Stock Symbol", "Num of Shares", "DateTime");
            for (Companyshares shares : companySharesList) {
                System.out.printf("%-15s %-15d %-15s\n", shares.getStockSymbol(), shares.getNumberOfShares(), shares.getDateTime());
            }
        }
    }

public class CompanyShares {
        public static void main(String[] args) {
            StockAccount stockAccount = new StockAccount();

            stockAccount.buy("AAPL", 10);
            stockAccount.buy("GOOGL", 5);

            stockAccount.displayCompanyShares();

            stockAccount.sell("AAPL", 8);
            stockAccount.sell("GOOGL", 3);

            stockAccount.displayCompanyShares();
        }
    }


