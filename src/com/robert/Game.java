/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robert;

/**
 *
 * @author Robert
 */
class Game {
    private boolean isNextGame;
    private boolean isFirstGame=true;
    private Board board;
    private Player player1,player2;
    private Player currentPlayer;
    private final Screen screen;
    public Game() {
        screen = new Screen();
    }
    void start() {
        do
        {
            initialize();
            startNewGame();
            isNextGame=isNextGame();
            isFirstGame=false;
        } while (isNextGame);
    }

    private void startNewGame() {
        boolean isWin=false;
        boolean isBoardFull=false;
        do {
            displayBoard();
            askPlayerForMove();
            isWin = checkIfWin();
            isBoardFull=checkIfBoardFull();
            if (isWin || isBoardFull) break;
            switchPlayer();
        } while (true);
        if (isWin) {
            congratulatePlayer();
        } else if (isBoardFull) {
            weHaveADraw();
        }
            
    }

    private void initialize() {
        initializePlayers();
        initializeBoard();
    }
    
    private void initializePlayers() {
        if (isFirstGame) {
            initializeNewPlayers();
        } else {
            screen.print("Start game with new players?(y/n)");
            if (screen.isYes()) {
                initializeNewPlayers();
            }
        }
    }
    private void initializeNewPlayers() {
        player1=new Player();
        player2=new Player();
        screen.print("Enter 1st player name:");
        String player1Name=screen.getString();
        screen.print("Enter 2nd player name:");
        String player2Name=screen.getString();
        player1.setName(player1Name);
        player2.setName(player2Name);
        player1.setTag(Tag.O);
        player2.setTag(Tag.X);
        currentPlayer=player1;
    }

    private void initializeBoard() {
        board = new Board();
    }

    private boolean isNextGame() {
        screen.print("Play another game?(y/n)");
        return screen.isYes();
    }

    private void displayBoard() {
        screen.print(board.toString());
    }

    private void askPlayerForMove() {
        boolean isSetValid;
        do {
            screen.print("Player:"+currentPlayer+". Please choose row position:");
            int row=screen.getIntFromRange(1,Board.ROWS);
            screen.print("Please choose column position:");
            int col=screen.getIntFromRange(1,Board.COLS);
            isSetValid=board.setTag(row,col,currentPlayer.getTag());
            if (!isSetValid)
                screen.print("This position is taken please choose another");
            else break;
        } while (true);
    }

    private boolean isGameOver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean checkIfWin() {
        return board.checkIfWin(currentPlayer.getTag());
    }

    private void switchPlayer() {
        if (currentPlayer==player1) {
            currentPlayer=player2;
        } else {
            currentPlayer=player1;
        }
    }

    private boolean checkIfBoardFull() {
        return board.checkIfFull();
    }

    private void congratulatePlayer() {
        screen.print("Player:"+currentPlayer+" is a WINNER. Congratulation!!!"); //To change body of generated methods, choose Tools | Templates.
    }

    private void weHaveADraw() {
        screen.print("There is no winner.We have a draw");
    }
    
}
