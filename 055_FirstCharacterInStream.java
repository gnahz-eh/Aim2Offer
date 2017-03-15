import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/15.
 */
public class FirstCharacterInStream {

    public char firstAppearingOnce(String s) {
        if (s == null)
            return '#';
        int[] hashMap = new int[256];
        Arrays.fill(hashMap, -1);

        for (int i = 0; i < s.length(); i++) {
            if (hashMap[s.charAt(i)] == -1)
                hashMap[s.charAt(i)] = i;
            else if (hashMap[s.charAt(i)] >= 0)
                hashMap[s.charAt(i)] = -1;
        }

        int minIndex = 257;
        int i = 0;
        char res = '#';
        for (; i < hashMap.length; i++) {
            if (hashMap[i] >= 0 && hashMap[i] < minIndex) {
                minIndex = hashMap[i];
                res = (char) i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "google";
        FirstCharacterInStream f = new FirstCharacterInStream();
        System.out.print(f.firstAppearingOnce(s));
    }
}
