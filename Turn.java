import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Turn {
  String player;
  int turnNum=0;
  // int nBoard=0;
  int rowGuessed;
  int colGuessed;

  public Turn(String playerName, int turnNumber /*int ,boardNumber*/) {
    player = playerName;
    turnNum = turnNumber;
    // nBoard=boardNumber;
  }

//Getters and setters:
  public void setRowGuessed(int rowGuess) {
    rowGuessed = rowGuess;
  }
  public int getRowGuessed() {
    return rowGuessed;
  }
  public void setColGuessed(int colGuess) {
    colGuessed = colGuess;
  }
  public int getColGuessed() {
    return colGuessed;
  }

  public void honkshoe(int delayInMS) {
    try
    {
        Thread.sleep(delayInMS);
    }
    catch(InterruptedException ex)
    {
        Thread.currentThread().interrupt();
    }
  }

  public void guess(int[][] board) {
    System.out.println("\033\143");
    System.out.println("\033\143");
    Main.board1.printBoard();
    Scanner scan = new Scanner(System.in);
    System.out.print("\nGuess a row:\n> ");
    int guessRow = scan.nextInt();
    System.out.print("\nGuess a column:\n> ");
    int guessCol = scan.nextInt();
    if (board[guessRow][guessCol]==0) {
      System.out.println("\nYou missed! Darn.");
      rowGuessed=guessRow;
      colGuessed=guessCol;
      board[guessRow][guessCol] = 3;
      honkshoe(2000);
    } else if (board[guessRow][guessCol]==1) {
      System.out.println("\nIssa hit!");
      rowGuessed=guessRow;
      colGuessed=guessCol;
      board[guessRow][guessCol] = 4;
      honkshoe(2000);
    } else if (board[guessRow][guessCol]==3) {
      System.out.println("\nBruh. You already guessed that. And it was a miss. Try again.");
      honkshoe(2000);
      guess(board);
    } else if (board[guessRow][guessCol]==4) {
      System.out.println("\nBruh. You already hit that spot. Chill. Try again.");
      honkshoe(2000);
      guess(board);
    }
  }
}
