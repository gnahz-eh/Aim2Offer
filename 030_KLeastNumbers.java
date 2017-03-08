/**
 * Created by Administrator on 2017/3/8.
 */
public class KLeastNumbers {

    public int[] getLeastNumbers(int[] nums, int k) {
        if (nums == null || k > nums.length || nums.length <= 0 || k <= 0)
            return null;

        int[] out = new int[k];
        int start = 0, end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(nums, start, end);
            } else {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }

        for (int i = 0; i < k; ++i)
            out[i] = nums[i];
        return out;
    }

    private int partition(int[] nums, int lo, int hi) {
        int key = nums[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; ++j) {
            if (nums[j] <= key) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, hi);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,1,6,2,7,3,8};
        KLeastNumbers k = new KLeastNumbers();
        int[] res = k.getLeastNumbers(nums, 4);
        for (int e : res) {
            System.out.print(e + " ");
        }
    }
}
