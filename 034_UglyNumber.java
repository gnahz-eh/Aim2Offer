/**
 * Created by Administrator on 2017/3/9.
 */
public class UglyNumber {
    public int[] getUglyNumber(int n) {
        if (n < 0) return new int[1];
        int[] uglyArray = new int[n];
        uglyArray[0] = 1;
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        for (int i = 1; i < uglyArray.length; ++i) {
            int min = Math.min(uglyArray[idx2]*2, Math.min(uglyArray[idx3]*3, uglyArray[idx5]*5));
            uglyArray[i] = min;
            while (uglyArray[idx2]*2 <= min) idx2++;
            while (uglyArray[idx3]*3 <= min) idx3++;
            while (uglyArray[idx5]*5 <= min) idx5++;
        }
        return uglyArray;
    }

    public static void main(String[] args) {
        UglyNumber u = new UglyNumber();
        int[] res = u.getUglyNumber(1500);
        for (int i : res)
            System.out.println(i);
    }
}
