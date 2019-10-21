import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Turn {
  String player;
  int turnNum=0;
  int rowGuessed;
  int colGuessed;

  public Turn(String playerName, int turnNumber) {
    player = playerName;
    turnNum = turnNumber;
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

  public static void honkshoe(int delayInMS) {
    try
    {
        Thread.sleep(delayInMS);
    }
    catch(InterruptedException ex)
    {
        Thread.currentThread().interrupt();
    }
  }

  public void guess(int[][] playerBoard, int[][] guessBoard, int[][] otherPlayersBoard, String playerNum) {
    System.out.println("\033\143");
    System.out.println("\033\143");
    System.out.println(playerNum + ", here is your current board:");
    Battleboard.printBoard(playerBoard);
    System.out.println("\n\n\n\n\n");
    System.out.println(playerNum + ", here is your board you are guessing on:");
    Battleboard.printBoard(guessBoard);
    Scanner scan = new Scanner(System.in);
    System.out.print("\n" + playerNum + " Guess a row:\n> ");
    int guessRow = scan.nextInt();
    System.out.print("\n" + playerNum + " Guess a column:\n> ");
    int guessCol = scan.nextInt();
    if (otherPlayersBoard[guessRow][guessCol]==0) {
      System.out.println("\nYou missed! Darn.");
      rowGuessed=guessRow;
      colGuessed=guessCol;
      guessBoard[guessRow][guessCol] = 3;
      otherPlayersBoard[guessRow][guessCol] = 3;
      honkshoe(2000);
    } else if (otherPlayersBoard[guessRow][guessCol]==1) {
      System.out.println("\nThat\'s a hit!");
      rowGuessed=guessRow;
      colGuessed=guessCol;
      guessBoard[guessRow][guessCol] = 4;
      otherPlayersBoard[guessRow][guessCol] = 4;
      honkshoe(2000);
    } else if (otherPlayersBoard[guessRow][guessCol]==3) {
      System.out.println("\nBruh. You already guessed that. And it was a miss. Try again.");
      honkshoe(2000);
      guess(otherPlayersBoard, guessBoard, otherPlayersBoard, playerNum);
    } else if (otherPlayersBoard[guessRow][guessCol]==4) {
      System.out.println("\nBruh. You already hit that spot. Chill. Try again.");
      honkshoe(2000);
      guess(otherPlayersBoard, guessBoard, otherPlayersBoard, playerNum);
    }
  }
}
