package com.example.tictactoe;

import java.util.Objects;

public class Move {
    private final Player player;
    private final Position position;

    public Move(Player player, Position position) {
        this.player = player;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Move move)) return false;
        return player == move.player && position == move.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, position);
    }

    @Override
    public String toString() {
        return "Move{" +
            "player=" + player +
            ", position=" + position +
            '}';
    }

    public Player getPlayer() {
        return player;
    }

    public Position getPosition() {
        return position;
    }
}
