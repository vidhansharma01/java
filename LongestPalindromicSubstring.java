import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.longestPalindrome("geekskeegvideo"));
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        boolean dp[][] = new boolean[n][n];
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j <= n - 1; j++){
                dp[i][j] = ( s.charAt(i)==s.charAt(j) ) && (j-i < 3 || dp[i+1][j-1]);

                if(dp[i][j] && ( j-i+1 > res.length() || res.length()== 0) )
                    res = s.substring(i, j+1);
            }
        }
        return res;
    }
}
