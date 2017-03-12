/**
 * Created by Administrator on 2017/3/12.
 */
public class DuplicationInArray {

    // time O(n), space O(n)
//    public boolean duplicate(int nums[], int length, int[] duplication) {
//        boolean[] exist = new boolean[length];
//        for (int i = 0; i < exist.length; i++) {
//            if (exist[nums[i]] == true) {
//                duplication[0] = nums[i];
//                return true;
//            }
//            exist[nums[i]] = true;
//        }
//        return false;
//    }

    public boolean duplicate(int nums[], int length, int[] duplication) {
        if (nums == null || length <= 0)
            return false;
        for (int i = 0; i < length; i++)
            if (nums[0] < 0 || nums[i] > length - 1)
                return false;

        for (int i = 0; i < length; ++i) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        DuplicationInArray d = new DuplicationInArray();
        int[] nums = {1,2,3,4,5,6,5};
        int[] du = new int[1];
        System.out.println(d.duplicate(nums, nums.length, du));
        System.out.println(du[0]);
    }
}
