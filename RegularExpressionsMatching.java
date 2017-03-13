/**
 * Created by Administrator on 2017/3/13.
 */
public class RegularExpressionsMatching {

    public boolean match(String s, String p) {
        if (s == null || p == null)
            return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*' && dp[0][j - 1]) {
                dp[0][j + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j))
                    dp[i+1][j+1] = dp[i][j];

                if (p.charAt(j) == '.')
                    dp[i+1][j+1] = dp[i][j];

                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.')
                        dp[i+1][j+1] = dp[i+1][j-1];
                    else
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                }
            }
        }
        return dp[s.length()][p.length()];

    }


    public static void main(String[] args) {
        RegularExpressionsMatching r = new RegularExpressionsMatching();
        String s = "aa";
        String p = "a";
        System.out.println(r.match(s, p));
    }
}
