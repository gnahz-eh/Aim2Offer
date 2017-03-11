/**
 * Created by Administrator on 2017/3/11.
 */
public class ContinuesSequenceWithSum {
    public void findContinuesSequence(int sum) {
        if (sum < 3) return;
        int small = 1, big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;

        while (small < middle) {
            if (curSum == sum) {
                printContineNum(small, big);
            }
            while (curSum > sum && small < middle) {
                curSum -= small;
                small++;
                if (curSum == sum)
                    printContineNum(small, big);
            }
            big++;
            curSum += big;
        }
    }

    public void printContineNum(int small, int big) {
        for (int i = small; i <= big; ++i) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ContinuesSequenceWithSum c = new ContinuesSequenceWithSum();
        c.findContinuesSequence(15);
    }
}
