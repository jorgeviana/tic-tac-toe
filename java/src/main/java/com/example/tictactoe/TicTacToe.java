package com.example.tictactoe;

import static com.example.tictactoe.Player.*;

public class TicTacToe {
    private Player currentPlayer;
    private Position playedPosition;

    public GameState state() {
        if (currentPlayer == null) return GameState.X_PLAYS;
        if (currentPlayer == O) return GameState.X_PLAYS;
        return GameState.O_PLAYS;
    }

    public void play(Player player, Position position) {
        if (playedPosition == position) return;
        currentPlayer = player;
        playedPosition = position;
    }
}
