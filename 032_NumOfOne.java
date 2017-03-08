/**
 * Created by Administrator on 2017/3/8.
 */

// 以21345为例，把1到21345的所有数字分为两段，1-1345,1346-21345。

// 先看1346-21345,1的出现分为两种情况，1出现在最高位，1出现在其他位。

// 考虑1出现在最高位：从1346到21345的数字中，1出现在10000-19999这10000个数字的万位中，
// 一共出现10000次（最高位大于1的情况下），当最高位为1时，出现1的次数为除去最高位数字后的数字再加1，
// 如1346-11345，最高位出现1的次数为1345+1=1346次。

// 考虑1出现在其他位：由于最高位是2，因此1346-21345可以分为两段，1346-11345,11346-21345，
// 每一段剩下的4位中，每一位都可以选择为1，共有4种，而其他三位在0-9之间任意选择，因此根据排列组合原则，
// 总共出现的次数是2*4*10^3=6000.

// 至于1-1345中1出现的次数，通过上述方法递归得到。这也是为什么要分成1-1345和1346-21345两段的原因，
// 因为把21345的最高位去掉就编成1345，便于采用递归的思路。


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

    public static void main(String[] args) {
        NumOfOne n = new NumOfOne();
        System.out.println(n.numberOfOneBetweenOneAndN(21345));
    }
}
