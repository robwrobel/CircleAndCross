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
    EMPTY(" "),O("O"),X("X");
    private final String name;
    private Tag(String name) {
        this.name=name;
    }
    @Override
    public String toString() {
        return name;
    }
}
class Board {
    private final Tag[][] board;
    public static final int COLS=3;
    public static final int ROWS=3;
    
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
    
    @Override
    public String toString() {
        return "Row\\Col 1 2 3\n" +
               "1       "+board[0][0]+" "+board[0][1]+" "+board[0][2]+"\n" +
               "2       "+board[1][0]+" "+board[1][1]+" "+board[1][2]+"\n" +
               "3       "+board[2][0]+" "+board[2][1]+" "+board[2][2]+"\n";
    }

    boolean setTag(int row, int col,Tag tag) {
        if (board[row-1][col-1]== Tag.EMPTY) {
            board[row-1][col-1]=tag;
            return true;
        } else {
            return false;
        }
    }

    boolean checkIfWin(Tag tag) {
        return checkRowCondition(tag)||
               checkColumnCondition(tag)||
               checkDiagonalCondition(tag);
    }

    private boolean checkRowCondition(Tag tag) {
        for (int i=0;i<ROWS;i++) {
            if ((board[i][0]==tag)&&(board[i][1]==tag)&&(board[i][2]==tag))
                return true;
        }
        return false;
    }

    private boolean checkColumnCondition(Tag tag) {
        for (int i=0;i<COLS;i++) {
            if ((board[0][i]==tag)&&(board[1][i]==tag)&&(board[2][i]==tag))
                return true;
        }
        return false;
    }

    private boolean checkDiagonalCondition(Tag tag) {
        return ((board[0][0]==tag)&&(board[1][1]==tag)&&(board[2][2]==tag))||
                ((board[0][2]==tag)&&(board[1][1]==tag)&&(board[2][0]==tag));        
    }

    boolean checkIfFull() {
       for (int i=0;i<ROWS;i++) { 
           for (int j=0;j<COLS;j++) {
               if (board[i][j]==Tag.EMPTY)
                   return false;
           }
       }
       return true;
    }
}
