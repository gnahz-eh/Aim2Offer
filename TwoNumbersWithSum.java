/**
 * Created by Administrator on 2017/3/11.
 */
public class TwoNumbersWithSum {
    public boolean findNumberWithSum(int[] data, int sum) {
        boolean found = false;
        if (data == null || data.length < 2)
            return found;
        int num1 = 0, num2 = 0;
        int start = 0, end = data.length - 1;

        while (start < end) {
            int curSum = data[start] + data[end];
            if (curSum == sum) {
                num1 = data[start];
                num2 = data[end];
                found = true;
                break;
            } else if (curSum > sum)
                end--;
            else start++;
        }
        System.out.println(num1);
        System.out.println(num2);
        return found;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,7,11,15};
        TwoNumbersWithSum t = new TwoNumbersWithSum();
        t.findNumberWithSum(nums, 15);
    }
}
