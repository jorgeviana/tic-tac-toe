package com.example.tictactoe;

import java.util.HashSet;
import java.util.Set;

import static com.example.tictactoe.Player.*;

public class TicTacToe {
    private Player currentPlayer;
    private Set<Position> playedPositions = new HashSet<>();

    public GameState state() {
        if (currentPlayer == null) return GameState.X_PLAYS;
        if (currentPlayer == O) return GameState.X_PLAYS;
        return GameState.O_PLAYS;
    }

    public void play(Player player, Position position) {
        if (playedPositions.contains(position)) return;
        currentPlayer = player;
        playedPositions.add(position);
    }
}
