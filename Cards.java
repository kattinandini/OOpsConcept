package com.bridgelab.oops;
import java.util.*;



    class Card1 {
        private String suit;
        private String rank;

        public Card1(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return rank + " of " + suit;
        }

        public String getRank() {
            return rank;
        }
    }

    class DeckOfCards {
        private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
        private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        public static List<Card1> initializeDeck() {
            List<Card1> deck = new ArrayList<>();

            for (String suit : SUITS) {
                for (String rank : RANKS) {
                    deck.add(new Card1(suit, rank));
                }
            }

            return deck;
        }

        public static void shuffleDeck(List<Card1> deck) {
            Collections.shuffle(deck, new Random());
        }

        public static void distributeCards(List<Card1> deck, String[][] players) {
            int playerCount = players.length;
            int cardsPerPlayer = deck.size() / playerCount;

            for (int i = 0; i < playerCount; i++) {
                for (int j = 0; j < cardsPerPlayer; j++) {
                    players[i][j] = deck.remove(0).toString();
                }
            }
        }

        public static void printPlayerCards(String[][] players) {
            for (int i = 0; i < players.length; i++) {
                System.out.println("Player " + (i + 1) + " cards: " + Arrays.toString(players[i]));
            }
        }
    }

    class Player {
        private String name;
        private LinkedList<Card1> cards;

        public Player(String name) {
            this.name = name;
            this.cards = new LinkedList<>();
        }

        public void receiveCard(Card1 card) {
            cards.add(card);
            sortCardsByRank();
        }

        private void sortCardsByRank() {
            cards.sort(Comparator.comparing(Card1::getRank));
        }

        public String toString() {
            return name;
        }

        public String[] getCardsAsStringArray() {
            String[] cardsArray = new String[cards.size()];
            for (int i = 0; i < cards.size(); i++) {
                cardsArray[i] = cards.get(i).toString();
            }
            return cardsArray;
        }
    }

public class Cards {
        public static void main(String[] args) {
            List<Card1> deck = DeckOfCards.initializeDeck();
            DeckOfCards.shuffleDeck(deck);

            String[][] playersCards = new String[4][9];
            DeckOfCards.distributeCards(deck, playersCards);
            DeckOfCards.printPlayerCards(playersCards);

            Player player1 = new Player("Player 1");
            Player player2 = new Player("Player 2");
            Player player3 = new Player("Player 3");
            Player player4 = new Player("Player 4");

            Queue<Player> playersQueue = new LinkedList<>();
            playersQueue.offer(player1);
            playersQueue.offer(player2);
            playersQueue.offer(player3);
            playersQueue.offer(player4);

            for (int i = 0; i < playersCards.length; i++) {
                Player currentPlayer = playersQueue.poll();
                for (String cardString : playersCards[i]) {
                    Card1 card = new Card1(cardString.split(" ")[2], cardString.split(" ")[0]);
                    currentPlayer.receiveCard(card);
                }
                playersQueue.offer(currentPlayer);
            }

            for (Player player : playersQueue) {
                System.out.println(player + " cards: " + Arrays.toString(player.getCardsAsStringArray()));
            }
        }
    }


