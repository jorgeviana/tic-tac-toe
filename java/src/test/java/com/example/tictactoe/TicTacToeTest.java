package com.example.tictactoe;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void cannot_play_twice() {
        game.play(X, UP_LEFT);
        game.play(X, UP);

        assertEquals(O_PLAYS, game.state());
        assertMovesExactly(new Move(X, UP_LEFT));
    }

    @Test
    void O_cannot_play_twice() {
        game.play(X, UP_LEFT);
        game.play(O, UP);

        game.play(O, UP_RIGHT);

        assertEquals(X_PLAYS, game.state());
        assertMovesExactly(
            new Move(X, UP_LEFT),
            new Move(O, UP)
        );
    }

    @Test
    void X_wins() {
        game.play(X,UP_LEFT);
        game.play(O,LEFT);
        game.play(X,UP);
        game.play(O,CENTER);
        game.play(X,UP_RIGHT);

        assertEquals(GameState.X_WINS, game.state());
    }

    @Test
    void X_wins_other_combination() {
        game.play(X,DOWN_LEFT);
        game.play(O,LEFT);
        game.play(X,DOWN);
        game.play(O,CENTER);
        game.play(X,DOWN_RIGHT);

        assertEquals(GameState.X_WINS, game.state());
    }

    // O_wins
    // tie

    private void assertMovesExactly(Move... moves) {
        var expectedMoves = List.of(
            moves
        );
        var actualMoves = game.moves();
        assertEquals(expectedMoves, actualMoves);
    }
}
