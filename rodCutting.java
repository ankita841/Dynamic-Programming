package DP;

import java.util.*;

public class rodCutting {
	
	static int maxProf(int[] a, int n)
	{
		int dp[][] = new int[a.length + 1][n + 1];
		for (int i = 1; i <= a.length; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				if (i == 1)
					dp[i][j] = j * a[i - 1];
				else
				{
					if (j < i)
						dp[i][j] = dp[i - 1][j];
					else
						dp[i][j] = Math.max(dp[i - 1][j], a[i - 1] + dp[i][j - i]);
				}
			}
		}
		return dp[a.length][n];
	}

	public static void main(String[] args) {
		int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int n = 4;
		int m = maxProf(price, n);
		System.out.println(m);
	}

}
