export {
    gameEngine
}

const gameEngine = {
    nextPlayer: (player) => {
        if (player === 'X') return 'O';
        else return 'X';
    }
}