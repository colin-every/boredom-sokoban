import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner console = new Scanner(System.in);
    static int[][] board = new int[21][21];
    static int x;
    static int y;
    static int id;
    static File level;

    public static void main(String[] args) {
        for (int k = 0; k < board.length; k++){
            Arrays.fill(board[k], 1);
        }
        System.out.println("Boredom Editor 1.0");
        System.out.println(" ");
        System.out.println("Commands");
        System.out.println(" ");
        System.out.println("Change Tile: \"write\"");
        System.out.println(" ");
        System.out.println("Undo: \"undo\"");
        System.out.println(" ");
        System.out.println("Open File: \"open\"");
        System.out.println(" ");
        System.out.println("Save: \"save\"");
        while(true){
            inputParser(console.nextLine());
            printBoard();
        }
    }

    public static void printBoard(){
        System.out.println(" ");
        System.out.println("    0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
        for(int k = 0;k<board.length;k++){
            if (k < 10){
                System.out.print(k + " |");
            } else {
                System.out.print(k + "|");
            }
            for (int i = 0;i<board[k].length;i++){
                if (i == 20){
                    System.out.println(" " + board[k][i] + ",");
                } else {
                    System.out.print(" " + board[k][i] + ",");
                }
            }
        }
    }

    public static void inputParser(String input){
        switch (input){
            case "open" -> {
                System.out.println(" ");
                System.out.println("File?");
                level = new File("C:\\boreSokoban\\" + console.nextLine());
                Scanner fileReader;
                try {
                    fileReader = new Scanner(level);
                } catch (FileNotFoundException e){
                    System.out.println("Couldn't find file");
                    return;
                }
                for (int k = 0;k < board.length; k++){
                    for (int i = 0;i < board[k].length; i++){
                        board[k][i] = fileReader.nextInt();
                    }
                }
            }
            case "save" -> {
                System.out.println(" ");
                System.out.println("File?");
                try {
                    FileWriter saver = new FileWriter("C:\\boreSokoban\\" + console.nextLine());
                    for (int k = 0; k < board.length; k++){
                        for (int i = 0; i < board[k].length; i++){
                            saver.write(String.valueOf(board[k][i])+"\r\n");
                        }
                    }
                    saver.close();
                    System.out.println("Saved");
                    System.exit(1);
                } catch (IOException e) {
                    System.out.println("That's not right!");
                    return;
                }
            }
            case "write" -> {
                System.out.println("X cord?");
                try {
                    x = console.nextInt();
                } catch (InputMismatchException e){
                    System.out.println("Fail");
                    return;
                }
                System.out.println("Y cord?");
                try {
                    y = console.nextInt();
                } catch (InputMismatchException e){
                    System.out.println("Fail");
                    return;
                }
            }
        }
    }
}