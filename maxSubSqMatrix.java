package DP;

public class maxSubSqMatrix {
	
	static int calc(int[][] a, int m, int n)
	{
		int max = 0;
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				if (a[i - 1][j - 1] == 0)
					dp[i][j] = 0;
				else
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
				if (max < dp[i][j])
					max = dp[i][j];
			}
		}
 		return max;
	}

	public static void main(String[] args) {
		int[][] a =
			{
				{ 0, 0, 1, 0, 1, 1 },
				{ 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 1, 1, 1, 1 },
				{ 1, 1, 0, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 0, 1, 1, 1 },
				{ 1, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 1, 1 }
			};
		System.out.print("The size of largest square sub-matrix of 1's is : " + calc(a, a.length, a[0].length));

	}

}
