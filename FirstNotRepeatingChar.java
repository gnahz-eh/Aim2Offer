/**
 * Created by Administrator on 2017/3/9.
 */
public class FirstNotRepeatingChar {

    // return character
    public char firstNotRepeatingChar(String str) {
        if (str == null) return '\0';
        int[] table = new int[256];
        for (char c : str.toCharArray())
            ++table[c];
        for (char c : str.toCharArray())
            if (table[c] == 1)
                return c;
        return '\0';
    }

    // return index
    public int firstNotRepeatingChar2(String str) {
        if (str == null) return 0;
        int[] table = new int[256];
        for (char c : str.toCharArray())
            ++table[c];
        for (int i = 0; i < str.length(); ++i)
            if (table[str.charAt(i)] == 1)
                return i;
        return 0;
    }

    public static void main(String[] args) {
        String str = "google";
        FirstNotRepeatingChar f = new FirstNotRepeatingChar();
        System.out.print(f.firstNotRepeatingChar2(str));
    }
}
