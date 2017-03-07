/**
 * Created by Administrator on 2017/3/7.
 */
public class StringPermutation {

    public void permutation(char[] str) {
        if (str == null)
            return;
        permutation(str, 0);
    }

    private void permutation(char[] str, int begin) {
        if (begin == str.length)
            System.out.println(str);
        else {
            for (int i = begin; i != str.length; i++) {
                char temp = str[i];
                str[i] = str[begin];
                str[begin] = temp;

                permutation(str, begin + 1);

                temp = str[i];
                str[i] = str[begin];
                str[begin] = temp;
            }
        }
    }

    public static void main(String[] args) {
        char[] str = {'a','b','c'};
        StringPermutation s = new StringPermutation();

        s.permutation(str);

    }
}
