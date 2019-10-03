public class Checker {

  public static int boundsCheck(int rowStart, int colStart, int rowEnd, int colEnd, int shipType) {
    if (rowStart>8 || rowStart<0) {
      int newRow=-1;
      do {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nRow number must be between 0 and 8\n> ");
        System.out.print("\nWhich rowStart would you like your ship to start in?\n> ");
        newRow = scan.nextInt();
      } while (newRow>8 || newRow<0);
      return newRow;
    } else {
      return rowStart;
    }

    if (colStart>8 || colStart<0) {
      int newCol=-1;
      do {
      Scanner scan = new Scanner(System.in);
      System.out.print("\nColumn number must be between 0 and 8\n> ");
      System.out.print("\nWhich column would you like your ship to start in?\n> ");
      newCol = scan.nextInt();
      return newCol;
      } while (newCol>8 || newCol<0);
      return newCol;
    } else {
      return colStart;
    }

    if (rowEnd>8 || rowEnd<0) {
      int newRow=-1;
      do {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nRow number must be between 0 and 8\n> ");
        System.out.print("\nWhich row would you like your ship to end in?\n> ");
        newRow = scan.nextInt();
      } while (newRow>8 || newRow<0);
      return newRow;
    } else {
      return rowEnd;
    }

    if (colEnd>8 || colEnd<0) {
      int newCol=-1;
      do {
      Scanner scan = new Scanner(System.in);
      System.out.print("\nColumn number must be between 0 and 8\n> ");
      System.out.print("\nWhich column would you like your ship to end in?\n> ");
      newCol = scan.nextInt();
      return newCol;
      } while (newCol>8 || newCol<0);
      return newCol;
    } else {
      return colEnd;
    }

  //types of ships: 5,4,3,3,2
    if (shipType==2) {

    } else if (shipType==3) {

    } else if (shipType==4) {

    } else if (shipType==5) {

    } else {

    }
  } //close boundsCheck()

  public static String orientCheck(int rowStart, int rowEnd, int colStart, int colEnd) {
    if ((rowStart==rowEnd) && !(colStart==colEnd)) {
      return "v";
    } else if ((colStart==colEnd) && !(rowStart==rowEnd)) {
      return "h";
    } else {
      return "n";
    }
  }

  public static int magnitude(int start, int end) {
    if (start>end) {
      return 1;
    } else if (end>start) {
      return -1;
    } else {
      return 1;
    }
  }

}
