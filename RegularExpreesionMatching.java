import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.match( "aab".toCharArray(),
                "c*a*b".toCharArray() ) );

    }

    private boolean match(char text[], char pattern[]) {
        boolean dp[][] = new boolean[text.length+1][pattern.length+1];
        dp[0][0] = true;
        //pattern like a*b*
        // " , a, *, b, *
        // T , F, T, F, T
        for(int i = 1; i < dp[0].length; i++){
            if(pattern[i-1] == '*')
                dp[0][i] = dp[0][i-2];
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(text[i-1] == pattern[j-1] || pattern[j-1] == '.')
                    dp[i][j] = dp[i-1][j-1];
                else if(pattern[j-1] == '*'){
                    dp[i][j] = dp[i][j-2];
                    if(text[i-1] == pattern[j-2] || pattern[j-2] == '.')
                        dp[i][j] = dp[i-1][j] | dp[i][j];
                }else
                    dp[i][j] = false;
            }
        }
        return dp[text.length][pattern.length];
    }

}
