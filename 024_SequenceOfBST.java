/**
 * Created by Administrator on 2017/3/7.
 */
public class SequenceOfBST {

    boolean verifySequenceOfBST(int[] sequence, int from, int to) {
        if (sequence == null || to < from)
            return false;
        int root = sequence[to];

        int i = from;
        for (; i < to; ++i)
            if (sequence[i] > root)
                break;

        int j = i;
        for (; j < to; ++j)
            if (sequence[j] < root)
                return false;

        boolean left = true;
        if (i > from)
            left = verifySequenceOfBST(sequence, from, i - 1);

        boolean right = true;
        if (i < to)
            right = verifySequenceOfBST(sequence, i, to - 1);

        return (left && right);
    }

    public static void main(String[] args) {
        SequenceOfBST s = new SequenceOfBST();
        int[] nums = {5,7,6,9,11,10,8};
        int[] nums2 = {7,4,6,5};
        System.out.println(s.verifySequenceOfBST(nums, 0, nums.length-1));
        System.out.println(s.verifySequenceOfBST(nums2, 0, nums2.length-1));

    }
}
