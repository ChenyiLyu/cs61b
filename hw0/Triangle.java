public class Triangle {
  public static void main(String[] args) {
    int line = 5;

    while (line > 0) {
      int n = 5 - line + 1;
      while (n > 0) {
        System.out.print("*");
        n = n - 1;
      }
      System.out.println();
      line = line - 1;
    }
  }
}

/*
col = col + 1;
int col = 0;
int row = 0;
int SIZE = 5;
row = row + 1;
System.out.print('*');
System.out.println('*');
System.out.println();
while (col <= row) {
while (col < row) {
while (row < SIZE) {
while (row <= SIZE) {
}
**/
