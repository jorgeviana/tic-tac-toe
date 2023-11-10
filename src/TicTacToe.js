import './TicTacToe.css'

function TicTacToe() {
  return (
    <>
      <h1 className="centered">Tic Tac Toe</h1>
      <div id="tic-tac-toe-board">
        <div className="cell"></div>
        <div className="cell"></div>
        <div className="cell"></div>
        <div className="cell"></div>
        <div className="cell"></div>
        <div className="cell"></div>
        <div className="cell"></div>
        <div className="cell"></div>
        <div className="cell"></div>
      </div>
      <h3 data-testid="game-status" className="centered">X plays!</h3>
    </>
  );
}

export default TicTacToe;
