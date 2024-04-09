package com.example.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {
    @Test
    void X_plays_first() {
        var game = new TicTacToe();

        assertEquals(GameState.X_PLAYS, game.state());
    }

    @Test
    void O_plays_after_X() {
        var game = new TicTacToe();

        game.play(Player.X, Position.UP_LEFT);

        assertEquals(GameState.O_PLAYS, game.state());
    }
    // players_alternate
    // cannot_play_occupied_position
    // cannot_play_twice
    // X_wins
    // O_wins
    // tie
}
