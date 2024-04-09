package com.example.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {
    @Test
    void X_plays_first() {
        var game = new TicTacToe();

        assertEquals(GameState.X_PLAYS, game.state());
    }

    // O_plays_after_X
    // players_alternate
    // cannot_play_occupied_position
    // cannot_play_twice
    // X_wins
    // O_wins
    // tie
}
