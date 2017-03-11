import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/11.
 */
public class ContinousCards {

    public boolean isContinuous(int[] number) {
        if (number == null) return false;
        Arrays.sort(number);
        int numberZero = 0;
        int numberGap = 0;

        for (int i = 0; i < number.length && number[i] == 0; i++)
            numberZero++;

        int small = numberZero;
        int big = small + 1;
        while (big < number.length) {
            if (number[small] == number[big])
                return false;
            numberGap += number[big] - number[small] - 1;
            small = big;
            big += 1;
        }
        return (numberGap > numberZero) ? false : true;
    }

    public static void main(String[] args) {
        int[] nums = {5,6,3,0,0};
        ContinousCards c = new ContinousCards();
        System.out.println(c.isContinuous(nums));
    }
}
