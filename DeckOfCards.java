package com.bridgelab.oops;


    import java.util.List;

class Card {
        private String suit;
        private String rank;

        public Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return rank + " of " + suit;
        }
    }

public class DeckOfCards {
        private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
        private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        public static List<Card1> initializeDeck() {
            List<Card1> deck = new java.util.ArrayList<>();

            for (String suit : SUITS) {
                for (String rank : RANKS) {
                    deck.add(new Card1(suit, rank));
                }
            }

            return deck;
        }


    }
