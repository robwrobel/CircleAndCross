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
enum Tag{
    EMPTY,O,X
}
class Board {
    private final Tag[][] board;
    private static final int COLS=3;
    private static final int ROWS=3;
    
    Board() {
        board = new Tag[ROWS][COLS];
        initialize();
    }
    

    private void initialize() {
        for (int i=0;i<ROWS;i++) {
            for (int j=0;j<COLS;j++) {
                board[i][j]=Tag.EMPTY;
            }
        }
    }
}
