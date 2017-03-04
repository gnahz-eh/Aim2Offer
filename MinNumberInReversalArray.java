/**
 * Created by Administrator on 2017/3/4.
 */
public class MinNumberInReversalArray {

    int min(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0;
        int right = nums.length - 1;
        int mid = left;

        while (nums[left] >= nums[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }

            mid = (left + right) / 2;

            if (nums[left] == nums[mid] && nums[mid] == nums[right])
                return minInOrder(nums, left, right);
            if (nums[left] <= nums[mid])
                left = mid;
            else if (nums[mid] <= nums[right])
                right = mid;
        }
        return nums[mid];
    }

    int minInOrder(int[] nums, int begin, int end) {
        int res = nums[begin];
        for (int i = begin+1; i <= end; ++i)
            res = res > nums[i] ? nums[i] : res;
        return res;
    }

    public static void main(String[] args) {
        MinNumberInReversalArray m = new MinNumberInReversalArray();
        int[] nums = {3,4,5,6,7,1,2};
        int[] nums1 = {6,7,1,2,3,4,5};
        System.out.println(m.min(nums));
        System.out.println(m.min(nums1));
    }
}
