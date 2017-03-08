/**
 * Created by Administrator on 2017/3/8.
 */
public class GreatestSumOfSubArrays {

    public int findGreastSumOfSubArrays(int[] nums) {
        if (nums == null) return 0;
        int maxEndHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            maxEndHere = Math.max(maxEndHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {1,-2,3,10,-4,7,2,-5};

        GreatestSumOfSubArrays g = new GreatestSumOfSubArrays();
        System.out.println(g.findGreastSumOfSubArrays(nums));
    }
}
