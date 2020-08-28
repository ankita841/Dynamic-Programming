package DP;

public class minCoinsNeeded {
	
	//recursive approach
	public static int RecCoinsNeeded(int coins[], int amount, int n)
	{
		if (amount == 0)
			return 0;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++)
		{
			if (amount - coins[i] >= 0)
			{
				int smallerAns = RecCoinsNeeded(coins, amount - coins[i], n);
				if (smallerAns != Integer.MAX_VALUE)
					ans = (ans > smallerAns + 1) ? smallerAns + 1 : ans;
			}
		}
		return ans;		
	}
	
	//Bottom Up DP
	static int BUCoinsNeeded(int coins[], int amount, int n)
	{
		int dp[] = new int[amount + 1];
		for (int i = 0; i <= amount; i++)
			dp[i] = Integer.MAX_VALUE;
		dp[0] = 0;
		for (int rupee = 1; rupee <= amount; rupee++)
		{
			for (int i = 0; i < n; i++)
			{
				if (coins[i] <= rupee)
				{
					int smallAns = dp[rupee - coins[i]];
					if (smallAns != Integer.MAX_VALUE)
						dp[rupee] = (dp[rupee] > smallAns + 1) ? smallAns + 1 : dp[rupee];
				}
			}
		}
		return dp[amount];
	}

	public static void main(String[] args) {
		int us_dollar[] = {1, 7, 10};
		int amount = 15;
		int n = 3;
		System.out.println(RecCoinsNeeded(us_dollar, amount, n));
		System.out.println(BUCoinsNeeded(us_dollar, amount, n));
		
	}

}
