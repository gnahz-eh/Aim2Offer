/**
 * Created by Administrator on 2017/3/8.
 */
public class MoreThanHalfNumber {

    public int moreThanHalfNum(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int result = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (times == 0) {
                result = nums[i];
                times = 1;
            } else if (nums[i] == result)
                times++;
            else times--;
        }

        if (!checkMoreThanHalf(nums, result))
            result = 0;
        return result;
    }

    boolean checkMoreThanHalf(int[] nums, int num) {
        int times = 0;
        for (int i = 0; i < nums.length; ++i)
            if (nums[i] == num)
                times++;
        boolean moreThanHalf = true;
        if (times * 2 <= nums.length)
            moreThanHalf = false;
        return moreThanHalf;
    }

    public static void main(String[] args) {
        MoreThanHalfNumber m = new MoreThanHalfNumber();
        int[] nums = {1,2,3,2,2,2,5,4,2};
        System.out.println(m.moreThanHalfNum(nums));
    }
}
