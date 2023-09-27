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
        System.out.println("Change Tiles (Box) \"write box\"");
        System.out.println(" ");
        System.out.println("Open File: \"open\"");
        System.out.println(" ");
        System.out.println("Save: \"save\"");
        while(true){
            printBoard();
            inputParser(console.nextLine());
        }
    }

    /**
     * Prints out the current board
     */
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

    /**
     * Checks input for what action the program should take, then executes it.
     * @param input The string given to check input for
     */
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
                    System.out.println("Couldn't Find File");
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
                    System.out.println("That's Not Right!");
                    return;
                }
            }
            case "write" -> {
                System.out.println("X cord?");
                try {
                    x = Integer.parseInt(console.nextLine());
                } catch (NumberFormatException e){
                    System.out.println("Fail, Not An Integer");
                    return;
                }
                System.out.println("Y cord?");
                try {
                    y = Integer.parseInt(console.nextLine());
                } catch (NumberFormatException e){
                    System.out.println("Fail, Not An Integer");
                    return;
                }
                System.out.println("ID");
                try {
                    id = Integer.parseInt(console.nextLine());
                } catch (NumberFormatException e){
                    System.out.println("Fail, Not An Integer");
                    return;
                }
                write();
            }
            case "write box" -> {
                int x1;
                int x2;
                int y1;
                int y2;
                System.out.println("x1?");
                try {
                    x1 = Integer.parseInt(console.nextLine());
                } catch (NumberFormatException e){
                    System.out.println("Fail, Not An Integer");
                    return;
                }
                System.out.println("y1?");
                try {
                    y1 = Integer.parseInt(console.nextLine());
                } catch (NumberFormatException e){
                    System.out.println("Fail, Not An Integer");
                    return;
                }
                System.out.println("x2?");
                try {
                    x2 = Integer.parseInt(console.nextLine());
                } catch (NumberFormatException e){
                    System.out.println("Fail, Not An Integer");
                    return;
                }
                System.out.println("y2?");
                try {
                    y2 = Integer.parseInt(console.nextLine());
                } catch (NumberFormatException e){
                    System.out.println("Fail, Not An Integer");
                    return;
                }
                System.out.println("ID?");
                try {
                    id = Integer.parseInt(console.nextLine());
                } catch (NumberFormatException e){
                    System.out.println("Fail, Not An Integer");
                    return;
                }
                writeBox(x1, y1, x2, y2, id);
            }
            default -> {
                try {
                    x = Integer.parseInt(input);
                } catch (NumberFormatException e){
                    System.out.println("Fail, Not An Integer");
                    return;
                }
                try {
                    y = Integer.parseInt(console.nextLine());
                } catch (NumberFormatException e){
                    System.out.println("Fail, Not An Integer");
                    return;
                }
                try {
                    id = Integer.parseInt(console.nextLine());
                } catch (NumberFormatException e){
                    System.out.println("Fail, Not An Integer");
                    return;
                }
                write();
            }
        }
    }

    public static void write(){
        if (x == 0 || x == 20 || y == 0 || y == 20 || x < 0 || y < 0 || x > 20 || y > 20){
            System.out.println("Fail, Out Of Bounds (1-19)");
            return;
        }
        if (id < 0 || id > 5){
            System.out.println("Fail, Not A Valid ID (1-5)");
            return;
        }
        board[x][y] = id;
    }

    public static void writeBox(int x1, int y1, int x2, int y2, int ID){
        if (x1 == 0 || x1 == 20 || y1 == 0 || y1 == 20 || x1 < 0 || y1 < 0 || x1 > 20 || y1 > 20 ||
            x2 == 0 || x2 == 20 || y2 == 0 || y2 == 20 || x2 < 0 || y2 < 0 || x2 > 20 || y2 > 20){
            System.out.println("Fail, Out Of Bounds (1-19)");
            return;
        }
        if (ID < 0 || ID > 5){
            System.out.println("Fail, Not A Valid ID (1-5)");
            return;
        }
        for (int k = y1; k <= y2; k++){
            for (int i = x1; i <= x2; i++){
                board[k][i] = ID;
            }
        }
    }
}