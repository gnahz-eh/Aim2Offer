/**
 * Created by Administrator on 2017/3/8.
 */
public class GreatestSumOfSubArrays {

    public int findGreastSumOfSubArrays(int[] nums) {
        if (nums == null) return 0;
        int curSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (curSum <= 0)
                curSum = nums[i];
            else
                curSum += nums[i];

            if (curSum > greatestSum)
                greatestSum = curSum;
        }
        return greatestSum;
    }

    public static void main(String[] args) {
        int[] nums = {1,-2,3,11,-4,7,2,-5};

        GreatestSumOfSubArrays g = new GreatestSumOfSubArrays();
        System.out.println(g.findGreastSumOfSubArrays(nums));
    }
}
