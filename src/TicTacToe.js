import './TicTacToe.css'

import { useState } from 'react'

function TicTacToe() {
  const [player, setPlayer] = useState('X')

  const handleClick = () => {
    if (player === 'X') setPlayer('O');
    else setPlayer('X');
  }

  return (
    <>
      <h1 className="centered">Tic Tac Toe</h1>
      <div id="tic-tac-toe-board">
        <div data-testid="NORTH_WEST" onClick={handleClick} className="cell"></div>
        <div className="cell"></div>
        <div className="cell"></div>
        <div data-testid="WEST" onClick={handleClick} className="cell"></div>
        <div className="cell"></div>
        <div className="cell"></div>
        <div className="cell"></div>
        <div className="cell"></div>
        <div className="cell"></div>
      </div>
      <h3 data-testid="game-status" className="centered">{player} plays!</h3>
    </>
  );
}

export default TicTacToe;
