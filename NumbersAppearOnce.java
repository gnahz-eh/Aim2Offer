/**
 * Created by Administrator on 2017/3/11.
 */
public class NumbersAppearOnce {

    public void findNumsAppearOnce(int[] array) {
        if (array == null) return;
        int number = 0;
        for (int i : array)
            number ^= i;

        int index = findFirstBitIs1(number);
        int number1 = 0;
        int number2 = 0;
        for (int i : array) {
            if (isBit1(i, index))
                number1 ^= i;
            else
                number2 ^= i;
        }
        System.out.println(number1);
        System.out.println(number2);
    }

    private int findFirstBitIs1(int number) {
        int indexBit = 0;
        while ((number & 1) == 0) {
            number >>= 1;
            ++indexBit;
        }
        return indexBit;
    }

    private boolean isBit1(int number, int index) {
        number >>= index;
        return (number & 1) == 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,3,6,3,2,5,5};
        NumbersAppearOnce n = new NumbersAppearOnce();
        n.findNumsAppearOnce(nums);
    }
}
