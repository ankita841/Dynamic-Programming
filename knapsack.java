package DP;

public class knapsack {
	
	static int knapcomp(int wts[], int prices[], int n, int w)
	{
		if (n == 0 || w == 0)
			return 0;
		
		int inc = 0, exc = 0;
		if (wts[n -1] <= w)
			inc = prices[n - 1] + knapcomp(wts, prices, n - 1, w - wts[n-1]);
		
		exc = knapcomp(wts, prices, n - 1, w);
		
		return Math.max(inc, exc);
	}
	
	static int bottomUP(int wts[], int prices[], int n, int W)
	{
		int dp[][] = new int[50][50];
		for (int i = 0; i <= n; i++)
		{
			for (int w = 0; w <= W; w++)
			{
				int inc = 0, exc = 0;
				if (i == 0 || w == 0)
					dp[i][w] = 0;
				else
				{					
					if (wts[i - 1] <= w)
						inc = prices[i - 1] + dp[i - 1][w - wts[i - 1]];
					
					exc = dp[i - 1][w];
					dp[i][w] = Math.max(inc, exc);
				}													
			}
		}
		
		for (int i = 0; i <= n; i++)
		{
			for (int w = 0; w <= W; w++)
			{
				System.out.print(dp[i][w] + " ");
			}
			System.out.println();
			}
		return dp[n][W];
	}

	public static void main(String[] args) {
		int  prices[] = {5, 20, 20, 10};
		int weights[] = {2, 7, 3, 4};
		int n = 4;
		int required_weight = 11;
		System.out.println(knapcomp(weights, prices, n, required_weight));
		System.out.println(bottomUP(weights, prices, n, required_weight));
	}

}
