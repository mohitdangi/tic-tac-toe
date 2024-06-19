package org.example;

public class Game {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;
    private GameStatus status;

    public Game(Player player1, Player player2) {
        board = new Board();
        players = new Player[]{player1, player2};
        currentPlayerIndex = 0;
        status = GameStatus.IN_PROGRESS;
    }

    public void play() {
        while (status == GameStatus.IN_PROGRESS) {
            board.printBoard();
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println("Player " + currentPlayer.getSymbol() + "'s turn");
            Move move = currentPlayer.makeMove();
            if (board.isValidMove(move)) {
                board.applyMove(move, currentPlayer.getSymbol());
                status = board.checkStatus();
                currentPlayerIndex = (currentPlayerIndex + 1) % 2;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        board.printBoard();
        if (status == GameStatus.DRAW) {
            System.out.println("The game is a draw.");
        } else {
            System.out.println("Player " + players[(currentPlayerIndex + 1) % 2].getSymbol() + " wins!");
        }
    }
}

