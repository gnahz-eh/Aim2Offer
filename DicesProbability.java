/**
 * Created by Administrator on 2017/3/11.
 */
public class DicesProbability {

    public void printProbability(int number) {
        if (number < 1) return;
        int gMaxValue = 6;
        int[][] probilities = new int[2][];
        probilities[0] = new int[gMaxValue * number + 1];
        probilities[1] = new int[gMaxValue * number + 1];

        int flag = 0;

        for (int i = 1; i <= gMaxValue; i++)
            probilities[flag][i] = 1;

        for (int k = 2; k <= number; k++) {

            for (int i = 0; i < k; ++i)
                probilities[1 - flag][i] = 0;

            for (int i = k; i <= gMaxValue * k; i++) {
                probilities[1 - flag][i] = 0;
                for (int j = 1; j < i && j <= gMaxValue; ++j)
                    probilities[1 - flag][i] += probilities[flag][i - j];
            }
            flag = 1 - flag;
        }
        double total = Math.pow(gMaxValue, number);
        for (int i = number; i <= gMaxValue * number; i++) {
            double ratio = (double)probilities[flag][i] / total;
            System.out.print(i + " ");
            System.out.println(ratio);
        }
    }

    public static void main(String[] args) {
        DicesProbability d = new DicesProbability();
        d.printProbability(9);
    }
}
