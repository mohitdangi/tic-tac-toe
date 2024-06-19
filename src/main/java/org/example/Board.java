package org.example;

public class Board {
    private char[][] board;
    private static final int SIZE = 3;

    public Board() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    public boolean isValidMove(Move move) {
        int row = move.getRow();
        int col = move.getCol();
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-';
    }

    public void applyMove(Move move, char symbol) {
        board[move.getRow()][move.getCol()] = symbol;
    }

    public GameStatus checkStatus() {
        // Check rows
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return GameStatus.WIN;
            }
        }
        // Check columns
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return GameStatus.WIN;
            }
        }
        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return GameStatus.WIN;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return GameStatus.WIN;
        }
        // Check for draw
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    return GameStatus.IN_PROGRESS;
                }
            }
        }
        return GameStatus.DRAW;
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

