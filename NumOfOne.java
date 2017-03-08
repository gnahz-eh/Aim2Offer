/**
 * Created by Administrator on 2017/3/8.
 */
public class NumOfOne {
    public int numberOfOneBetweenOneAndN(int n) {
        if (n <= 0) return 0;
        StringBuilder sb = new StringBuilder(new Integer(n).toString());
        return numberOfOne(sb);
    }

    private int numberOfOne(StringBuilder sb) {
        if (sb == null || sb.length() == 0 ||  sb.charAt(0) < '0' || sb.charAt(0) > '9')
            return 0;
        int first = sb.charAt(0) - '0';
        int length = sb.length();
        if (length == 1 && first == 0)
            return 0;
        if (length == 1 && first > 0)
            return 1;

        int numFirstDigit = 0;
        if (first > 1)
            numFirstDigit = powerBaseTen(length - 1);
        else if (first == 1)
            numFirstDigit = Integer.parseInt(sb.substring(1)) + 1;
        int numOtherDigits = first * (length - 1) * powerBaseTen(length - 2);
        int numberOfRescursive = numberOfOne(sb.deleteCharAt(0));
        return numFirstDigit + numOtherDigits + numberOfRescursive;
    }

    private int powerBaseTen(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++)
            res *= 10;
        return res;
    }


//    public int numberOfOneBetweenOneAndN(int n) {
//        int count = 0;
//        int i = 1;
//        int current = 0, high = 0, low = 0;
//
//        while ((n / i) != 0) {
//            current = (n / i) % 10;
//            high = n / (i * 10);
//            low = n - (n / i) * i;
//
//            if (current > 1)
//                count += ((high + 1) * i);
//            else if (current == 0)
//                count += (high * i);
//            else
//                count += (high * i) + low + 1;
//            i *= 10;
//        }
//        return count;
//    }



    public static void main(String[] args) {
        NumOfOne n = new NumOfOne();
        System.out.println(n.numberOfOneBetweenOneAndN(21345));
    }
}
