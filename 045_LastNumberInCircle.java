import java.util.*;

/**
 * Created by Administrator on 2017/3/11.
 */
public class LastNumberInCircle {

    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    public static void main(String[] args) {
        LastNumberInCircle l = new LastNumberInCircle();
        System.out.print(l.lastRemaining(7, 3));
    }
}
