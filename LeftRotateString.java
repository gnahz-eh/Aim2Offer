/**
 * Created by Administrator on 2017/3/11.
 */
public class LeftRotateString {

    public void reverse(StringBuilder sb, int start, int end) {
        if (sb == null || end <= start)
            return;

        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public String rotate(String str, int n) {
        if (str == null && n >= str.length())
            return str;

        int firstStart = 0, firstEnd = n - 1;
        int secondStart = n, secondEnd = str.length() - 1;

        StringBuilder sb = new StringBuilder(str);

        reverse(sb, firstStart, firstEnd);
        reverse(sb, secondStart, secondEnd);
        reverse(sb, firstStart, secondEnd);

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        LeftRotateString l = new LeftRotateString();
        System.out.println(l.rotate(str, 2));
    }
}
