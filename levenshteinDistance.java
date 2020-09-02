package DP;

import java.util.*;

public class levenshteinDistance {
	
	static void printld(String A, String B, int m, int n, int[][] dp)
	{
		if (m == 0)
			System.out.print(B.substring(0, n));
		else if (n == 0)
			System.out.print(A.substring(0, m));
		else
		{
			if (A.charAt(m - 1) == B.charAt(n - 1))
				printld(A, B, m - 1, n - 1, dp);
			else if (dp[m - 1][n - 1] < dp[m - 1][n] && dp[m - 1][n - 1] < dp[m][n - 1])
			{
				printld(A, B, m - 1, n - 1, dp);
				System.out.print(A.charAt(m - 1) + "-->" + B.charAt(n - 1) + " ");
			}
			else if (dp[m - 1][n] < dp[m - 1][n - 1] && dp[m - 1][n] < dp[m][n - 1])
			{
				printld(A, B, m - 1, n, dp);
				System.out.print("-" + A.charAt(m - 1) + " ");
			}
			else
			{
				printld(A, B, m, n - 1, dp);
				System.out.print("+" + B.charAt(n - 1) + " ");
			}
		}
	}
	
	static int ld(String A, String B)
	{
		int m = A.length();
		int n = B.length();
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			dp[i][0] = i;
		for (int i = 0; i <= n; i++)
			dp[0][i] = i;
		for (int i = 1; i <= m; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				if (A.charAt(i - 1) == B.charAt(j - 1))
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
				else
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
			}
		}
		System.out.print("Operations performed : ");
		printld(A, B, m, n, dp);
		return dp[m][n];
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		String str1 = obj.next();
		String str2 = obj.next();
		 System.out.println("\nThe Levenshtein Distance of given two strings is : " + ld(str1, str2));

	}

}
