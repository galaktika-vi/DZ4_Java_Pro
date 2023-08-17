import java.util.Random;
import java.util.Scanner;

public class Deal {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.runGame();
    }
}

class GameManager {
    private static final int CARDS_FOR_PLAYER = 5;

    private final Scanner scanner;
    private final Random random;

    public GameManager() {
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public void runGame() {
        int players = getNumberOfPlayers();
        if (players <= 0) {
            System.out.println("The game has been terminated.");
            return;
        }

        Deck deck = new Deck();
        deck.shuffle();

        dealCards(deck, players);
    }

    private int getNumberOfPlayers() {
        while (true) {
            System.out.println("Enter the number of players: ");

            if (scanner.hasNextInt()) {
                int players = scanner.nextInt();
                if (players >= 0) {
                    return players;
                } else {
                    System.out.println("The number of players cannot be less than 0");
                }
            } else {
                System.out.println("You have not entered a valid number!");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private void dealCards(Deck deck, int players) {
        for (int i = 0; i < players * CARDS_FOR_PLAYER; i++) {
            System.out.println(deck.drawCard());

            if (i % CARDS_FOR_PLAYER == CARDS_FOR_PLAYER - 1) {
                System.out.println();
            }
        }
    }
}

class Deck {
    private static final String[] SUITS = {"clubs", "diamonds", "hearts", "spades"};
    private static final String[] RANK = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    private final String[] deck;
    private int currentIndex;

    public Deck() {
        deck = new String[SUITS.length * RANK.length];
        currentIndex = 0;

        initializeDeck();
    }

    private void initializeDeck() {
        for (int i = 0; i < RANK.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length * i + j] = RANK[i] + " " + SUITS[j];
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int card = i + random.nextInt(deck.length - i);
            String temp = deck[card];
            deck[card] = deck[i];
            deck[i] = temp;
        }
    }

    public String drawCard() {
        if (currentIndex < deck.length) {
            return deck[currentIndex++];
        } else {
            return "No more cards in the deck.";
        }
    }
}
