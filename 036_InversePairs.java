/**
 * Created by Administrator on 2017/3/9.
 */
public class InversePairs {

//    public int inversePairs(int[] nums) {
//        if (nums == null) return 0;
//        int[] copy = nums.clone();
//        return mergeSort(nums, copy, 0, nums.length - 1);
//    }
//
//    private int mergeSort(int[] nums, int[] aux, int start, int end) {
//        if (start == end) {
//            aux[start] = nums[start];
//            return 0;
//        }
//        int length = (end - start) / 2;
//        int left = mergeSort(aux, nums, start, start + length);
//        int right = mergeSort(aux, nums, start + length + 1, end);
//
//        int leftEndIdx = start + length;
//        int rightEndIdx = end;
//        int count = 0;
//        int point = rightEndIdx;
//
//        while (leftEndIdx >= start && rightEndIdx >= start + length + 1) {
//            if (nums[leftEndIdx] > nums[rightEndIdx]) {
//                aux[point--] = nums[leftEndIdx--];
//                count += (rightEndIdx - start - length);
//            } else {
//                aux[point--] = nums[rightEndIdx--];
//            }
//        }
//        for (int i = leftEndIdx; i >= start; i--)
//            aux[point--] = nums[i];
//        for (int j = rightEndIdx; j >= start + length + 1; j--)
//            aux[point--] = nums[j];
//        return left + count + right;
//    }


    public int inversePairs(int[] nums) {
        if (nums == null) return 0;
        int[] aux = new int[nums.length];
        return mergeSort(nums, aux, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int[] aux, int lo, int hi) {
        if(lo >= hi) return 0;
        int mid = (lo + hi) / 2;
        int left = mergeSort(nums, aux, lo, mid);
        int right = mergeSort(nums, aux, mid + 1, hi);
        int midCount = merge(nums, aux, lo, mid, hi);
        return left + right + midCount;
    }

    private int merge(int[] nums, int[] aux, int lo, int mid, int hi) {
        int count = 0;
        int i = mid, j = hi;
        for (int k = lo; k <= hi; k++)
            aux[k] = nums[k];

        for (int k = hi; k >= lo; k--) {
            if (i < lo) nums[k] = aux[j--];
            else if (j <= mid) nums[k] = aux[i--];
            else if (aux[j] < aux[i]) {
                count += (j - mid);
                nums[k] = aux[i--];
            } else nums[k] = aux[j--];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,0};
        InversePairs i = new InversePairs();
        System.out.print(i.inversePairs(nums));
    }

}
