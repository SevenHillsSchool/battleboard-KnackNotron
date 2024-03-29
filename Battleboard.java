import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Battleboard {
  int boardNum;
  int[][] theBoard = new int[9][9];
  int[][] playerOneBoard = new int[9][9];
  int[][] playerTwoBoard = new int[9][9];
  int[][] playerOneGuessBoard = new int[9][9];
  int[][] playerTwoGuessBoard = new int[9][9];

  public Battleboard(int board) {
    boardNum = board;
  } //close Battleboard()

  public void play(String name1, String name2, Battleboard board) {
    makeBoard(board.theBoard);
    makeBoard(board.playerOneBoard);
    makeBoard(board.playerTwoBoard);
    makeBoard(board.playerOneGuessBoard);
    makeBoard(board.playerTwoGuessBoard);
    // player one ship placing:
    System.out.println("\n\033\143" + "\n\033\143");
    placeBoats(board.playerOneBoard, name1, board.theBoard);
    // player two ship placing:
    System.out.println("\n\033\143" + "\n\033\143");
    placeBoats(board.playerTwoBoard, name2, board.theBoard);
    ArrayList<Turn> turnList = new ArrayList<Turn>();
    int turnTracker=1;
    while ((areShipsRemaining(board.playerOneBoard)>0) && (areShipsRemaining(board.playerTwoBoard)>0)) {
      System.out.println(name1 + " has " + areShipsRemaining(board.playerOneBoard) + " unhit spaces remaining.");
      System.out.println(name2 + " has " + areShipsRemaining(board.playerTwoBoard) + " unhit spaces remaining.");
      Turn.honkshoe(1500);
      if (turnTracker%2==1) {
      // player 1 guessing:
        // small buffer period to allow time to switch who's looking at the screen without giving away ship locations
        System.out.println("\n\033\143" + "\n\033\143");
        System.out.println(name1 + "\'s turn in 3...");
        Turn.honkshoe(1000);
        System.out.println("\n\033\143" + "\n\033\143");
        System.out.println(name1 + "\'s turn in 2...");
        Turn.honkshoe(1000);
        System.out.println("\n\033\143" + "\n\033\143");
        System.out.println(name1 + "\'s turn in 1...");
        Turn.honkshoe(1000);
        turnList.add(new Turn(name1, turnTracker-1));
        turnList.get(turnTracker-1).guess(board.playerOneBoard, board.playerOneGuessBoard, board.playerTwoBoard, name1);
        turnTracker++;
      } else if (turnTracker%2==0) {
      // player 2 guessing:
        // small buffer period to allow time to switch who's looking at the screen without giving away ship locations
        System.out.println("\n\033\143" + "\n\033\143");
        System.out.println(name2 + "\'s turn in 3...");
        Turn.honkshoe(1000);
        System.out.println("\n\033\143" + "\n\033\143");
        System.out.println(name2 + "\'s turn in 2...");
        Turn.honkshoe(1000);
        System.out.println("\n\033\143" + "\n\033\143");
        System.out.println(name2 + "\'s turn in 1...");
        Turn.honkshoe(1000);
        turnList.add(new Turn(name2, turnTracker-1));
        turnList.get(turnTracker-1).guess(board.playerTwoBoard, board.playerTwoGuessBoard, board.playerOneBoard, name2);
        turnTracker++;
      }
    }
    if (areShipsRemaining(board.playerOneBoard)>0) {
      System.out.println("\n\033\143" + "\n\033\143");
      System.out.println("Congrats " + name1 + "! You win!");
    } else if (areShipsRemaining(board.playerTwoBoard)>0) {
      System.out.println("\n\033\143" + "\n\033\143");
      System.out.println("Congrats " + name2 + "! You win!");
    } else {
      System.out.println("Something went wrong...");
    }
  }

  public void makeBoard(int[][] board) {
    for (int i=0; i<9; i++) {
      if (i==0) {
        for (int j=0; j<9; j++) {
          board[i][j] = j;
        }
      } else {
          board[i][0] = i;
        for (int j=1; j<9; j++) {
          board[i][j] = 0;
        }
      }
    }
  }

  public int getPos(int row, int col, int[][] board) {
    return board[row][col];
  } //close getPos()

  public void setPos(int row, int col, int val, int[][] board) {
    board[row][col] = val;
  } //close setPos()

  public static void printBoard(int[][] board) {
    for (int[] row : board) {
      int printSpot=1;
      if (row == board[0]) {
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

  public int areShipsRemaining(int[][] board) {
    int onesFound=0;
    // for (int[] row : board) {
    for (int i=1; i<9; i++) {
      // int checkSpot=1;
      for (int j=1; j<9; j++) {
        if (board[i][j]==1) {
          onesFound++;
        } else {
        }
      }
    }
    return onesFound;
  } //close areShipsRemaining()

  public void placeBoats(int[][] board, String player, int[][] theBoard) {
    Scanner scan = new Scanner(System.in);
    String shipPrompt = ("Which ship would you like to place?"+
      "\n\t1. Destroyer\n\t2. Submarine\n\t3. Cruiser\n\t4. Battleship\n\t5. Carrier\n> ");
    Boolean[] shipsToBePlaced = {true,true,true,true,true};
    do {
      System.out.println("\n\033\143" + "\n\033\143");
      System.out.println(player + ":\n");
      printBoard(board);
      System.out.print(shipPrompt);
      String whichShip = scan.next();
      if (shipPrompt.contains("Destroyer") && whichShip.length()<="destroyer".length() && (whichShip.toLowerCase().equals("destroyer".substring(0, whichShip.length())) || whichShip.equals("1"))) {
        shipPrompt = shipPrompt.replace("\n\t1. Destroyer", "");
        shipsToBePlaced[0]=false;
        placeShipPrompt(1,2,board,theBoard);
      } else if (shipPrompt.contains("Submarine") && whichShip.length()<="submarine".length() && (whichShip.toLowerCase().equals("submarine".substring(0, whichShip.length())) || whichShip.equals("2"))) {
        shipPrompt = shipPrompt.replace("\n\t2. Submarine", "");
        shipsToBePlaced[1]=false;
        placeShipPrompt(2,3,board,theBoard);
      } else if (shipPrompt.contains("Cruiser") && whichShip.length()<="cruiser".length() && (whichShip.toLowerCase().equals("cruiser".substring(0, whichShip.length())) || whichShip.equals("3"))) {
        shipPrompt = shipPrompt.replace("\n\t3. Cruiser", "");
        shipsToBePlaced[2]=false;
        placeShipPrompt(3,3,board,theBoard);
      } else if (shipPrompt.contains("Battleship") && whichShip.length()<="battleship".length() && (whichShip.toLowerCase().equals("battleship".substring(0, whichShip.length())) || whichShip.equals("4"))) {
        shipPrompt = shipPrompt.replace("\n\t4. Battleship", "");
        shipsToBePlaced[3]=false;
        placeShipPrompt(4,4,board,theBoard);
      } else if (shipPrompt.contains("Carrier") && whichShip.length()<="carrier".length() && (whichShip.toLowerCase().equals("carrier".substring(0, whichShip.length())) || whichShip.equals("5"))) {
        shipPrompt = shipPrompt.replace("\n\t5. Carrier", "");
        shipsToBePlaced[4]=false;
        placeShipPrompt(5,5,board,theBoard);
      } else {
        System.out.println("You've already placed that ship. Choose a different one to place!");
        Turn.honkshoe(1500);
      }
    } while (!(Arrays.asList(shipsToBePlaced).stream().allMatch(val -> val == false)));
    System.out.println("\n\033\143" + "\n\033\143");
    System.out.println(player + ", here is your final board:\n");
    printBoard(board);
    Turn.honkshoe(2000);
  } //close placeBoats()

  public void shipPlacer(int row, int col, int shipLen, String orient, int magnitude, int[][] placeBoard, int[][] theBoard) {
    if (orient.equals("h")) {
      for (int i=0; i<shipLen; i++) {
        placeBoard[row][col+(i*magnitude)]=1;
        theBoard[row][col+(i*magnitude)]=1;
      }
    } else if (orient.equals("v")) {
      for (int i=0; i<shipLen; i++) {
        placeBoard[row+(i*magnitude)][col]=1;
        theBoard[row+(i*magnitude)][col]=1;
      }
    } else {
      System.out.println("Something went wrong...");
    }
  }

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
      return "Something went wrong...";
    }
  } //close placeShipPromptFiller()

  public void placeShipPrompt(int shipType, int shipLength, int[][] board, int[][] theBoard) {
    Scanner scan = new Scanner(System.in);
    String filler = placeShipPromptFiller(shipType);
    boolean wrongLength = true;
    boolean alreadyShipThereInitial = true;
    boolean alreadyShipThereFinal = true;
    int startRow;
    int startCol;
    int endRow=-1;
    int endCol=-1;
    do {
      System.out.println("\n\033\143" + "\n\033\143");
      printBoard(board);
      System.out.print("\nWhich row would you like your "+filler+" to start in?\n> ");
      startRow = scan.nextInt();
      startRow = Checker.boundCheck(startRow, "row", "start");
      System.out.print("\nWhich column would you like your "+filler+" to start in?\n> ");
      startCol = scan.nextInt();
      startCol = Checker.boundCheck(startCol, "col", "start");
      alreadyShipThereInitial = Checker.alreadyShipThereCheck(startRow, startCol, 0, board);
      if (alreadyShipThereInitial==false) {
        board[startRow][startCol]=1;
        System.out.println("\n\033\143" + "\n\033\143");
        printBoard(board);
        System.out.print("\nWhich row would you like your "+filler+" to go to?\n> ");
        endRow = scan.nextInt();
        endRow = Checker.boundCheck(endRow, "row", "end");
        System.out.print("\nWhich column would you like your "+filler+" to go to?\n> ");
        endCol = scan.nextInt();
        endCol = Checker.boundCheck(endCol, "col", "end");
        board[startRow][startCol] = 0;
        alreadyShipThereFinal = Checker.alreadyShipThereCheck(startRow, startCol, shipLength, board, Checker.orientCheck(startRow, endRow, startCol, endCol), Checker.magnitude(startRow, endRow, startCol, endCol));
        // if (alreadyShipThereFinal) board[startRow][startCol]=0;
        wrongLength=Checker.lengthCheck(startRow, endRow, startCol, endCol, shipLength);
        if (wrongLength) board[startRow][startCol]=0;
      }
    } while (wrongLength || alreadyShipThereFinal || alreadyShipThereInitial);

    if (endRow>0 && endRow<9 && endCol>0 && endCol<9) {
      shipPlacer(startRow, startCol, shipLength, Checker.orientCheck(startRow, endRow, startCol, endCol), Checker.magnitude(startRow, endRow, startCol, endCol), board, theBoard);
    }
  } //close placeShipPrompt()

} //close Battleboard class
