package org.example;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(char symbol) {
        super(symbol);
        scanner = new Scanner(System.in);
    }

    @Override
    public Move makeMove() {
        System.out.println("Enter your move (row and column): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new Move(row, col);
    }
}
