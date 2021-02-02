public class DrawTriangle {
   public static void main(String[] args) {
      triangle(10);
   }

   public static void triangle(int N) {
      int n = N;
      while (N > 0){
         int a = n - N + 1;
         while (a > 0) {
            System.out.print("*");
            a = a - 1;
         }
         System.out.println();
         N = N - 1;
      }
   }
}
