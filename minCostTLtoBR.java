package DP;

public class minCostTLtoBR {
	
	public static int findMinCost(int[][] cost)
	{
		int M = cost.length;
		int N = cost[0].length;

		int[][] dp = new int[M][N];

		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < N; j++)
			{
				dp[i][j] = cost[i][j];

				if (i == 0 && j > 0) {
					dp[0][j] += dp[0][j - 1];
				}

				else if (j == 0 && i > 0) {
					dp[i][0] += dp[i - 1][0];
				}

				else if (i > 0 && j > 0) {
					dp[i][j] += Integer.min(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		return dp[M - 1][N - 1];
	}

	public static void main(String[] args)
	{
		int[][] cost =
		{
			{ 4, 7, 8, 6, 4 },
			{ 6, 7, 3, 9, 2 },
			{ 3, 8, 1, 2, 4 },
			{ 7, 1, 7, 3, 7 },
			{ 2, 9, 8, 9, 3 }
		};

		System.out.print("The minimum cost to move from Top Left to Bottom Right is : " + findMinCost(cost));
	}

}
