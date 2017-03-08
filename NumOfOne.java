/**
 * Created by Administrator on 2017/3/8.
 */



public class NumOfOne {
   public int numberOfOneBetweenOneAndN(int n) {
       int count = 0;
       int i = 1;
       int current = 0, high = 0, low = 0;

       while ((n / i) != 0) {
           current = (n / i) % 10;
           high = n / (i * 10);
           low = n - (n / i) * i;

           if (current > 1)
               count += ((high + 1) * i);
           else if (current == 0)
               count += (high * i);
           else
               count += (high * i) + low + 1;
           i *= 10;
       }
       return count;
   }
    public static void main(String[] args) {
        NumOfOne n = new NumOfOne();
        System.out.println(n.numberOfOneBetweenOneAndN(21345));
    }
}
