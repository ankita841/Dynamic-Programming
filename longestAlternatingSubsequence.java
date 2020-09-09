package DP;

public class longestAlternatingSubsequence {
	
	static int altSub(int[] a)
	{
		int dp[][] = new int[a.length][2];
		int ans = 0;
		
		dp[0][0] = dp[0][1] = 1;
		
		for (int i = 1; i < a.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (a[i] < a[j])
					dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
				
				if (a[i] > a[j])
					dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
				
				if (ans < Math.max(dp[i][0], dp[i][1]))
					ans  = Math.max(dp[i][0], dp[i][1]);
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 8, 9, 6, 4, 5, 7, 3, 2, 4, 1 };
		System.out.println("Length of Longest Alternating Subsequence is : " + altSub(arr));
	}

}
