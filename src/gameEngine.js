const gameEngine = {
    nextPlayer: (player) => {
        if (player === 'X') return 'O';
        else return 'X';
    },
    cells: [
        { id: 'NORTH_WEST' }, { id: 'NORTH'  }, { id: 'NORTH_EAST' },
        { id: 'WEST'       }, { id: 'CENTER' }, { id: 'EAST'       },
        { id: 'SOUTH_WEST' }, { id: 'SOUTH'  }, { id: 'SOUTH_EAST' }
    ]
}

export {
    gameEngine
}