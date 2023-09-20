package com.commandtm.sokobanbore;

import java.util.Arrays;

public class board {
    int[][] board = new int[10][10];
    public void boardMake(){
        for (int[] ints : board) {
            Arrays.fill(ints, 0);
        }
        for (int k = 0; k < 10; k++){
            board[k][0]=1;
            board[0][k]=1;
            board[9][k]=1;
            board[k][9]=1;
        }
        board[1][1]=2;
    }
}
