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
