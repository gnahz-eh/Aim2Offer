/**
 * Created by Administrator on 2017/3/2.
 */
public class ReplaceSpaces {

    public String ReplaceBlank (String str) {

        if (str == null || str.length() <= 0)
            return null;
        int originalLen = str.length();
        int numberOfBlank = 0;

        for (int i = 0; i < originalLen; ++i)
            if (str.charAt(i) == ' ')
                ++numberOfBlank;

        int newLen = originalLen + numberOfBlank * 2;
        char[] res = new char[newLen];

        int indexOfNew = newLen - 1;
        int indexOfOriginal = originalLen - 1;

        while (indexOfOriginal >= 0) {
            if (str.charAt(indexOfOriginal) == ' ') {
                res[indexOfNew--] = '0';
                res[indexOfNew--] = '2';
                res[indexOfNew--] = '%';
            } else
                res[indexOfNew--] = str.charAt(indexOfOriginal);
            --indexOfOriginal;
        }

        return new String(res);
    }

    public static void main (String[] args) {

        ReplaceSpaces r = new ReplaceSpaces();
        String str = "   ";
        System.out.print(r.ReplaceBlank(str));
    }
}
