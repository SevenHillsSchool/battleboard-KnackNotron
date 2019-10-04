import java.util.Scanner;

public class Turn {
  String player;
  int turnNum=0;
  int nBoard=0;

  public Turn(String playerName, int turnNumber, int boardNumber) {
    player = playerName;
    turnNum = turnNumber;
    nBoard=boardNumber;
  }

  public void guess(Battleboard board) {
    turnNum++;
    Scanner scan = new Scanner(System.in);
    System.out.print("\nGuess a row:\n> ");
    int guessRow = scan.nextInt();
    System.out.print("\nGuess a column:\n> ");
    int guessCol = scan.nextInt();
    if (board[guessRow][guessCol]==0) {
      System.out.println("\nYou missed! Darn.");
      board[guessRow][guessCol] = 3;
    } else if (board[guessRow][guessCol]==1) {
      System.out.println("\nIssa hit, man!");
      board[guessRow][guessCol] = 4;
    } else if (board[guessRow][guessCol]==3) {
      System.out.println("\nBruh. You already guessed that. And it was a miss. Try again.");
      turnNum-=1;
      guess(board)
    } else if (board[guessRow][guessCol]==4) {
      System.out.println("\nBruh. You already hit that spot. Chill. Try again.");
      turnNum-=1;
      guess(board)
    }
  }
}
