package DP;

import java.util.*;

public class implementingDiffUtility {
	
	static void diffUtility(String A, String B, int m, int n, int[][] dp)
	{
		if (m > 0 && n > 0 && A.charAt(m - 1) == B.charAt(n - 1))
		{
			diffUtility(A, B, m - 1, n - 1, dp);
			System.out.print(" " + A.charAt(m - 1));
		}
		
		else if (n > 0 && (m == 0 || dp[m][n - 1] >= dp[m - 1][n]))
		{
			diffUtility(A, B, m, n - 1, dp);
			System.out.print(" +" + B.charAt(n - 1));
		}
		
		else if (m > 0 && (n == 0 || dp[m][n - 1] < dp[m - 1][n]))
		{
			diffUtility(A, B, m - 1, n, dp);
			System.out.print(" -" + A.charAt(m - 1));
		}
		
	}

	static void LCSlength(String A, String B, int l1, int l2, int[][] dp)
	{
		for (int i = 1; i <= l1; i++)
		{
			for (int j = 1; j <= l2; j++)
			{
				if (A.charAt(i - 1) == B.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else 
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		
		String str1 = obj.next();
		String str2 = obj.next();
		int l1 = str1.length(), l2 = str2.length();
		int dp[][] = new int[l1 + 1][l2 + 1];
		
		LCSlength(str1, str2, l1, l2, dp);
		
		diffUtility(str1, str2, l1, l2, dp);

	}

}
