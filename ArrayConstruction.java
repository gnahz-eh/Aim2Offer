/**
 * Created by Administrator on 2017/3/12.
 */
public class ArrayConstruction {

    public void multiply(int[] a, int [] b) {
        int len1 = a.length;
        int len2 = b.length;

        if (len1 == len2 && len2 > 1) {
            b[0] = 1;
            for (int i = 1; i < len1; i++)
                b[i] = b[i - 1] * a[i - 1];

            double temp = 1;
            for (int i = len1 - 2; i >= 0; i--) {
                temp *= a[i + 1];
                b[i] *= temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = new int[a.length];
        ArrayConstruction ac = new ArrayConstruction();
        ac.multiply(a, b);
        for (int i : b)
            System.out.print(i + " ");
    }
}
