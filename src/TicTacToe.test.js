import { render, screen, act } from '@testing-library/react';
import userEvent from '@testing-library/user-event';

import TicTacToe from './TicTacToe';

beforeEach(() => {
  render(<TicTacToe />);
});

/*
  This test will only pass when (hopefuly) all the game is implemented.
  That's why it is disabled.
  Enable it once in a while to check progress.
  What other tests can we write that will allow us to drive the solution?
*/
xtest('X wins', () => {
  playing([
    { x: 'NORTH_WEST' }, { o: 'WEST'   },
    { x: 'NORTH'      }, { o: 'CENTER' },
    { x: 'NORTH_EAST' }
  ]);

  expectStatus("X wins!");
});

test('X plays first', () => {
  expectStatus("X plays!");
});

test('O plays after X', () => {
  act(() =>
    playing([
      { x: 'NORTH_WEST' }
    ])
  );

  expectStatus("O plays!");
});

function playing(moves) {
  moves.forEach(e => {
    userEvent.click(screen.getByTestId(e.x || e.o));
  });
}

function expectStatus(s) {
  expect(screen.getByTestId('game-status')).toHaveTextContent(s);
}