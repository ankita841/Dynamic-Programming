package DP;

public class maxProdRodCutting {

	public static int rodCut(int n)
	{
		int[] dp = new int[n + 1];

		for (int i = 0; i <= n; i++)
			dp[i] = i;

		for (int i = 2; i <= n; i++)
		{
			for (int j = 1; j <= i; j++)
				dp[i] = Integer.max(dp[i], j * dp[i - j]);
		}

		return dp[n];
	}

	public static void main(String[] args)
	{
		int n = 15;
		System.out.println("Maximum Profit is " + rodCut(n));
	}

}
