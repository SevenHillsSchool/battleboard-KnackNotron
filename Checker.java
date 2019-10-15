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

  public static int alreadyShipThereCheck(int row, int col, String rowOrCol, String startOrEnd, int[][] board) {
    int pos = board[row][col];
    if (pos==1) {
      int newPos=-1;
      do {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nThere's already a ship there!");
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
      } while (newPos==-1);
        return newPos;
    } else {
      return pos;
    }
  }

  public static boolean lengthCheck(int startingRow, int endingRow, int startingCol, int endingCol, int shipLen) {
    String orient = orientCheck(startingRow, endingRow, startingCol, endingCol);
    int magnitude = magnitude(startingRow, endingRow, startingCol, endingCol);
    int shipLengthToCheck = (magnitude*(shipLen-1));
    if ((startingRow!=endingRow) && (startingCol!=endingCol)) {
      System.out.println("\nShip cannot be diagonal!");
      System.out.println("Attempted ship length: " + ((endingRow-startingRow) + (endingCol-startingCol)) + ", actual ship length: " + shipLengthToCheck + "\n");
      Turn.honkshoe(3000);
      return true;
    } else if (orient.equals("v")) {
      if ((endingRow-startingRow)==shipLengthToCheck) {
        return false;
      } else if ((endingRow-startingRow)>shipLengthToCheck) {
        System.out.println("Ship is too long!");
        System.out.println("\nAttempted ship length: " + ((endingRow-startingRow)+magnitude) + ", actual ship length: " + shipLengthToCheck + "\n");
        Turn.honkshoe(3000);
        return true;
      } else if ((endingRow-startingRow)<shipLengthToCheck) {
        System.out.println("Ship is too short!");
        System.out.println("\nAttempted ship length: " + ((endingRow-startingRow)+magnitude) + ", actual ship length: " + shipLengthToCheck + "\n");
        Turn.honkshoe(3000);
        return true;
      } else {
        System.out.println("Something went wrong with your ship dimensions.");
        System.out.println("\nAttempted ship length: " + ((endingRow-startingRow)+magnitude) + ", actual ship length: " + shipLengthToCheck + "\n");
        Turn.honkshoe(3000);
        return true;
      }
    } else if (orient.equals("h")) {
      if ((endingCol-startingCol)==shipLengthToCheck) {
        return false;
      } else if ((endingCol-startingCol)>shipLengthToCheck) {
        System.out.println("Ship is too long!");
        System.out.println("Attempted ship length: " + ((endingCol-startingCol)+magnitude) + ", actual ship length: " + shipLengthToCheck + "\n");
        Turn.honkshoe(3000);
        return true;
      } else if ((endingCol-startingCol)<shipLengthToCheck) {
        System.out.println("Ship is too short!");
        System.out.println("Attempted ship length: " + ((endingCol-startingCol)+magnitude) + ", actual ship length: " + shipLengthToCheck + "\n");
        Turn.honkshoe(3000);
        return true;
      } else {
        System.out.println("Something went wrong with your ship dimensions.");
        System.out.println("Attempted ship length: " + ((endingCol-startingCol)+magnitude) + ", actual ship length: " + shipLengthToCheck + "\n");
        Turn.honkshoe(3000);
        return true;
      }
    } else {
      System.out.println("\nSomething went wrong with your ship dimensions.");
      System.out.println("Attempted ship length: " + (((endingRow-startingRow)+magnitude) + ((endingCol-startingCol)+magnitude)) + ", actual ship length: " + shipLengthToCheck + "\n");
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
