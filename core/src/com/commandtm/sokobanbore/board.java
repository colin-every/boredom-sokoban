package com.commandtm.sokobanbore;

import java.util.Arrays;

public class board {
    static int[][] board = new int[21][21];
    public void boardMake(){
        for (int[] ints : board) {
            Arrays.fill(ints, 0);
        }
        for (int k = 0; k < board.length; k++){
            board[k][0]=1;
            board[0][k]=1;
            board[20][k]=1;
            board[k][20]=1;
        }
        board[1][1]=2;
    }

    public int getBoard(int k ,int i){
        return board[k][i];
    }

    public void setBoard(int k,int i, int input){
        board[k][i]=input;
    }
}
