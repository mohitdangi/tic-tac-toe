package org.example;
public class Main {
    public static void main(String[] args) {
        Player player1 = new HumanPlayer('X');
        Player player2 = new HumanPlayer('O');
        Game game = new Game(player1, player2);
        game.play();
    }
}
