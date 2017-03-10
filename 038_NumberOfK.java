/**
 * Created by Administrator on 2017/3/10.
 */
public class NumberOfK {

    private int getFirstK(int[] nums, int k, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == k) {
            if ((mid > start && nums[mid - 1] != k) || mid == start)
                return mid;
            else
                end = mid - 1;
        } else if (nums[mid] > k)
            end = mid - 1;
        else  start = mid + 1;
        return getFirstK(nums, k, start, end);
    }

    private int getLastK(int[] nums, int k, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == k) {
            if ((mid < end && nums[mid + 1] != k) || mid == end)
                return mid;
            else
                start = mid + 1;
        } else if (nums[mid] < k)
            start = mid + 1;
        else end = mid - 1;
        return getLastK(nums, k, start, end);
    }

    public int getNumberOfK(int[] nums, int k) {
        int res = 0;
        if (nums != null) {
            int first = getFirstK(nums, k, 0, nums.length - 1);
            int last = getLastK(nums, k, 0, nums.length - 1);
            if (first > -1 && last > -1)
                res = last - first + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,5};
        NumberOfK n = new NumberOfK();
        System.out.print(n.getNumberOfK(nums, 2));
    }
}
