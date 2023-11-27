import './TicTacToe.css'

import { useState } from 'react'

import { gameEngine } from './gameEngine'

function TicTacToe() {
  const [player, setPlayer] = useState('X')

  const handleClick = () => {
    setPlayer(gameEngine.nextPlayer(player));
  }

  return (
    <>
      <h1 className="centered">Tic Tac Toe</h1>
      <div id="tic-tac-toe-board">
        { 
          gameEngine.cells.map(
            (cell) => <div key={cell.id} data-testid={cell.id} onClick={handleClick} className="cell"></div>
          )
        }
      </div>
      <h3 data-testid="game-status" className="centered">{player} plays!</h3>
    </>
  );
}

export default TicTacToe;
