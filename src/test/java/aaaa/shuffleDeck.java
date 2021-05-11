package aaaa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class shuffleDeck {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the number of players?");
        int numOfPlayers = scanner.nextInt();
        int rotate = 52 / numOfPlayers;
        List<String> cards = new ArrayList<>();
        String hearths = "H";
        String diamonds = "D";
        String clubs = "C";
        String spades = "S";
        for (int i = 1; i <= 13; i++) {
            cards.add(i + hearths);
            cards.add(i + diamonds);
            cards.add(i + clubs);
            cards.add(i + spades);
        }
        int count = 0;
        for (int b = 1; b <= numOfPlayers; b++) {
            System.out.println("Player " + b + " has");
            for (int j = 1; j <= rotate; j++) {
                int index = rand.nextInt(52 - count);
                System.out.print(cards.get(index) + " ");
                cards.remove(index);
                count++;
            }
            System.out.println();
        }
    }
}
