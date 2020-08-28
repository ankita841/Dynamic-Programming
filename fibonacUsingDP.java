package DP;
import java.util.*;
public class fibonacUsingDP {
	
	public static int compute(int n, int dp[])
	{
		if (n ==0 || n == 1)
		{
			dp[n] = n;
			return n;
		}
		if (dp[n] != -1)
			return dp[n];
		else
		{
			dp[n] = compute (n - 1, dp) + compute (n - 2, dp);
			return dp[n];
		}
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int n = obj.nextInt();
		int dp[] = new int[n];
		for (int i = 0; i < n; i++)
			dp[i] = -1;
		System.out.println(compute(n - 1, dp));
	}

}
