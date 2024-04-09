package com.example.tictactoe;

import org.junit.jupiter.api.Test;

import static com.example.tictactoe.GameState.*;
import static com.example.tictactoe.Player.*;
import static com.example.tictactoe.Position.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {

    TicTacToe game = new TicTacToe();

    @Test
    void X_plays_first() {
        assertEquals(X_PLAYS, game.state());
    }

    @Test
    void O_plays_after_X() {
        game.play(X, UP_LEFT);

        assertEquals(O_PLAYS, game.state());
    }

    @Test
    void players_alternate() {
        game.play(X, UP_LEFT);

        game.play(O, UP);

        assertEquals(X_PLAYS, game.state());
    }


    @Test
    void cannot_play_occupied_position() {
        game.play(X, UP_LEFT);

        game.play(O, UP_LEFT);

        assertEquals(O_PLAYS, game.state());
    }

    @Test
    void X_cannot_play_occupied_position() {
        game.play(X, UP_LEFT);
        game.play(O, UP);

        game.play(X, UP_LEFT);

        assertEquals(X_PLAYS, game.state());
    }
    // cannot_play_twice
    // X_wins
    // O_wins
    // tie
}
