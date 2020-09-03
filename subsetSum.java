package DP;
import java.util.*;
public class subsetSum {
	static boolean calc(int[] a, int sum, int n)
	{
		boolean[][] dp = new boolean[n + 1][sum + 1];
		for (int i = 0; i <= n; i++)
			dp[i][0] = true;
		
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= sum; j++)
			{
				if (a[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j - a[i - 1]];
			}
		}
		
		return dp[n][sum];
	}
	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int n = obj.nextInt();
		int arr[] = new int[n];
		for (int i =  0; i < n; i++)
			arr[i] = obj.nextInt();
		int sum = obj.nextInt();
		System.out.println(calc(arr, sum, n));

	}

}
