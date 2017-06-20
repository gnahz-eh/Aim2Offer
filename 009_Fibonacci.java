/**
 * Created by Administrator on 2017/3/4.
 */
public class Fibonacci {
    
    // 递归效率低，使用迭代
    long fib(int n) {
        long yesterday = 0;
        long today = 1;
        long tomorrow = 0;
        for (int i = 2; i <= n; ++i) {
            tomorrow = yesterday + today;
            yesterday = today;
            today = tomorrow;
        }
        return today;
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fib(7));// 13
    }
}
