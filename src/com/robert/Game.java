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
    private boolean anotherGame;
    private boolean isFirstGame=true;
    private Board board;
    private Player player1,player2;
    private final Screen screen;
    public Game() {
        screen = new Screen();
    }
    void start() {
        do
        {
            initialize();
            anotherGame=startNewGame();
            isFirstGame=false;
        } while (anotherGame);
    }

    private boolean startNewGame() {
        
    }

    private void initialize() {
        initializePlayers();
        initializeBoard();
    }
    
    private void initializePlayers() {
        if (isFirstGame) {
            initializeNewPlayers();
        } else {
            screen.print("Start game with new players?(y/n)\n");
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
    }

    private void initializeBoard() {
        board = new Board();
    }
    
}
