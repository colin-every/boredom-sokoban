package com.commandtm.sokobanbore;

public class Input{
    int playerX;
    int playerY;
    int playerSpace;
    int north;
    int south;
    int east;
    int west;
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
        north = board.getBoard(playerY+1,playerX);
        south = board.getBoard(playerY-1,playerX);
        east = board.getBoard(playerY,playerX+1);
        west = board.getBoard(playerY,playerX-1);

        if (dir == 'x'){
            if (way == -1){
                if (west == 0 || west == 4){
                    board.setBoard(playerY,playerX,playerSpace);
                    board.setBoard(playerY,playerX-1,2);
                    playerSpace = west;
                } else if (west == 3 || west == 5){
                    if (board.getBoard(playerY,playerX-2) == 0){
                        board.setBoard(playerY,playerX,playerSpace);
                        board.setBoard(playerY,playerX-1,2);
                        board.setBoard(playerY,playerX-2,3);
                        playerSpace = (west == 5) ? 4 : 0;
                    } else if (board.getBoard(playerY,playerX-2) == 4){
                        board.setBoard(playerY,playerX,playerSpace);
                        board.setBoard(playerY,playerX-1,2);
                        board.setBoard(playerY,playerX-2,5);
                        playerSpace = 0;
                        board.checkBoard();
                    }
                }
            } else {
                if (east == 0 || east == 4){
                    board.setBoard(playerY,playerX,playerSpace);
                    board.setBoard(playerY,playerX+1,2);
                    playerSpace = east;
                } else if (east == 3 || east == 5){
                    if (board.getBoard(playerY,playerX+2) == 0){
                        board.setBoard(playerY,playerX,playerSpace);
                        board.setBoard(playerY,playerX+1,2);
                        board.setBoard(playerY,playerX+2,3);
                        playerSpace = (east == 5) ? 4 : 0;
                    } else if (board.getBoard(playerY,playerX+2) == 4){
                        board.setBoard(playerY,playerX,playerSpace);
                        board.setBoard(playerY,playerX+1,2);
                        board.setBoard(playerY,playerX+2,5);
                        playerSpace = 0;
                        board.checkBoard();
                    }
                }
            }
        } else {
            if (way == -1){
                if (south == 0 || south == 4){
                    board.setBoard(playerY,playerX,playerSpace);
                    board.setBoard(playerY-1,playerX,2);
                    playerSpace = south;
                } else if (south == 3 || south == 5){
                    if (board.getBoard(playerY-2,playerX) == 0){
                        board.setBoard(playerY,playerX,playerSpace);
                        board.setBoard(playerY-1,playerX,2);
                        board.setBoard(playerY-2,playerX,3);
                        playerSpace = (south == 5) ? 4 : 0;
                    } else if (board.getBoard(playerY-2,playerX) == 4){
                        board.setBoard(playerY,playerX,playerSpace);
                        board.setBoard(playerY-1,playerX,2);
                        board.setBoard(playerY-2,playerX,5);
                        playerSpace = 0;
                        board.checkBoard();
                    }
                }
            } else {
                if (north == 0 || north == 4){
                    board.setBoard(playerY,playerX,playerSpace);
                    board.setBoard(playerY+1,playerX,2);
                    playerSpace = north;
                } else if (north == 3 || north == 5){
                    if (board.getBoard(playerY+2,playerX) == 0){
                        board.setBoard(playerY,playerX,playerSpace);
                        board.setBoard(playerY+1,playerX,2);
                        board.setBoard(playerY+2,playerX,3);
                        playerSpace = (north == 5) ? 4 : 0;
                    } else if (board.getBoard(playerY+2,playerX) == 4){
                        board.setBoard(playerY,playerX,playerSpace);
                        board.setBoard(playerY+1,playerX,2);
                        board.setBoard(playerY+2,playerX,5);
                        playerSpace = 0;
                        board.checkBoard();
                    }
                }
            }
        }
    }
}
