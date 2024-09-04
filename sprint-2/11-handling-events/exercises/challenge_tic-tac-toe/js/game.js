// players player 1,2
const player1 = {
    name: 'Player One',
    value: 'X'
}
const player2 = {
    name: 'Player Two',
    value: 'O'
}

// current
let currentPlayer = player1;


function setNextPlayer()
{
    switch (currentPlayer)
    {
        case player1:
            currentPlayer = player2;
            break;
        case player2:
            currentPlayer = player1;
            break;
    }
    displayCurrentPlayer();
}

function displayCurrentPlayer()
{
    const display = document.getElementById('playerName');
    display.textContent = `${currentPlayer.name}`;
}

function playerTurn(event)
{
    event.target.textContent = currentPlayer.value;
    setNextPlayer();
}

function reset()
{
    const game = document.getElementsByClassName('game-button');
    const buttons = Array.from(game);

    buttons.forEach(button => button.textContent = '');
    // event.target.textContent = '';
    currentPlayer = player1;
    displayCurrentPlayer();
}

// main
document.addEventListener('DOMContentLoaded', () =>
{
    displayCurrentPlayer();

    const game = document.getElementsByClassName('game-button');
    const buttons = Array.from(game);
    buttons.forEach(button => {button.addEventListener('click', playerTurn) });

    const resetButton = document.getElementById('resetButton');
    resetButton.addEventListener('click', reset);
})
