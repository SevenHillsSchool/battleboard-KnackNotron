/*Test file for building and running your program - the main is to support
*   development in Repl.it
*
*/
import java.util.Scanner;

public class Main {
public static Battleboard board1 = new Battleboard(1);

	public static void main ( String[] args) {
			Scanner scan = new Scanner(System.in);
	    System.out.print("Player 1, what's your name?\n> ");
	    String player1 = scan.nextLine();
	    System.out.println();
	    System.out.print("Player 2, what's your name?\n> ");
	    String player2 = scan.nextLine();
	    System.out.println();
			board1.play(player1, player2, board1);
	}  //close main method

} //close the Main class
