/**
 * Created by Administrator on 2017/3/9.
 */
public class SortArrayForMinNumber {

    public void printMin(int[] nums) {
        int[] clone = nums.clone();
        printMinNumber(clone, 0, clone.length - 1);
        for (int i : clone)
            System.out.print(i);
    }

    // Use QUICK_SORT
//    private void printMinNumber(int[] nums, int start, int end) {
//        if (start < end) {
//            int main_number = nums[end];
//            int small_cur = start;
//            for (int j = start; j < end; j++) {
//                if (isSmall(String.valueOf(nums[j]), String.valueOf(main_number))) {
//                    int temp = nums[j];
//                    nums[j] = nums[small_cur];
//                    nums[small_cur] = temp;
//                    small_cur++;
//                }
//            }
//            nums[end] = nums[small_cur];
//            nums[small_cur] = main_number;
//            printMinNumber(nums, 0, small_cur - 1);
//            printMinNumber(nums, small_cur + 1, end);
//        }
//    }
    // Use INSERTION_SORT
    private void printMinNumber(int[] nums, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int key = nums[i];
            int j = i;
            for (; j > start && isSmall(String.valueOf(key), String.valueOf(nums[j-1])); j--)
                nums[j] = nums[j - 1];
            nums[j] = key;
        }
    }

    private boolean isSmall(String m, String n) {
        String left = m + n;
        String right = n + m;
        for (int i = 0; i < left.length(); ++i) {
            if (left.charAt(i) < right.charAt(i))
                return true;
            else if (left.charAt(i) > right.charAt(i))
                return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,32,321};

        SortArrayForMinNumber s = new SortArrayForMinNumber();
        s.printMin(nums);
    }
}
