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
    private Set<Move> moves = new LinkedHashSet<>();

    public GameState state() {
        if (isWinner(X)) return X_WINS;
        if (isWinner(O)) return O_WINS;
        if (isTie()) return TIE;
        return nextPlayerState();
    }

    public void play(Player player, Position position) {
        if (isInvalidMove(player, position)) return;

        applyMove(player, position);
    }

    private void applyMove(Player player, Position position) {
        currentPlayer = player;
        moves.add(new Move(player, position));
    }

    private boolean isInvalidMove(Player player, Position position) {
        if (isWinner(X) || isWinner(O)) return true;
        if (currentPlayer == player) return true;
        if (isOccupiedPosition(position)) return true;
        return false;
    }

    private boolean isTie() {
        return moves.size() == 9;
    }

    private boolean isOccupiedPosition(Position position) {
        return moves.stream()
            .map(Move::getPosition)
            .anyMatch(m -> m.equals(position));
    }

    public List<Move> moves() {
        return new ArrayList<>(moves);
    }

    private GameState nextPlayerState() {
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
