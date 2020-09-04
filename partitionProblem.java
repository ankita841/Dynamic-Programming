package DP;

import java.util.Scanner;

public class partitionProblem {
	
	static boolean subsetSum(int[] a, int n, int sum)
	{
		if (sum % 2 != 0)
			return false;
		else
		{
			boolean[][] dp = new boolean[n + 1][sum / 2 + 1];
			for (int i = 0; i <= n; i++)
				dp[i][0] = true;
			
			for (int i = 1; i <= n; i++)
			{
				for (int j = 1; j <= sum / 2; j++)
				{
					if (a[i - 1] > j)
						dp[i][j] = dp[i - 1][j];
					else
						dp[i][j] = dp[i - 1][j] || dp[i - 1][j - a[i - 1]];
				}
			}
			
			return dp[n][sum / 2];
		}
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int n = obj.nextInt();
		int a[] = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++)
		{
			a[i] = obj.nextInt();
			sum += a[i];
		}
		if (subsetSum(a, n, sum))
			System.out.println("Yes, the array can be partitioned.");
		else
			System.out.println("No, the array can't be partitioned.");
	}

}
