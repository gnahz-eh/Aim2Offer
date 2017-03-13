/**
 * Created by Administrator on 2017/3/13.
 */
public class NumericStrings {

    public boolean isNumber(String s) {

        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;

        s = s.trim();

        for (int i = 0; i < s.length(); ++i) {

            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (pointSeen || eSeen)
                    return false;
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen)
                    return false;
                eSeen = true;
                numberAfterE = false;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i-1) != 'e')
                    return false;
            } else
                return false;
        }
        return  numberAfterE && numberSeen;
    }

    public static void main(String[] args) {
        NumericStrings n = new NumericStrings();
        String s = "12e+5.4";
        System.out.print(n.isNumber(s));
    }
}
