/**
 * Created by Administrator on 2017/3/4.
 */
// Java/050_Pow(x, n).java
public class Power {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE && x > 1)
            return 0;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        return (n % 2 == 0) ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
    }

    public static void main(String[] args) {
        Power p = new Power();
        System.out.println(p.myPow(0.2, 30));
    }
}
