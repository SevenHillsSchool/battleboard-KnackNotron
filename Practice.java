public class Practice {
  public static void main(String args[]) {
    int[] arr = new int[3];
    for(int x=0; x<arr.length; x++) {
      double resetRandom = Math.random()*1000;
      arr[x] = (int) (Math.random()*6)+1;
      System.out.print(arr[x] + ", ");

      for (int i : arr) {
        if (arr[0] == arr[1] == arr[2]) {
          System.out.println("They\'re all the same number!");
        } else if (arr[0] > arr[1]) {
          System.out.println(arr[0] + " is greater than " + arr[1]);
        } else if (arr[1] > arr[2]) {
          System.out.println(arr[1] + " is greater than " + arr[2]);
        }
      } //close second for loop
    } //close first for loop

  } //close main()
} //close Practice class
