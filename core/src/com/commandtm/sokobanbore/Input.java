package com.commandtm.sokobanbore;

public class Input{
    int playerX;
    int playerY;
    board board = new board();
    public void inputGetter(char dir, int way){
        for (int k = 0; k<board.board.length; k++){
            for (int i = 0; i<board.board[k].length; i++){
                if (board.getBoard(k,i) == 2){
                    playerX = i;
                    playerY = k;
                }
            }
        }

        if (dir == 'x'){
            if (way == -1){
                if (board.getBoard(playerY,playerX-1) == 0){
                    board.setBoard(playerY,playerX,0);
                    board.setBoard(playerY,playerX-1,2);
                }
            } else {
                if (board.getBoard(playerY,playerX+1) == 0){
                    board.setBoard(playerY,playerX,0);
                    board.setBoard(playerY,playerX+1,2);
                }
            }
        } else {
            if (way == -1){
                if (board.getBoard(playerY-1,playerX) == 0){
                    board.setBoard(playerY,playerX,0);
                    board.setBoard(playerY-1,playerX,2);
                }
            } else {
                if (board.getBoard(playerY+1,playerX) == 0){
                    board.setBoard(playerY,playerX,0);
                    board.setBoard(playerY+1,playerX,2);
                }
            }
        }
    }
}
