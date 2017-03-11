/**
 * Created by Administrator on 2017/3/11.
 */
public class ReverseWordsInSequence {
    public void reverseSequence(String str) {
        if (str == null) return;
        String[] strArray = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strArray.length-1; i >= 0; --i)
            sb.append(strArray[i] + " ");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        ReverseWordsInSequence r = new ReverseWordsInSequence();
        String str = "I am a Students.";
        r.reverseSequence(str);
    }
}


/**
 * Created by Administrator on 2017/3/11.
 */
public class ReverseWordsInSequence {

    public String reverseSequence(String str) {
        if (str == null || str.length() <= 1)
            return str;
        StringBuilder sb = new StringBuilder(str);
        reverse(sb, 0, str.length() - 1);
        int begin = 0, end = 0;

        while (end < str.length()) {
            while (end < str.length() && sb.charAt(end) != ' ')
                end++;
            reverse(sb, begin, end - 1);
            begin = end + 1;
            end = begin;
        }
        return sb.toString();
    }

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

    public static void main(String[] args) {
        ReverseWordsInSequence r = new ReverseWordsInSequence();
        String str = "i am a students.";
        System.out.print(r.reverseSequence(str));
    }
}
