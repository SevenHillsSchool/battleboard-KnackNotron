import java.util.Scanner;

public class Battleboard {
  int[] row1 = {0,0,0,0,0,0,0,0};
  int[] row2 = {0,0,0,0,0,0,0,0};
  int[] row3 = {0,0,0,0,0,0,0,0};
  int[] row4 = {0,0,0,0,0,0,0,0};
  int[] row5 = {0,0,0,0,0,0,0,0};
  int[] row6 = {0,0,0,0,0,0,0,0};
  int[] row7 = {0,0,0,0,0,0,0,0};
  int[] row8 = {0,0,0,0,0,0,0,0};
  int[][] theBoard = {row1,row2,row3,row4,row5,row6,row7,row8};

  public Battleboard() {

  } //close Battleboard()

  public int getPos(int row, int col) {
    return theBoard[row][col];
  } //close getPos()

  public void setPos(int row, int col, int val) {
    theBoard[row][col] = val;
  } //close setPos()

  public void printBoard() {
    for (int[] row : theBoard) {
      int printSpot=1;
      for (int spot : row) {
        if (printSpot<8) {
          System.out.print(spot + "\t");
          printSpot++;
        } else {
          System.out.println(spot);
        }
      }
    }
    System.out.println();
  } //close printBoard()

  public void placeBoats() {
    Scanner scan = new Scanner(System.in);
    System.out.println("");
    for (int i=0; i<6; i++) {
      System.out.print("Which ship would you like to place next?"+
        "\n\t1. Destroyer\n\t2. Submarine\n\t3. Cruiser\n\t4. Battlship\n\t5. Carrier\n> ");
      String whichShip = scan.next();
      if (orient.toLower().substring(0, orient.length()).equals("destroyer")) {

      } else if (orient.toLower().substring(0, orient.length()).equals("submarine")) {

      } else if (orient.toLower().substring(0, orient.length()).equals("cruiser")) {

      } else if (orient.toLower().substring(0, orient.length()).equals("battleship")) {

      } else if (orient.toLower().substring(0, orient.length()).equals("carrier")) {

      } else {
        System.out.println("What?");
      }
    }
  }

  public void shipPlacer(int shipLen, String orient) {
    if (orient.toLower().substring(0, orient.length()).equals("horizontal")) {
      for (int i=0; i<shipLength+1; i++) {
        theBoard[startRow][startCol+i]=1;
      }
    } else if (orient.toLower().substring(0, orient.length()).equals("vertical")) {
      for (int i=0; i<shipLength+1; i++) {
        theBoard[startRow+i][startCol]=1;
      }
    } else {
      boundsCheck(startRow, endRow);
      boundsCheck(startCol, endCol);
    }
  }

  public void placeShipType2() {
    int shipLength=2;
    Scanner scan = new Scanner(System.in);
    System.out.print("\nWhich row would you like your destroyer (2 long) to start in?\n> ");
    int startRow = scan.nextInt();
    System.out.print("\nWhich column would you like your destroyer (2 long) to start in?\n> ");
    int startCol = scan.nextInt();
    System.out.print("\nWhich row would you like your destroyer (2 long) to go to?\n> ");
    int endRow = scan.nextInt();
    System.out.print("\nWhich column would you like your destroyer (2 long) to go to?\n> ");
    int endCol = scan.nextInt();

    shipPlacer(shipLength, Checker.orientCheck(startRow, endRow, startCol, endCol));
  }


  public void placeSub() {
    int shipLength=3;
    Scanner scan = new Scanner(System.in);
    System.out.print("\nWhich row would you like your submarine (3 long) to start in?\n> ");
    int startRow = scan.nextInt();
    System.out.print("\nWhich column would you like your submarine (3 long) to start in?\n> ");
    int startCol = scan.nextInt();
    System.out.print("\nWhich row would you like your submarine (3 long) to go to?\n> ");
    int endRow = scan.nextInt();
    System.out.print("\nWhich column would you like your submarine (3 long) to go to?\n> ");
    int endCol = scan.nextInt();

    shipPlacer(shipLength, Checker.orientCheck(startRow, endRow, startCol, endCol));
  } //close placeSub()

  public void placeCruiser() {
    int shipLength=3;
    Scanner scan = new Scanner(System.in);
    System.out.print("\nWhich row would you like your cruiser (3 long) to start in?\n> ");
    int startRow = scan.nextInt();
    System.out.print("\nWhich column would you like your cruiser (3 long) to start in?\n> ");
    int startCol = scan.nextInt();
    System.out.print("\nWhich row would you like your cruiser (3 long) to go to?\n> ");
    int endRow = scan.nextInt();
    System.out.print("\nWhich column would you like your cruiser (3 long) to go to?\n> ");
    int endCol = scan.nextInt();

    shipPlacer(shipLength, Checker.orientCheck(startRow, endRow, startCol, endCol));
  }

  public void placeShipType4() {
    int shipLength=4;
    Scanner scan = new Scanner(System.in);
    System.out.print("\nWhich row would you like your battleship (4 long) to start in?\n> ");
    int startRow = scan.nextInt();
    System.out.print("\nWhich column would you like your battleship (4 long) to start in?\n> ");
    int startCol = scan.nextInt();
    System.out.print("\nWhich row would you like your battleship (4 long) to go to?\n> ");
    int endRow = scan.nextInt();
    System.out.print("\nWhich column would you like your battleship (4 long) to go to?\n> ");
    int endCol = scan.nextInt();

    shipPlacer(shipLength, Checker.orientCheck(startRow, endRow, startCol, endCol));
  }

  public void placeShipType5() {
    int shipLength=5;
    Scanner scan = new Scanner(System.in);
    System.out.print("\nWhich row would you like your carrier (5 long) to start in?\n> ");
    int startRow = scan.nextInt();
    System.out.print("\nWhich column would you like your carrier (5 long) to start in?\n> ");
    int startCol = scan.nextInt();
    System.out.print("\nWhich row would you like your carrier (5 long) to go to?\n> ");
    int endRow = scan.nextInt();
    System.out.print("\nWhich column would you like your carrier (5 long) to go to?\n> ");
    int endCol = scan.nextInt();

    shipPlacer(shipLength, Checker.orientCheck(startRow, endRow, startCol, endCol));
  }

}