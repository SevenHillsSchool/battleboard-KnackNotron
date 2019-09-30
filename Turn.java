public class Turn {
  String player;
  int turnNum=0;
  int board=0;

  public Turn(String playerName, int turnNumber, int boardNum) {
    player = playerName;
    turnNum = turnNumber;
    board=boardNum;
  }

  public void guess(int row, int col) {
    if (board[row][col]==0) {
      System.out.println("Lalalala");
    }
  }
}
