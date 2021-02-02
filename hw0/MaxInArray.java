public class MaxInArray {
   public static int max(int[] m) {
      int len = m.length;
      int num_max = 0;

      while(len > 0){
         if (m[len - 1] >= num_max) {
            num_max = m[len - 1];
         }
         len = len - 1;
      }
      return num_max;
   }

   public static void main(String[] args) {
      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
      System.out.println(max(numbers));
   }
}
