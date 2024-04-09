package com.example.tictactoe;

public class TicTacToe {
    private Player currentPlayer;

    public GameState state() {
        if (currentPlayer == null) return GameState.X_PLAYS;
        return GameState.O_PLAYS;
    }

    public void play(Player player, Position position) {
        currentPlayer = player;
    }
}
