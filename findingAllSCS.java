package DP;

import java.util.*;
import java.util.stream.*;
import java.io.*;
public class findingAllSCS{
    
    static List<String> allSCS(String X, String Y, int m, int n, int[][] dp)
    {
        if (m == 0)
            return Arrays.asList(Y.substring(0, n));
        if (n == 0)
            return Arrays.asList(X.substring(0, m));
        if (X.charAt(m - 1) == Y.charAt(n - 1))
        {
            List<String> scs = allSCS(X, Y, m - 1, n - 1, dp);
            return scs.stream().map(str -> str + X.charAt(m - 1)).collect(Collectors.toList());
        }
        if (dp[m - 1][n] < dp[m][n - 1])
        {
            List<String> scs = allSCS(X, Y, m - 1, n, dp);
            return scs.stream().map(str -> str + X.charAt(m - 1)).collect(Collectors.toList());
        }
        if (dp[m - 1][n] > dp[m][n - 1])
        {
            List<String> scs = allSCS(X, Y, m, n - 1, dp);
            return scs.stream().map(str -> str + Y.charAt(n - 1)).collect(Collectors.toList());
        }
        List<String> res = new ArrayList<>();
        List<String> left = allSCS(X, Y, m - 1, n, dp);
        for (String a: left)
            res.add(a + X.charAt(m - 1));
        List<String> top = allSCS(X, Y, m, n - 1, dp);
        for (String a: top)
            res.add(a + Y.charAt(n - 1));
        return res;
            
    }
    
    static Set<String> SCS(String X, String Y)
    {
        int m = X.length(), n = Y.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;
        for (int i = 0; i <= n; i++)
            dp[0][i] = i;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
        return new HashSet<>(allSCS(X, Y, m, n, dp));
    }
    
    public static void main(String[] args) throws IOException{
         String X = "ABCBDAB", Y = "BDCABA";
        Set<String> scs = SCS(X, Y);
        System.out.println("All shortest common supersequence of " + X +
                " and " + Y + " are: " + scs);
    }
}





















