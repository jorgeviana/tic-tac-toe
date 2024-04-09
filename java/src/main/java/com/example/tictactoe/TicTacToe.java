package com.example.tictactoe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static com.example.tictactoe.GameState.*;
import static com.example.tictactoe.Player.*;
import static com.example.tictactoe.Position.*;

public class TicTacToe {
    private Player currentPlayer;
    private Set<Position> playedPositions = new HashSet<>();
    private Set<Move> moves = new LinkedHashSet<>();

    public GameState state() {
        if (isWinner()) return X_WINS;
        if (currentPlayer == null) return X_PLAYS;
        if (currentPlayer == O) return X_PLAYS;
        return GameState.O_PLAYS;
    }

    private boolean isWinner() {
        return playedPositions.containsAll(List.of(UP_LEFT, UP, UP_RIGHT));
    }

    public void play(Player player, Position position) {
        if (currentPlayer == player) return;
        if (playedPositions.contains(position)) return;

        currentPlayer = player;
        playedPositions.add(position);
        moves.add(new Move(player, position));
    }

    public List<Move> moves() {
        return new ArrayList<>(moves);
    }
}
