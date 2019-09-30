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
      int whichShip = scan.nextInt();
      if (whichShip==1) {
        System.out.println("Where would you like to place battleshipType1?");

      } else if (whichShip==2) {
        System.out.println("Where would you like to place battleshipType2?");
      } else if (whichShip==3) {
        System.out.println("Where would you like to place battleshipType3?");
      } else if (whichShip==4) {
        System.out.println("Where would you like to place battleshipType4?");
      } else {
        System.out.println("What?");
      }
    }
  }

  public void placeShipType1() {
    Scanner scan = new Scanner(System.in);
    System.out.print("\nWhich row would you like your ship to start in?\n> ");
    int startRow = scan.nextInt();
    System.out.print("\nWhich column would you like your ship to start in?\n> ");
    int startCol = scan.nextInt();
    System.out.print("\nWhich row would you like your ship to go to?\n> ");
    int endRow = scan.nextInt();
    System.out.print("\nWhich column would you like your ship to go to?\n> ");
    int endCol = scan.nextInt();
  }

  public int boundsCheck(int row, int col, int shipType) {
    int newRow=-1;
    int newCol=-1;
    do {
      if (row>8 || row<0) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nRow number must be between 0 and 8\n> ");
        System.out.print("\nWhich row would you like your ship to start in?\n> ");
        newRow = scan.nextInt();
      } else if (col>8 || col<0) {

      } else {

      }
    } while (newRow>8 || newRow<0 || newCol>8 || newCol<0);


    if (shipType==1) {

    } else if (shipType==2) {

    } else if (shipType==3) {

    } else if (shipType==4) {

    } else {

    }
  }

  public void placeShipType2() {
    Scanner scan = new Scanner(System.in);
    System.out.print("\nWhich row would you like your ship to start in?\n> ");
    int startRow = scan.nextInt();
    System.out.print("\nWhich column would you like your ship to start in?\n> ");
    int startCol = scan.nextInt();
    System.out.print("\nWhich row would you like your ship to go to?\n> ");
    int endRow = scan.nextInt();
    System.out.print("\nWhich column would you like your ship to go to?\n> ");
    int endCol = scan.nextInt();
  }

  public void placeShipType3() {
    Scanner scan = new Scanner(System.in);
    System.out.print("\nWhich row would you like your ship to start in?\n> ");
    int startRow = scan.nextInt();
    System.out.print("\nWhich column would you like your ship to start in?\n> ");
    int startCol = scan.nextInt();
    System.out.print("\nWhich row would you like your ship to go to?\n> ");
    int endRow = scan.nextInt();
    System.out.print("\nWhich column would you like your ship to go to?\n> ");
    int endCol = scan.nextInt();
  }

  public void placeShipType4() {
    Scanner scan = new Scanner(System.in);
    System.out.print("\nWhich row would you like your ship to start in?\n> ");
    int startRow = scan.nextInt();
    System.out.print("\nWhich column would you like your ship to start in?\n> ");
    int startCol = scan.nextInt();
    System.out.print("\nWhich row would you like your ship to go to?\n> ");
    int endRow = scan.nextInt();
    System.out.print("\nWhich column would you like your ship to go to?\n> ");
    int endCol = scan.nextInt();
  }
}
