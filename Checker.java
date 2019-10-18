import java.util.Scanner;

public class Checker {

  public static int boundCheck(int pos, String rowOrCol, String startOrEnd) {
    if (pos>8 || pos<1) {
      int newPos=-1;
      do {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nValue must be between 1 and 8.");
        if (startOrEnd.toLowerCase().substring(0,startOrEnd.length()).equals("start")) { //start
          if (rowOrCol.equals("row")) { //row
            System.out.print("Which row would you like your ship to start in?\n> ");
            newPos = scan.nextInt();
          } else if (rowOrCol.equals("col")) { //column
            System.out.print("Which column would you like your ship to start in?\n> ");
            newPos = scan.nextInt();
          }
        } else if (startOrEnd.toLowerCase().substring(0,startOrEnd.length()).equals("end")) { //end
            if (rowOrCol.equals("row")) { //row
              System.out.print("Which row would you like your ship to end in?\n> ");
              newPos = scan.nextInt();
            } else if (rowOrCol.equals("col")) { //column
              System.out.print("Which column would you like your ship to end in?\n> ");
              newPos = scan.nextInt();
            }
        }
      } while (newPos>8 || newPos<1);
        return newPos;
    } else {
      return pos;
    }
  } //close boundCheck()

  public static boolean alreadyShipThereCheck(int row, int col, int shipLen, int[][] board) {
    boolean result = false;
    if (shipLen==0) {
      if (board[row][col]==1) {
        System.out.println("There is already a ship there!");
        Turn.honkshoe(3000);
        result=true;
      } else {
        result=false;
      }
    } else {
      result=true;
    }
    return result;
  } //close alreadyShipThereCheck()

  public static boolean alreadyShipThereCheck(int row, int col, int shipLen, int[][] board, String orient, int magnitude) {
    boolean result = false;
      if ((result!=true) && (orient.equals("h"))) {
        for (int i=0; i<shipLen; i++) {
          if (board[row][col+(i*magnitude)]==1) {
            System.out.println("There is already a ship there!");
            Turn.honkshoe(3000);
            result=true;
          } else {
            result=false;
          }
        }
      } else if ((result!=true) && (orient.equals("h"))) {
        for (int i=0; i<shipLen; i++) {
          if (board[row+(i*magnitude)][col]==1) {
            System.out.println("There is already a ship there!");
            Turn.honkshoe(3000);
            result=true;
          } else {
            result=false;
          }
        }
      } else {
        result=true;
      }
    return result;
  } //close alreadyShipThereCheck()

  public static boolean lengthCheck(int startingRow, int endingRow, int startingCol, int endingCol, int shipLen) {
    String orient = orientCheck(startingRow, endingRow, startingCol, endingCol);
    int magnitude = magnitude(startingRow, endingRow, startingCol, endingCol);
    int attemptedShipLength;
    if ((startingRow!=endingRow) && (startingCol!=endingCol)) {
      System.out.println("Ship cannot be diagonal!");
      System.out.println("Attempted ship length: " + ((endingRow-startingRow) + (endingCol-startingCol)) + ", actual ship length: " + shipLen + "\n");
      Turn.honkshoe(3000);
      return true;
    } else if (orient.equals("v")) {
      attemptedShipLength = (endingRow>startingRow) ? ((endingRow-startingRow)+1) : ((startingRow-endingRow)+1);
      if (attemptedShipLength==shipLen) {
        return false;
      } else if (attemptedShipLength>shipLen) {
        System.out.println("Ship is too long!");
        System.out.println("Attempted ship length: " + attemptedShipLength + ", actual ship length: " + shipLen + "\n");
        Turn.honkshoe(3000);
        return true;
      } else if (attemptedShipLength<shipLen) {
        // attemptedShipLength = (endingRow>startingRow) ? ((endingRow-startingRow)+1) : ((startingRow-endingRow)+1);
        System.out.println("Ship is too short!");
        System.out.println("Attempted ship length: " + attemptedShipLength + ", actual ship length: " + shipLen + "\n");
        Turn.honkshoe(3000);
        return true;
      } else {
        // attemptedShipLength = (endingRow>startingRow) ? ((endingRow-startingRow)+1) : ((startingRow-endingRow)+1);
        System.out.println("Invalid ship dimensions.");
        System.out.println("Attempted ship length: " + attemptedShipLength + ", actual ship length: " + shipLen + "\n");
        Turn.honkshoe(3000);
        return true;
      }
    } else if (orient.equals("h")) {
      attemptedShipLength = (endingCol>startingCol) ? ((endingCol-startingCol)+1) : ((startingCol-endingCol)+1);
      if (attemptedShipLength==shipLen) {
        return false;
      } else if (attemptedShipLength>shipLen) {
        System.out.println("Ship is too long!");
        System.out.println("Attempted ship length: " + attemptedShipLength + ", actual ship length: " + shipLen + "\n");
        Turn.honkshoe(3000);
        return true;
      } else if (attemptedShipLength<shipLen) {
        System.out.println("Ship is too short!");
        System.out.println("Attempted ship length: " + attemptedShipLength + ", actual ship length: " + shipLen + "\n");
        Turn.honkshoe(3000);
        return true;
      } else {
        System.out.println("Invalid ship dimensions.");
        System.out.println("Attempted ship length: " + attemptedShipLength + ", actual ship length: " + shipLen + "\n");
        Turn.honkshoe(3000);
        return true;
      }
    } else {
      System.out.println("\nInvalid ship dimensions.");
      System.out.println("Attempted ship length: " + (((endingRow-startingRow)+magnitude) + ((endingCol-startingCol)+magnitude)) + ", actual ship length: " + shipLen + "\n");
      Turn.honkshoe(3000);
      return true;
    }
  } //close boundCheck()

  public static String orientCheck(int rowStart, int rowEnd, int colStart, int colEnd) {
    if ((rowStart==rowEnd) && !(colStart==colEnd)) {
      return "h";
    } else if ((colStart==colEnd) && !(rowStart==rowEnd)) {
      return "v";
    } else {
      return "n";
    }
  }

  public static int magnitude(int startingRow, int endingRow, int startingCol, int endingCol) {
    String orient = orientCheck(startingRow, endingRow, startingCol, endingCol);
    if (orient.equals("h")) {
      if (startingCol<endingCol) {
        return 1;
      } else if (endingCol<startingCol) {
        return -1;
      } else {
        return 1;
      }
    } else if (orient.equals("v")) {
      if (startingRow<endingRow) {
        return 1;
      } else if (endingRow<startingRow) {
        return -1;
      } else {
        return 1;
      }
    } else {
      return 1;
    }
  }

} //close Checker class
