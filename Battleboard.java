import java.util.Scanner;
import java.util.ArrayList;

public class Battleboard {
  int[] columns = {0,1,2,3,4,5,6,7,8};
  int[] row1 = {1,0,0,0,0,0,0,0,0};
  int[] row2 = {2,0,0,0,0,0,0,0,0};
  int[] row3 = {3,0,0,0,0,0,0,0,0};
  int[] row4 = {4,0,0,0,0,0,0,0,0};
  int[] row5 = {5,0,0,0,0,0,0,0,0};
  int[] row6 = {6,0,0,0,0,0,0,0,0};
  int[] row7 = {7,0,0,0,0,0,0,0,0};
  int[] row8 = {8,0,0,0,0,0,0,0,0};
  int[][] theBoard = {columns,row1,row2,row3,row4,row5,row6,row7,row8};
  int boardNum;

  public Battleboard(int board) {
    boardNum = board;
  } //close Battleboard()

  public void play(String name1, String name2) {
    printBoard();
    placeBoats();
    ArrayList<Turn> turnList = new ArrayList<Turn>();
    int turnTracker=1;
    do {
      if (turnTracker%2==1) {
        turnList.add(new Turn(name1, turnTracker-1 /*,boardNum*/));
        turnList.get(turnTracker-1).guess(theBoard);
        printBoard();
        turnTracker++;
      } else if (turnTracker%2==0) {
        turnList.add(new Turn(name2, turnTracker-1 /*, boardNum*/));
        turnList.get(turnTracker-1).guess(theBoard);
        printBoard();
        turnTracker++;
      }
    } while (areShipsRemaining()>0);
  }

  public int getPos(int row, int col) {
    return theBoard[row][col];
  } //close getPos()

  public void setPos(int row, int col, int val) {
    theBoard[row][col] = val;
  } //close setPos()

  public void printBoard() {
    for (int[] row : theBoard) {
      int printSpot=1;
      if (row == theBoard[0]) {
        for (int spot : row) {
          if (printSpot==1) {
            System.out.print(spot + "  \t");
            printSpot++;
          } else if (printSpot<9) {
            System.out.print(spot + "\t");
            printSpot++;
          } else {
            System.out.println(spot);
          }
        }
        System.out.println("-|---------------------------------------------------------------");
      } else {
        for (int spot : row) {
          if (printSpot==1) {
            System.out.print(spot + "| \t");
            printSpot++;
          } else if (printSpot<9) {
            System.out.print(spot + "\t");
            printSpot++;
          } else {
            System.out.println(spot);
          }
        }
      }
    }
    System.out.println();
  } //close printBoard()

  public int areShipsRemaining() {
    int onesFound=0;
    for (int[] row : theBoard) {
      int checkSpot=1;
      for (int spot : row) {
        if (spot==1) {
          onesFound++;
        } else {

        }
      }
    }
    return onesFound;
  } //close areShipsRemaining()

  public void placeBoats() {
    Scanner scan = new Scanner(System.in);
    String shipPrompt = ("Which ship would you like to place?"+
      "\n\t1. Destroyer\n\t2. Submarine\n\t3. Cruiser\n\t4. Battleship\n\t5. Carrier\n> ");
    boolean[] shipsToBePlaced = {true,true,true,true,true};
    do {
      System.out.println("\n\033\143" + "\n\033\143");
      printBoard();
      System.out.print(shipPrompt);
      String whichShip = scan.next();
      if (whichShip.length()<="destroyer".length() && (whichShip.toLowerCase().equals("destroyer".substring(0, whichShip.length())) || whichShip.equals("1"))) {
        shipPrompt = shipPrompt.replace("\n\t1. Destroyer", "");
        shipsToBePlaced[0]=false;
        placeShipType2();
      } else if (whichShip.length()<="submarine".length() && (whichShip.toLowerCase().equals("submarine".substring(0, whichShip.length())) || whichShip.equals("2"))) {
        shipPrompt = shipPrompt.replace("\n\t2. Submarine", "");
        shipsToBePlaced[1]=false;
        placeSub();
      } else if (whichShip.length()<="cruiser".length() && (whichShip.toLowerCase().equals("cruiser".substring(0, whichShip.length())) || whichShip.equals("3"))) {
        shipPrompt = shipPrompt.replace("\n\t3. Cruiser", "");
        shipsToBePlaced[2]=false;
        placeCruiser();
      } else if (whichShip.length()<="battleship".length() && (whichShip.toLowerCase().equals("battleship".substring(0, whichShip.length())) || whichShip.equals("4"))) {
        shipPrompt = shipPrompt.replace("\n\t4. Battleship", "");
        shipsToBePlaced[3]=false;
        placeShipType4();
      } else if (whichShip.length()<="carrier".length() && (whichShip.toLowerCase().equals("carrier".substring(0, whichShip.length())) || whichShip.equals("5"))) {
        shipPrompt = shipPrompt.replace("\n\t5. Carrier", "");
        shipsToBePlaced[4]=false;
        placeShipType5();
      } else {
        System.out.println("What?");
      }
    } while (shipsToBePlaced[0] || shipsToBePlaced[1] || shipsToBePlaced[2] || shipsToBePlaced[3] || shipsToBePlaced[4]); //close while loop
  } //close placeBoats()

  public void shipPlacer(int row, int col, int shipLen, String orient) {
    if (orient.equals("h")) {
      for (int i=0; i<shipLen; i++) {
        theBoard[row][col+i]=1;
      }
      System.out.println();
      printBoard();
    } else if (orient.equals("v")) {
      for (int i=0; i<shipLen; i++) {
        theBoard[row+i][col]=1;
      }
    } else {
      /*
      Checker.boundCheck(startRow, "row", "start");
      Checker.boundCheck(endRow, "row", "end");
      Checker.boundCheck(startCol, "col", "start");
      Checker.boundCheck(endCol, "col", "end");
      */
      System.out.println("The hell?");
    }
  }

  public void placeShipType2() {
    Scanner scan = new Scanner(System.in);
    System.out.print("\nWhich row would you like your destroyer (2 long) to start in?\n> ");
    int startRow = Checker.boundCheck(scan.nextInt(), "row", "start");
    System.out.print("\nWhich column would you like your destroyer (2 long) to start in?\n> ");
    int startCol = Checker.boundCheck(scan.nextInt(), "col", "start");
    System.out.print("\nWhich row would you like your destroyer (2 long) to go to?\n> ");
    int endRow = Checker.boundCheck(scan.nextInt(), "row", "end");
    System.out.print("\nWhich column would you like your destroyer (2 long) to go to?\n> ");
    int endCol = Checker.boundCheck(scan.nextInt(), "col", "end");

    shipPlacer(startRow, startCol, 2, Checker.orientCheck(startRow, endRow, startCol, endCol));
  } //close placeShipType2()

  public String placeShipPromptFiller(int whichShipType) {
    if (whichShipType==1) {
      return "destroyer (2 long)";
    } else if (whichShipType==2) {
      return "submarine (3 long)";
    } else if (whichShipType==3) {
      return "cruiser (3 long)";
    } else if (whichShipType==4) {
      return "battleship (4 long)";
    } else if (whichShipType==5) {
      return "carrier (5 long)";
    } else {
      return "Why";
    }
  } //close placeShipPromptFiller()

  public void placeShipPrompt(int shipType, int shipLength) {
    Scanner scan = new Scanner(System.in);
    String filler = placeShipPromptFiller(shipType);
    System.out.print("\nWhich row would you like your "+filler+" to start in?\n> ");
    int startRow = scan.nextInt();
    System.out.print("\nWhich column would you like your "+filler+" to start in?\n> ");
    int startCol = scan.nextInt();
    System.out.print("\nWhich row would you like your "+filler+" to go to?\n> ");
    int endRow = scan.nextInt();
    System.out.print("\nWhich column would you like your "+filler+" to go to?\n> ");
    int endCol = scan.nextInt();

    shipPlacer(startRow, startCol, shipLength, Checker.orientCheck(startRow, endRow, startCol, endCol));
  } //close placeShipPrompt()

  public void placeSub() {
    Scanner scan = new Scanner(System.in);
    System.out.print("\nWhich row would you like your submarine (3 long) to start in?\n> ");
    int startRow = scan.nextInt();
    System.out.print("\nWhich column would you like your submarine (3 long) to start in?\n> ");
    int startCol = scan.nextInt();
    System.out.print("\nWhich row would you like your submarine (3 long) to go to?\n> ");
    int endRow = scan.nextInt();
    System.out.print("\nWhich column would you like your submarine (3 long) to go to?\n> ");
    int endCol = scan.nextInt();

    shipPlacer(startRow, startCol, 3, Checker.orientCheck(startRow, endRow, startCol, endCol));
  } //close placeSub()

  public void placeCruiser() {
    Scanner scan = new Scanner(System.in);
    System.out.print("\nWhich row would you like your cruiser (3 long) to start in?\n> ");
    int startRow = scan.nextInt();
    System.out.print("\nWhich column would you like your cruiser (3 long) to start in?\n> ");
    int startCol = scan.nextInt();
    System.out.print("\nWhich row would you like your cruiser (3 long) to go to?\n> ");
    int endRow = scan.nextInt();
    System.out.print("\nWhich column would you like your cruiser (3 long) to go to?\n> ");
    int endCol = scan.nextInt();

    shipPlacer(startRow, startCol, 3, Checker.orientCheck(startRow, endRow, startCol, endCol));
  } //close placeCruiser()

  public void placeShipType4() {
    Scanner scan = new Scanner(System.in);
    System.out.print("\nWhich row would you like your battleship (4 long) to start in?\n> ");
    int startRow = scan.nextInt();
    System.out.print("\nWhich column would you like your battleship (4 long) to start in?\n> ");
    int startCol = scan.nextInt();
    System.out.print("\nWhich row would you like your battleship (4 long) to go to?\n> ");
    int endRow = scan.nextInt();
    System.out.print("\nWhich column would you like your battleship (4 long) to go to?\n> ");
    int endCol = scan.nextInt();

    shipPlacer(startRow, startCol, 4, Checker.orientCheck(startRow, endRow, startCol, endCol));
  } //close placeShipType4()

  public void placeShipType5() {
    Scanner scan = new Scanner(System.in);
    System.out.print("\nWhich row would you like your carrier (5 long) to start in?\n> ");
    int startRow = scan.nextInt();
    System.out.print("\nWhich column would you like your carrier (5 long) to start in?\n> ");
    int startCol = scan.nextInt();
    System.out.print("\nWhich row would you like your carrier (5 long) to go to?\n> ");
    int endRow = scan.nextInt();
    System.out.print("\nWhich column would you like your carrier (5 long) to go to?\n> ");
    int endCol = scan.nextInt();

    shipPlacer(startRow, startCol, 5, Checker.orientCheck(startRow, endRow, startCol, endCol));
  } //close placeShipType5()

}
