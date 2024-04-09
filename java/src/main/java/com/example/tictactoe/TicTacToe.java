package com.example.tictactoe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.tictactoe.GameState.*;
import static com.example.tictactoe.Player.*;
import static com.example.tictactoe.Position.*;

public class TicTacToe {
    private Player currentPlayer;
    private Set<Position> playedPositions = new HashSet<>();
    private Set<Move> moves = new LinkedHashSet<>();

    public GameState state() {
        if (isWinner(X)) return X_WINS;
        if (isWinner(O)) return O_WINS;
        if (currentPlayer == null) return X_PLAYS;
        if (currentPlayer == O) return X_PLAYS;
        return GameState.O_PLAYS;
    }

    private boolean isWinner(Player player) {
        Set<Position> positions = moves.stream()
            .filter(m -> m.getPlayer() == player)
            .map(Move::getPosition)
            .collect(Collectors.toSet());

        return WINNING_COMBINATIONS.stream()
            .anyMatch(wc -> positions.containsAll(wc));
    }

    public void play(Player player, Position position) {
        if (isWinner(X) || isWinner(O)) return;
        if (currentPlayer == player) return;
        if (playedPositions.contains(position)) return;

        currentPlayer = player;
        playedPositions.add(position);
        moves.add(new Move(player, position));
    }

    public List<Move> moves() {
        return new ArrayList<>(moves);
    }

    private static final List<List<Position>> WINNING_COMBINATIONS = List.of(
        List.of(UP_LEFT, UP, UP_RIGHT),
        List.of(LEFT, CENTER, RIGHT),
        List.of(DOWN_LEFT, DOWN, DOWN_RIGHT),

        List.of(UP_LEFT, LEFT, DOWN_LEFT),
        List.of(UP, CENTER, DOWN),
        List.of(UP_RIGHT, RIGHT, DOWN_RIGHT),

        List.of(UP_LEFT, CENTER, DOWN_RIGHT),
        List.of(UP_RIGHT, CENTER, DOWN_LEFT)
    );
}
