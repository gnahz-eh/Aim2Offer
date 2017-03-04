/**
 * Created by Administrator on 2017/3/4.
 */
public class NumberOfOneInBinary {

    int numberOfOne(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfOneInBinary n = new NumberOfOneInBinary();
        System.out.println(n.numberOfOne(1));
        System.out.println(n.numberOfOne(0x7fffffff));// 31
        System.out.println(n.numberOfOne(0x80000000));// 1
        System.out.println(n.numberOfOne(0xffffffff));// 32
        System.out.println(n.numberOfOne(0));// 0
    }
}
