/**
 * Created by Administrator on 2017/3/5.
 */
public class ReOrderArray {

    public void reOrderOddEven(int[] nums) {
        if (nums == null) return;
        int len = nums.length;
        
        // 从两端向中间收缩
        int left = 0;
        int right = len - 1;

        while (left != right) {
            while (left < right && (nums[left] & 0x1) != 0)
                left++;
            while (left < right && (nums[right] & 0x1) == 0)
                right--;
            if (left < right) {
                nums[left] = nums[left] ^ nums[right];
                nums[right] = nums[left] ^ nums[right];
                nums[left] = nums[left] ^ nums[right];
            }
        }
    }

    public static void main(String[] args) {
        ReOrderArray r = new ReOrderArray();
        int[] nums = {1,2,3,4,5};
        r.reOrderOddEven(nums);
        for (int e : nums)
            System.out.print(e + " ");
    }
}
